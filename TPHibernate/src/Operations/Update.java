
package Operations;

import com.facultad.Alumno;
import com.facultad.Carrera;
import com.facultad.Ciudad;
import com.facultad.Facultad;
import com.facultad.Materia;
import com.facultad.Profesor;
import java.util.List;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Update {
    public static void Ciudad(Scanner scanner, SessionFactory sf) {
        System.out.print("Ingrese el ID de la ciudad a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Ciudad ciudad = GetByID.Ciudad(sf, id);
        if (ciudad == null) {
            System.out.println("No se encontró una ciudad con ID " + id);
            return;
        }
        System.out.print("Ingrese el nuevo nombre de la ciudad: ");
        String nuevoNombre = scanner.nextLine();

        Session session = sf.openSession();
        Transaction trx = session.beginTransaction();
        try {
            ciudad.setNombre(nuevoNombre);
            session.update(ciudad);
            trx.commit();
            System.out.println("Ciudad actualizada: " + ciudad);
        } catch (Exception e) {
            trx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public static void Materia(Scanner scanner, SessionFactory sf) {
        System.out.print("Ingrese el ID de la materia a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Materia materia = GetByID.Materia(sf, id);
        if (materia == null) {
            System.out.println("No se encontró una materia con ID " + id);
            return;
        }
        System.out.print("Ingrese el nuevo nombre de la materia: ");
        String nuevoNombre = scanner.nextLine();
        System.out.print("Ingrese el nuevo nivel de la materia: ");
        String nuevoNivel = scanner.nextLine();
        System.out.print("Ingrese el ID del profesor (0 para ninguno): ");
        int profesorId = scanner.nextInt();
        scanner.nextLine();

        Session session = sf.openSession();
        Transaction trx = session.beginTransaction();
        try {
            materia.setNombre(nuevoNombre);
            materia.setNivel(nuevoNivel);
            if (profesorId == 0) {
                materia.setProfesor(null);
            } else if (profesorId > 0) {
                Profesor profesor = (Profesor) session.get(Profesor.class, profesorId);
                if (profesor != null) {
                    materia.setProfesor(profesor);
                } else {
                    System.out.println("No se encontró profesor con ID " + profesorId + ". Se mantendrá el profesor actual.");
                }
            }
            session.update(materia);
            trx.commit();
            System.out.println("Materia actualizada: " + materia);
        } catch (Exception e) {
            trx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public static void Facultad(Scanner scanner, SessionFactory sf) {
        System.out.print("Ingrese el ID de la facultad a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Facultad facultad = GetByID.Facultad(sf, id);
        if (facultad == null) {
            System.out.println("No se encontró una facultad con ID " + id);
            return;
        }

        System.out.print("Ingrese el nuevo nombre de la facultad: ");
        String nuevoNombre = scanner.nextLine();
        facultad.setNombre(nuevoNombre);

        Session session = sf.openSession();
        Transaction trx = session.beginTransaction();
        try {

            List<Ciudad> ciudades = session.createQuery("from Ciudad").list();
            if (!ciudades.isEmpty()) {
                System.out.println("Seleccione la ciudad de la facultad (0 para mantener la actual):");
                for (int i = 0; i < ciudades.size(); i++) {
                    System.out.println((i + 1) + ". " + ciudades.get(i).getNombre());
                }
                int opcionCiudad = -1;
                do {
                    System.out.print("Número de ciudad: ");
                    try {
                        opcionCiudad = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        opcionCiudad = -1;
                    }
                } while (opcionCiudad < 0 || opcionCiudad > ciudades.size());

                if (opcionCiudad > 0) {
                    facultad.setCiudad(ciudades.get(opcionCiudad - 1));
                }
            }

            session.merge(facultad);
            trx.commit();
            System.out.println("Facultad actualizada: " + facultad);
        } catch (Exception e) {
            trx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public static void Carrera(Scanner scanner, SessionFactory sf) {
        System.out.print("Ingrese el ID de la carrera a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Session session = sf.openSession();
        try {
            Carrera carrera = (Carrera) session.get(Carrera.class, id);
            if (carrera == null) {
                System.out.println("No se encontró una carrera con ID " + id);
                return;
            }

            System.out.print("Ingrese el nuevo nombre de la carrera: ");
            String nuevoNombre = scanner.nextLine();
            carrera.setNombre(nuevoNombre);

            List facultades = session.createQuery("from Facultad").list();

            if (!facultades.isEmpty()) {
                System.out.println("Seleccione la facultad de la carrera (0 para mantener la actual):");
                for (int i = 0; i < facultades.size(); i++) {
                    Facultad f = (Facultad) facultades.get(i);
                    System.out.println((i + 1) + ". " + f.getNombre());
                }

                int opcionFacultad = -1;
                do {
                    System.out.print("Número de facultad: ");
                    try {
                        opcionFacultad = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        opcionFacultad = -1;
                    }
                } while (opcionFacultad < 0 || opcionFacultad > facultades.size());

                if (opcionFacultad > 0) {
                    carrera.setFacultad((Facultad) facultades.get(opcionFacultad - 1));
                }
            }

            Transaction trx = session.beginTransaction();
            try {
                session.update(carrera);
                trx.commit();
                System.out.println("Carrera actualizada: " + carrera);
            } catch (Exception e) {
                trx.rollback();
                throw e;
            }
        } finally {
            session.close();
        }
    }

    public static void Alumno(Scanner scanner, SessionFactory sf) {
        System.out.print("Ingrese el ID del alumno a actualizar: ");
        int id = Integer.parseInt(scanner.nextLine());

        Session session = sf.openSession();
        Alumno alumno = GetByID.Alumno(sf, id);
        if (alumno == null) {
            System.out.println("No se encontró un alumno con ID " + id);
            session.close();
            return;
        }

        System.out.print("Ingrese el nuevo nombre del alumno: ");
        String nuevoNombre = scanner.nextLine();
        alumno.setNombre(nuevoNombre);

        System.out.print("Ingrese el nuevo apellido del alumno: ");
        String nuevoApellido = scanner.nextLine();
        alumno.setApellido(nuevoApellido);

        Transaction trx = session.beginTransaction();
        try {
            session.update(alumno);
            trx.commit();
            System.out.println("Alumno actualizado: " + alumno);
        } catch (Exception e) {
            trx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public static void Profesor(Scanner scanner, SessionFactory sf) {
        System.out.print("Ingrese el ID del profesor a actualizar: ");
        int id = Integer.parseInt(scanner.nextLine());

        Session session = sf.openSession();
        Profesor profesor = GetByID.Profesor(sf, id);
        if (profesor == null) {
            System.out.println("No se encontró un profesor con ID " + id);
            session.close();
            return;
        }

        System.out.print("Ingrese el nuevo nombre del profesor: ");
        String nuevoNombre = scanner.nextLine();
        profesor.setNombre(nuevoNombre);

        System.out.print("Ingrese el nuevo apellido del profesor: ");
        String nuevoApellido = scanner.nextLine();
        profesor.setApellido(nuevoApellido);

        System.out.print("Ingrese la nueva antigüedad del profesor: ");
        int nuevaAntiguedad = Integer.parseInt(scanner.nextLine());
        profesor.setAntiguedad(nuevaAntiguedad);

        Transaction trx = session.beginTransaction();
        try {
            session.update(profesor);
            trx.commit();
            System.out.println("Profesor actualizado: " + profesor);
        } catch (Exception e) {
            trx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }
}
