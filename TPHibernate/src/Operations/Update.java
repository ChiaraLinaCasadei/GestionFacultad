/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operations;

import com.facultad.Ciudad;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author chiar
 */
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
}
