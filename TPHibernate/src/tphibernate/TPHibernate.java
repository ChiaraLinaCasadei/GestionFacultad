package tphibernate;

import java.util.Scanner;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TPHibernate {

    public static void main(String[] args) {
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(java.util.logging.Level.ALL);
        SessionFactory sf = new Configuration().configure().buildSessionFactory();

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
                    menuAlumnos(scanner);
                    break;
                case 2:
                    menuProfesores(scanner);
                    break;
                case 3:
                    menuMaterias(scanner);
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

    private static void menuAlumnos(Scanner scanner) {
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
                    System.out.println("Listar alumnos por apellido...");
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

    private static void menuProfesores(Scanner scanner) {
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
                    System.out.println("Listar profesores por antigüedad...");
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

    private static void menuMaterias(Scanner scanner) {
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
                    int nivel = scanner.nextInt();
                    System.out.println("Listar materias del nivel " + nivel + "...");
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

    public static void crearEntidad (Scanner scanner, String entidad, SessionFactory sf){
        switch (entidad){
            case "Ciudad":
                Operations.Create.Ciudad(scanner, sf);
                break;
            
        }
    }
    
    public static void listarEntidades (String entidad, SessionFactory sf){
        switch (entidad){
            case "Ciudad":
                Operations.GetAll.Ciudades(sf);
                break;
            
        }
    }
    
    public static void eliminarEntidad (Scanner scanner, String entidad, SessionFactory sf){
        switch (entidad){
            case "Ciudad":
                Operations.Delete.Ciudad(scanner, sf);
                break;
            
        }
    }
    
    public static void actualizarEntidad (Scanner scanner, String entidad, SessionFactory sf){
        switch (entidad){
            case "Ciudad":
                Operations.Update.Ciudad(scanner, sf);
                break;
            
        }
    }

}
