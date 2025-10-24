package Operations;

import com.facultad.Ciudad;
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
        
        Ciudad ciudad = new Ciudad (nombreCiudad);
        
        session.save(ciudad);
        
        trx.commit();            
        session.close();
        
    }
}
