package Operations;

import com.facultad.Ciudad;
import com.facultad.Materia;
import com.facultad.Profesor;
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
}
