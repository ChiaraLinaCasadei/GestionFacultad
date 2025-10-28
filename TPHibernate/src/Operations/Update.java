
package Operations;

import com.facultad.Ciudad;
import com.facultad.Materia;
import com.facultad.Profesor;
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
}
