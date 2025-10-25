
package Operations;

import com.facultad.Ciudad;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class GetAll {
    public static void Ciudades(SessionFactory sf) {
        Session session = sf.openSession();
        try {
            List<Ciudad> ciudades = session.createQuery("from Ciudad").list();
            for (Ciudad c : ciudades) {
                System.out.println(c);
            }
        } finally {
            session.close();
        }
    }
}
