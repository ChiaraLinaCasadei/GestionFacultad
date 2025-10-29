package Operations;

import com.facultad.Alumno;
import com.facultad.Ciudad;
import com.facultad.Facultad;
import com.facultad.Materia;
import com.facultad.Profesor;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class Create {
     public static void Ciudad(Scanner scanner, SessionFactory sf) {
        System.out.print("Ingrese el nombre de la ciudad: ");
        String nombreCiudad = scanner.nextLine();

        Session session = sf.openSession();
        Transaction trx = session.beginTransaction();
        try {
            Ciudad ciudad = new Ciudad(nombreCiudad);
            session.save(ciudad);
            trx.commit();
            System.out.println("Ciudad creada: " + ciudad);
        } catch (Exception e) {
            trx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public static void Materia(Scanner scanner, SessionFactory sf) {
        System.out.print("Ingrese el nombre de la materia: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el nivel de la materia: ");
        String nivel = scanner.nextLine();
        System.out.print("Ingrese el ID del profesor (0 para ninguno): ");
        int profesorId = scanner.nextInt();
        scanner.nextLine();

        Session session = sf.openSession();
        Transaction trx = session.beginTransaction();
        try {
            Materia materia = new Materia();
            materia.setNombre(nombre);
            materia.setNivel(nivel);
            if (profesorId > 0) {
                Profesor profesor = (Profesor) session.get(Profesor.class, profesorId);
                if (profesor != null) {
                    materia.setProfesor(profesor);
                } else {
                    System.out.println("No se encontró profesor con ID " + profesorId + ". Se creará la materia sin profesor.");
                }
            }
            session.save(materia);
            trx.commit();
            System.out.println("Materia creada: " + materia);
        } catch (Exception e) {
            trx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public static void Facultad(Scanner scanner, SessionFactory sf) {
        System.out.print("Ingrese el nombre de la facultad: ");
        String nombreFacultad = scanner.nextLine();

        Session session = sf.openSession();
        List<Ciudad> ciudades = session.createQuery("from Ciudad").list();
        session.close();

        if (ciudades.isEmpty()) {
            System.out.println("No hay ciudades cargadas. Primero cree una ciudad.");
            return;
        }

        System.out.println("Seleccione la ciudad de la facultad:");
        for (int i = 0; i < ciudades.size(); i++) {
            System.out.println((i + 1) + ". " + ciudades.get(i).getNombre());
        }

        int opcionCiudad = -1;
        do {
            System.out.print("Ingrese número de ciudad: ");
            try {
                opcionCiudad = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                opcionCiudad = -1;
            }
        } while (opcionCiudad < 1 || opcionCiudad > ciudades.size());

        Ciudad ciudadSeleccionada = ciudades.get(opcionCiudad - 1);

        session = sf.openSession();
        Transaction trx = session.beginTransaction();
        try {
            Facultad facultad = new Facultad(nombreFacultad, ciudadSeleccionada);
            session.save(facultad);
            trx.commit();
            System.out.println("Facultad creada: " + facultad);
        } catch (Exception e) {
            trx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public static void Carrera(Scanner scanner, SessionFactory sf) {
        System.out.print("Ingrese el nombre de la carrera: ");
        String nombre = scanner.nextLine();

        int facultadId = -1;
        while (facultadId < 1) {
            System.out.print("Ingrese el ID de la facultad a la que pertenece: ");
            String input = scanner.nextLine();
            try {
                facultadId = Integer.parseInt(input);
                if (facultadId < 1) {
                    System.out.println("Ingrese un número mayor a 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida, ingrese un número.");
            }
        }

        Session session = sf.openSession();
        Transaction trx = session.beginTransaction();

        try {
            com.facultad.Facultad facultad = (com.facultad.Facultad) session.get(com.facultad.Facultad.class, facultadId);
            if (facultad == null) {
                System.out.println("No se encontró una facultad con ID " + facultadId);
                trx.rollback();
                return;
            }

            com.facultad.Carrera carrera = new com.facultad.Carrera();
            carrera.setNombre(nombre);
            carrera.setFacultad(facultad);

            session.save(carrera);
            trx.commit();
            System.out.println("Carrera creada: " + carrera);
        } catch (Exception e) {
            trx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public static void Alumno(Scanner scanner, SessionFactory sf) {
        System.out.print("Ingrese el nombre del alumno: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el apellido del alumno: ");
        String apellido = scanner.nextLine();

        System.out.print("Ingrese el DNI del alumno: ");
        String dni = scanner.nextLine();

        Date fechaNacimiento = null;
        while (fechaNacimiento == null) {
            System.out.print("Ingrese la fecha de nacimiento (dd/MM/yyyy): ");
            String fechaStr = scanner.nextLine();
            try {
                fechaNacimiento = new java.text.SimpleDateFormat("dd/MM/yyyy").parse(fechaStr);
            } catch (Exception e) {
                System.out.println("Formato inválido. Intente nuevamente.");
            }
        }

        System.out.print("Ingrese el número de legajo: ");
        int numeroLegajo = Integer.parseInt(scanner.nextLine());

        System.out.print("Ingrese el año de ingreso: ");
        int anioEgreso = Integer.parseInt(scanner.nextLine());

        Session session = sf.openSession();
        Transaction trx = session.beginTransaction();
        try {

            List<Ciudad> ciudades = session.createQuery("FROM Ciudad").list();

            if (ciudades.isEmpty()) {
                System.out.println("No hay ciudades cargadas. Primero cree una ciudad.");
                trx.rollback();
                session.close();
                return;
            }

            System.out.println("Seleccione la ciudad del alumno:");
            for (int i = 0; i < ciudades.size(); i++) {
                System.out.println((i + 1) + ". " + ciudades.get(i).getNombre());
            }

            int opcionCiudad = -1;
            Ciudad ciudadSeleccionada = null;
            do {
                System.out.print("Número de ciudad: ");
                try {
                    opcionCiudad = Integer.parseInt(scanner.nextLine());
                    if (opcionCiudad >= 1 && opcionCiudad <= ciudades.size()) {
                        ciudadSeleccionada = ciudades.get(opcionCiudad - 1);
                    }
                } catch (NumberFormatException e) {
                    opcionCiudad = -1;
                }
            } while (ciudadSeleccionada == null);

            Alumno alumno = new Alumno();
            alumno.setNombre(nombre);
            alumno.setApellido(apellido);
            alumno.setDni(dni);
            alumno.setFechaNacimiento(fechaNacimiento);
            alumno.setNumeroLegajo(numeroLegajo);
            alumno.setAnioIngreso(anioEgreso);
            alumno.setCiudad(ciudadSeleccionada);

            session.save(alumno);
            trx.commit();
            System.out.println("Alumno creado: " + alumno);
        } catch (Exception e) {
            trx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public static void Profesor(Scanner scanner, SessionFactory sf) {
        System.out.print("Ingrese el nombre del profesor: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el apellido del profesor: ");
        String apellido = scanner.nextLine();

        System.out.print("Ingrese el DNI del profesor: ");
        String dni = scanner.nextLine();

        Date fechaNacimiento = null;
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        boolean fechaValida = false;
        do {
            System.out.print("Ingrese la fecha de nacimiento (dd/MM/yyyy): ");
            String fechaStr = scanner.nextLine();
            try {
                fechaNacimiento = sdf.parse(fechaStr);
                fechaValida = true;
            } catch (Exception e) {
                System.out.println("Formato inválido. Intente nuevamente.");
            }
        } while (!fechaValida);

        int antiguedad = -1;
        while (antiguedad < 0) {
            System.out.print("Ingrese los años de antigüedad del profesor: ");
            try {
                antiguedad = Integer.parseInt(scanner.nextLine());
                if (antiguedad < 0) {
                    System.out.println("La antigüedad no puede ser negativa.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Debe ingresar un número entero.");
            }
        }

        Session session = sf.openSession();
        Transaction trx = session.beginTransaction();
        try {
            List<Ciudad> ciudades = session.createQuery("from Ciudad").list();

            if (ciudades.isEmpty()) {
                System.out.println("No hay ciudades cargadas. Primero cree una ciudad.");
                trx.rollback();
                session.close();
                return;
            }

            System.out.println("Seleccione la ciudad del profesor:");
            for (int i = 0; i < ciudades.size(); i++) {
                System.out.println((i + 1) + ". " + ciudades.get(i).getNombre());
            }

            int opcionCiudad = -1;
            Ciudad ciudadSeleccionada = null;
            do {
                System.out.print("Número de ciudad: ");
                try {
                    opcionCiudad = Integer.parseInt(scanner.nextLine());
                    if (opcionCiudad >= 1 && opcionCiudad <= ciudades.size()) {
                        ciudadSeleccionada = ciudades.get(opcionCiudad - 1);
                    }
                } catch (NumberFormatException e) {
                    opcionCiudad = -1;
                }
            } while (ciudadSeleccionada == null);

            Profesor profesor = new Profesor();
            profesor.setNombre(nombre);
            profesor.setApellido(apellido);
            profesor.setDni(dni);
            profesor.setFechaNacimiento(fechaNacimiento);
            profesor.setAntiguedad(antiguedad);
            profesor.setCiudad(ciudadSeleccionada);

            session.save(profesor);
            trx.commit();
            System.out.println("Profesor creado: " + profesor);
        } catch (Exception e) {
            trx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }
}
