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

    public static Facultad Facultad(SessionFactory sf, int id) {
        Session session = sf.openSession();
        try {
            return (Facultad) session.get(Facultad.class, id);
        } finally {
            session.close();
        }
    }

    public static Carrera Carrera(SessionFactory sf, int id) {
        Session session = sf.openSession();
        try {
            return (Carrera) session.get(Carrera.class, id);
        } finally {
            session.close();
        }
    }

    public static Alumno Alumno(SessionFactory sf, int id) {
        Session session = sf.openSession();
        try {
            return (Alumno) session.get(Alumno.class, id);
        } finally {
            session.close();
        }
    }

    public static Profesor Profesor(SessionFactory sf, int id) {
        Session session = sf.openSession();
        try {
            return (Profesor) session.get(Profesor.class, id);
        } finally {
            session.close();
        }
    }
}
