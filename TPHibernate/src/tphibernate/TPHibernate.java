package tphibernate;

import java.time.LocalDate;
import java.util.Scanner;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.facultad.Ciudad;
import com.facultad.Profesor;
import com.facultad.Materia;
import com.facultad.Alumno;
import com.facultad.Carrera;
import com.facultad.Facultad;

public class TPHibernate {

    public static void main(String[] args) {
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(java.util.logging.Level.ALL);
        SessionFactory sf = new Configuration().configure().buildSessionFactory();

        seed(sf);
        Scanner scanner = new Scanner(System.in);

        int opcion = -1;

        do {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Alumnos");
            System.out.println("2. Profesores");
            System.out.println("3. Materias");
            System.out.println("4. Ciudades");
            System.out.println("5. Carreras");
            System.out.println("6. Facultades");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = validarInput(scanner);

            switch (opcion) {
                case 1:
                    menuAlumnos(scanner, sf);
                    break;
                case 2:
                    menuProfesores(scanner, sf);
                    break;
                case 3:
                    menuMaterias(scanner, sf);
                    break;
                case 4:
                    menuGenerico(scanner, "Ciudad", sf);
                    break;
                case 5:
                    menuGenerico(scanner, "Carrera", sf);
                    break;
                case 6:
                    menuGenerico(scanner, "Facultad", sf);
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        } while (opcion != 0);

        sf.close();
    }

    private static int validarInput(Scanner scanner) {
        while (true) {
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida. Ingrese un número: ");
            }
        }
    }

    private static void menuAlumnos(Scanner scanner, SessionFactory sf) {
        int opcion;
        do {
            System.out.println("\n--- MENÚ ALUMNOS ---");
            System.out.println("1. Crear alumno");
            System.out.println("2. Actualizar alumno");
            System.out.println("3. Borrar alumno");
            System.out.println("4. Listar todos");
            System.out.println("5. Listar ordenados por apellido");
            System.out.println("0. Volver");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Crear alumno...");
                    break;
                case 2:
                    System.out.println("Actualizar alumno...");
                    break;
                case 3:
                    System.out.println("Borrar alumno...");
                    break;
                case 4:
                    System.out.println("Listar todos los alumnos...");
                    break;
                case 5:
                    Operations.GetAll.AlumnosOrdenadosPorApellido(sf);
                    break;
                case 0: {
                }
                break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        } while (opcion != 0);
    }

    private static void menuProfesores(Scanner scanner, SessionFactory sf) {
        int opcion;
        do {
            System.out.println("\n--- MENÚ PROFESORES ---");
            System.out.println("1. Crear profesor");
            System.out.println("2. Actualizar profesor");
            System.out.println("3. Borrar profesor");
            System.out.println("4. Listar todos");
            System.out.println("5. Listar ordenados por antigüedad");
            System.out.println("0. Volver");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Crear profesor...");
                    break;
                case 2:
                    System.out.println("Actualizar profesor...");
                    break;
                case 3:
                    System.out.println("Borrar profesor...");
                    break;
                case 4:
                    System.out.println("Listar todos los profesores...");
                    break;
                case 5:
                    Operations.GetAll.ProfesoresOrdenadosPorAntiguedad(sf);
                    break;
                case 0: {
                }
                break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        } while (opcion != 0);
    }

    private static void menuMaterias(Scanner scanner, SessionFactory sf) {
        int opcion;
        do {
            System.out.println("\n--- MENÚ MATERIAS ---");
            System.out.println("1. Crear materia");
            System.out.println("2. Actualizar materia");
            System.out.println("3. Borrar materia");
            System.out.println("4. Listar todas");
            System.out.println("5. Obtener materias por nivel");
            System.out.println("0. Volver");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Crear materia...");
                    break;
                case 2:
                    System.out.println("Actualizar materia...");
                    break;
                case 3:
                    System.out.println("Borrar materia...");
                    break;
                case 4:
                    System.out.println("Listar todas las materias...");
                    break;
                case 5: {
                    System.out.print("Ingrese nivel: ");
                    String nivel = scanner.nextLine();
                    Operations.GetAll.MateriasPorNivel(sf, nivel);
                    break;
                }
                case 0: {
                }
                break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        } while (opcion != 0);
    }

    private static void menuGenerico(Scanner scanner, String entidad, SessionFactory sf) {
        int opcion;
        do {
            System.out.println("\n--- MENÚ " + entidad.toUpperCase() + " ---");
            System.out.println("1. Crear " + entidad);
            System.out.println("2. Actualizar " + entidad);
            System.out.println("3. Borrar " + entidad);
            System.out.println("4. Listar todas");
            System.out.println("0. Volver");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    crearEntidad(scanner, entidad, sf);
                    break;
                case 2:
                    actualizarEntidad(scanner, entidad, sf);
                    break;
                case 3:
                    eliminarEntidad(scanner, entidad, sf);
                    break;
                case 4:
                    listarEntidades(entidad, sf);
                    break;
                case 0: {
                }
                break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        } while (opcion != 0);
    }

    public static void crearEntidad(Scanner scanner, String entidad, SessionFactory sf) {
        switch (entidad) {
            case "Ciudad":
                Operations.Create.Ciudad(scanner, sf);
                break;

        }
    }

    public static void listarEntidades(String entidad, SessionFactory sf) {
        switch (entidad) {
            case "Ciudad":
                Operations.GetAll.Ciudades(sf);
                break;

        }
    }

    public static void eliminarEntidad(Scanner scanner, String entidad, SessionFactory sf) {
        switch (entidad) {
            case "Ciudad":
                Operations.Delete.Ciudad(scanner, sf);
                break;

        }
    }

    public static void actualizarEntidad(Scanner scanner, String entidad, SessionFactory sf) {
        switch (entidad) {
            case "Ciudad":
                Operations.Update.Ciudad(scanner, sf);
                break;

        }
    }

    public static void seed(SessionFactory sf) {
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        try {
            // Ciudades
            Ciudad rosario = new Ciudad("Rosario");
            Ciudad cordoba = new Ciudad("Córdoba");
            session.save(rosario);
            session.save(cordoba);

            // Facultades
            Facultad fceia = new Facultad(null, "FCEIA", rosario);
            Facultad famaf = new Facultad(null, "FaMAF", cordoba);
            session.save(fceia);
            session.save(famaf);

            // Profesores
            Profesor prof1 = new Profesor(
                    10,
                    null,
                    "García",
                    "Ana",
                    "12345678",
                    LocalDate.of(1980, 1, 15),
                    rosario
            );
            Profesor prof2 = new Profesor(
                    5,
                    null,
                    "Pérez",
                    "Juan",
                    "23456789",
                    LocalDate.of(1985, 5, 20),
                    cordoba
            );
            session.save(prof1);
            session.save(prof2);

            // Alumnos
            Alumno alu1 = new Alumno(
                    1001,
                    2022,
                    null,
                    "López",
                    "María",
                    "30111222",
                    LocalDate.of(2000, 3, 10),
                    rosario
            );
            Alumno alu2 = new Alumno(
                    1002,
                    2023,
                    null,
                    "Santos",
                    "Pedro",
                    "30999888",
                    LocalDate.of(2001, 7, 22),
                    cordoba
            );
            Alumno alu3 = new Alumno(
                    1003,
                    2021,
                    null,
                    "Álvarez",
                    "Lucía",
                    "29888777",
                    LocalDate.of(1999, 12, 5),
                    rosario
            );
            // Persistir alumnos por cascada desde Materia

            // Materias y asociación con alumnos y profesores
            Materia mat1 = new Materia();
            mat1.setNombre("Matemática I");
            mat1.setNivel("1");
            mat1.setProfesor(prof1);
            mat1.getAlumnos().add(alu1);
            mat1.getAlumnos().add(alu2);

            Materia mat2 = new Materia();
            mat2.setNombre("Programación");
            mat2.setNivel("2");
            mat2.setProfesor(prof2);
            mat2.getAlumnos().add(alu2);
            mat2.getAlumnos().add(alu3);

            // Carrera que agrupa materias (cascade a materias y a su vez a alumnos)
            Carrera sis = new Carrera(null, "Ingeniería en Sistemas", fceia, new java.util.ArrayList<>());
            sis.getMaterias().add(mat1);
            sis.getMaterias().add(mat2);

            // Persistimos la Carrera para disparar las cascadas
            session.save(sis);

            tx.commit();
            System.out.println("Seed completado (todas las entidades principales).");
        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }
}
