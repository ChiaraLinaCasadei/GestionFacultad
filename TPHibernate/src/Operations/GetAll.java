
package Operations;

import com.facultad.Ciudad;
import com.facultad.Alumno;
import com.facultad.Profesor;
import com.facultad.Materia;
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

    public static void AlumnosOrdenadosPorApellido(SessionFactory sf) {
        Session session = sf.openSession();
        try {
            List<Alumno> alumnos = session
                .createQuery("from Alumno a order by a.apellido asc")
                .list();
            for (Alumno a : alumnos) {
                System.out.println(a);
            }
        } finally {
            session.close();
        }
    }

    public static void ProfesoresOrdenadosPorAntiguedad(SessionFactory sf) {
        Session session = sf.openSession();
        try {
            List<Profesor> profesores = session
                .createQuery("from Profesor p order by p.antiguedad desc")
                .list();
            for (Profesor p : profesores) {
                System.out.println(p);
            }
        } finally {
            session.close();
        }
    }

    public static void MateriasPorNivel(SessionFactory sf, String nivel) {
        Session session = sf.openSession();
        try {
            List<Materia> materias = session
                .createQuery("from Materia m where m.nivel = :nivel")
                .setParameter("nivel", nivel)
                .list();
            for (Materia m : materias) {
                System.out.println(m);
            }
        } finally {
            session.close();
        }
    }
}

