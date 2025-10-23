/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tphibernate;

import java.util.Scanner;

/**
 *
 * @author chiar
 */
public class TPHibernate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;

        do {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Alumnos");
            System.out.println("2. Profesores");
            System.out.println("3. Materias");
            System.out.println("4. Ciudades");
            System.out.println("5. Carreras");
            System.out.println("6. Facultades");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = validarInput(scanner);

            switch (opcion) {
                case 1:
                    menuAlumnos(scanner);
                    break;
                case 2:
                    menuProfesores(scanner);
                    break;
                case 3:
                    menuMaterias(scanner);
                    break;
                case 4:
                    menuGenerico(scanner, "Ciudad");
                    break;
                case 5:
                    menuGenerico(scanner, "Carrera");
                    break;
                case 6:
                    menuGenerico(scanner, "Facultad");
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        } while (opcion != 0);
    }

    private static int validarInput(Scanner scanner) {
        while (true) {
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida. Ingrese un número: ");
            }
        }
    }

    private static void menuAlumnos(Scanner scanner) {
        int opcion;
        do {
            System.out.println("\n--- MENÚ ALUMNOS ---");
            System.out.println("1. Crear alumno");
            System.out.println("2. Actualizar alumno");
            System.out.println("3. Borrar alumno");
            System.out.println("4. Listar todos");
            System.out.println("5. Listar ordenados por apellido");
            System.out.println("0. Volver");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Crear alumno...");
                    break;
                case 2:
                    System.out.println("Actualizar alumno...");
                    break;
                case 3:
                    System.out.println("Borrar alumno...");
                    break;
                case 4:
                    System.out.println("Listar todos los alumnos...");
                    break;
                case 5:
                    System.out.println("Listar alumnos por apellido...");
                    break;
                case 0 :
                    {}
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        } while (opcion != 0);
    }

    private static void menuProfesores(Scanner scanner) {
        int opcion;
        do {
            System.out.println("\n--- MENÚ PROFESORES ---");
            System.out.println("1. Crear profesor");
            System.out.println("2. Actualizar profesor");
            System.out.println("3. Borrar profesor");
            System.out.println("4. Listar todos");
            System.out.println("5. Listar ordenados por antigüedad");
            System.out.println("0. Volver");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Crear profesor...");
                    break;
                case 2:
                    System.out.println("Actualizar profesor...");
                    break;
                case 3:
                    System.out.println("Borrar profesor...");
                    break;
                case 4:
                    System.out.println("Listar todos los profesores...");
                    break;
                case 5:
                    System.out.println("Listar profesores por antigüedad...");
                    break;
                case 0:
                    {}
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        } while (opcion != 0);
    }

    private static void menuMaterias(Scanner scanner) {
        int opcion;
        do {
            System.out.println("\n--- MENÚ MATERIAS ---");
            System.out.println("1. Crear materia");
            System.out.println("2. Actualizar materia");
            System.out.println("3. Borrar materia");
            System.out.println("4. Listar todas");
            System.out.println("5. Obtener materias por nivel");
            System.out.println("0. Volver");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Crear materia...");
                    break;
                case 2:
                    System.out.println("Actualizar materia...");
                    break;
                case 3:
                    System.out.println("Borrar materia...");
                    break;
                case 4:
                    System.out.println("Listar todas las materias...");
                    break;
                case 5:{
                    System.out.print("Ingrese nivel: ");
                    int nivel = scanner.nextInt();
                    System.out.println("Listar materias del nivel " + nivel + "...");
                }
                case 0:
                      {}
                      break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        } while (opcion != 0);
    }

    private static void menuGenerico(Scanner scanner, String entidad) {
        int opcion;
        do {
            System.out.println("\n--- MENÚ " + entidad.toUpperCase() + " ---");
            System.out.println("1. Crear " + entidad);
            System.out.println("2. Actualizar " + entidad);
            System.out.println("3. Borrar " + entidad);
            System.out.println("4. Listar todas");
            System.out.println("0. Volver");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Crear " + entidad + "...");
                    break;
                case 2:
                    System.out.println("Actualizar " + entidad + "...");
                    break;
                case 3:
                    System.out.println("Borrar " + entidad + "...");
                    break;
                case 4:
                    System.out.println("Listar todas las " + entidad + "s...");
                    break;
                case 0:
                    {}
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        } while (opcion != 0);
    }

}
