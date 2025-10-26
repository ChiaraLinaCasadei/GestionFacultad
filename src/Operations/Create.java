package Operations;

import com.facultad.Ciudad;
import com.facultad.Facultad;
import java.util.List;
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

    public static void Facultad(Scanner scanner, SessionFactory sf) {
        System.out.print("Ingrese el nombre de la facultad: ");
        String nombreFacultad = scanner.nextLine();

        Session session = sf.openSession();
        List<Ciudad> ciudades = session.createQuery("from Ciudad").list();
        session.close();

        if (ciudades.isEmpty()) {
            System.out.println("No hay ciudades cargadas. Primero cree una ciudad.");
            return;
        }

        System.out.println("Seleccione la ciudad de la facultad:");
        for (int i = 0; i < ciudades.size(); i++) {
            System.out.println((i + 1) + ". " + ciudades.get(i).getNombre());
        }

        int opcionCiudad = -1;
        do {
            System.out.print("Ingrese número de ciudad: ");
            try {
                opcionCiudad = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                opcionCiudad = -1;
            }
        } while (opcionCiudad < 1 || opcionCiudad > ciudades.size());

        Ciudad ciudadSeleccionada = ciudades.get(opcionCiudad - 1);

        session = sf.openSession();
        Transaction trx = session.beginTransaction();
        try {
            Facultad facultad = new Facultad(nombreFacultad, ciudadSeleccionada);
            session.save(facultad);
            trx.commit();
            System.out.println("Facultad creada: " + facultad);
        } catch (Exception e) {
            trx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }
}
