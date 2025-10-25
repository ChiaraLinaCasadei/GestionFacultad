package Operations;

import com.facultad.Ciudad;
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
}
