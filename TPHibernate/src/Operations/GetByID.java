package Operations;

import com.facultad.Ciudad;
import com.facultad.Materia;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class GetByID {
    public static Ciudad Ciudad(SessionFactory sf, int id) {
        Session session = sf.openSession();
        try {
            return (Ciudad) session.get(Ciudad.class, id);
        } finally {
            session.close();
        }
    }

    public static Materia Materia(SessionFactory sf, int id) {
        Session session = sf.openSession();
        try {
            return (Materia) session.get(Materia.class, id);
        } finally {
            session.close();
        }
    }
}
