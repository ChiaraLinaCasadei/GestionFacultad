package Operations;

import com.facultad.Alumno;
import com.facultad.Ciudad;
import com.facultad.Facultad;
import com.facultad.Materia;
import com.facultad.Profesor;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Delete {
    public static void Ciudad(Scanner scanner, SessionFactory sf) {
        System.out.print("Ingrese el ID de la ciudad a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Ciudad ciudad = GetByID.Ciudad(sf, id);
        if (ciudad == null) {
            System.out.println("No se encontró una ciudad con ID " + id);
            return;
        }

        Session session = sf.openSession();
        Transaction trx = session.beginTransaction();
        try {
            session.delete(ciudad);
            trx.commit();
            System.out.println("Ciudad eliminada: " + ciudad);
        } catch (Exception e) {
            trx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public static void Materia(Scanner scanner, SessionFactory sf) {
        System.out.print("Ingrese el ID de la materia a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Materia materia = GetByID.Materia(sf, id);
        if (materia == null) {
            System.out.println("No se encontró una materia con ID " + id);
            return;
        }

        Session session = sf.openSession();
        Transaction trx = session.beginTransaction();
        try {
            session.delete(materia);
            trx.commit();
            System.out.println("Materia eliminada: " + materia);
        } catch (Exception e) {
            trx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public static void Facultad(Scanner scanner, SessionFactory sf) {
        Session session = sf.openSession();
        Transaction trx = null;
        try {
            System.out.print("Ingrese el ID de la facultad a eliminar: ");
            int id = Integer.parseInt(scanner.nextLine());

            Facultad facultad = (Facultad) session.get(Facultad.class, id);
            if (facultad == null) {
                System.out.println("No existe una facultad con ID " + id);
                return;
            }

            trx = session.beginTransaction();
            session.delete(facultad);
            trx.commit();
            System.out.println("Facultad eliminada: " + facultad);

        } catch (Exception e) {
            if (trx != null) {
                trx.rollback();
            }
            System.out.println("Error al eliminar la facultad: " + e.getMessage());
        } finally {
            session.close();
        }
    }

    public static void Carrera(Scanner scanner, SessionFactory sf) {
        System.out.print("Ingrese el ID de la carrera que desea eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Session session = sf.openSession();
        Transaction trx = session.beginTransaction();

        try {
            com.facultad.Carrera carrera = (com.facultad.Carrera) session.get(com.facultad.Carrera.class, id);

            if (carrera != null) {
                session.delete(carrera);
                trx.commit();
                System.out.println("Carrera eliminada correctamente: " + carrera.getNombre());
            } else {
                System.out.println("No se encontró una carrera con el ID " + id);
                trx.rollback();
            }
        } catch (Exception e) {
            trx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public static void Alumno(Scanner scanner, SessionFactory sf) {
        System.out.print("Ingrese el ID del alumno a eliminar: ");
        int id = Integer.parseInt(scanner.nextLine());

        Session session = sf.openSession();
        Transaction trx = session.beginTransaction();

        try {
            Alumno alumno = (Alumno) session.get(Alumno.class, id);
            if (alumno == null) {
                System.out.println("No se encontró un alumno con ID " + id);
                trx.rollback();
                return;
            }

            session.delete(alumno);
            trx.commit();
            System.out.println("Alumno eliminado: " + alumno);

        } catch (Exception e) {
            trx.rollback();
            System.out.println("Error al eliminar el alumno: " + e.getMessage());
        } finally {
            session.close();
        }
    }

    public static void Profesor(Scanner scanner, SessionFactory sf) {
        System.out.print("Ingrese el ID del profesor a eliminar: ");
        int id = -1;
        try {
            id = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("ID inválido.");
            return;
        }

        Session session = sf.openSession();
        Transaction trx = null;
        try {
            Profesor profesor = (Profesor) session.get(Profesor.class, id);
            if (profesor == null) {
                System.out.println("No existe un profesor con ID " + id);
                return;
            }

            trx = session.beginTransaction();
            session.delete(profesor);
            trx.commit();
            System.out.println("Profesor eliminado: " + profesor);
        } catch (Exception e) {
            if (trx != null) {
                trx.rollback();
            }
            System.out.println("Error al eliminar el profesor: " + e.getMessage());
        } finally {
            session.close();
        }
    }
}
