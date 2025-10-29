package Operations;

import com.facultad.Alumno;
import com.facultad.Carrera;
import com.facultad.Ciudad;
import com.facultad.Facultad;
import com.facultad.Materia;
import com.facultad.Profesor;
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

    public static void Materias(SessionFactory sf) {
        String jpqlQuery = "Select Distinct m from Materia m " +
                   "left join fetch m.profesor p " +
                   "left join fetch m.alumnos a " +
                   "left join fetch a.ciudad "   +
                   "left join fetch p.ciudad ";
        Session session = sf.openSession();
        try {
            List<Materia> materias = session.createQuery(jpqlQuery).list();
            for (Materia m : materias) {
                System.out.println(m);
            }
        } finally {
            session.close();
        }
    }

    public static void Facultades(SessionFactory sf) {
        Session session = sf.openSession();
        try {
            List<Facultad> facultades = session.createQuery("from Facultad f join fetch f.ciudad").list();
            for (Facultad f : facultades) {
                System.out.println(f);
            }
        } finally {
            session.close();
        }
    }

    public static void Carreras(SessionFactory sf) {
        String carreraQuery = "Select Distinct c from Carrera c " +
                   "left join fetch c.materias " +
                   "left join fetch c.facultad ";
        Session session = sf.openSession();
        try {
            List<Carrera> carreras = (List<Carrera>) session.createQuery(carreraQuery).list();

            if (carreras.isEmpty()) {
                System.out.println("No hay carreras registradas.");
            } else {
                System.out.println("Listado de carreras:");
                for (Carrera c : carreras) {
                    System.out.println("ID: " + c.getId()
                            + " | Nombre: " + c.getNombre()
                            + " | Facultad: " + (c.getFacultad() != null ? c.getFacultad().getNombre() : "Sin facultad"));
                }
            }

        } catch (Exception e) {
            System.out.println("Error al obtener las carreras: " + e.getMessage());
        } finally {
            session.close();
        }
    }

    public static void Profesores(SessionFactory sf) {
        Session session = sf.openSession();
        try {
            List<Profesor> profesores = session.createQuery("from Profesor p join fetch p.ciudad").list();
            for (Profesor p : profesores) {
                System.out.println(p);
            }
        } finally {
            session.close();
        }
    }

    public static void Alumnos(SessionFactory sf) {
        Session session = sf.openSession();
        try {
            List<Alumno> alumnos = session.createQuery("from Alumno a Join fetch a.ciudad").list();
            for (Alumno a : alumnos) {
                System.out.println(a);
            }
        } finally {
            session.close();
        }
    }

    public static void AlumnosOrdenadosPorApellido(SessionFactory sf) {
        String alumHql = "from Alumno a Join fetch a.ciudad order by a.apellido asc";
        Session session = sf.openSession();
        try {
            List<Alumno> alumnos = session.createQuery(alumHql).list();
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
                    .createQuery("from Profesor p Join fetch p.ciudad order by p.antiguedad desc")
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
