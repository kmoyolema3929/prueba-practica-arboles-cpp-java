// Main.java

import java.util.Scanner;

/**
 * Clase principal con el menu interactivo
 * Permite al usuario gestionar estudiantes mediante un arbol binario
 */
public class Main {
    private static ArbolBinarioBusqueda arbol = new ArbolBinarioBusqueda();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("  SISTEMA DE GESTION DE ESTUDIANTES");
        System.out.println("  Universidad Tecnica de Ambato");
        System.out.println("=========================================");
        
        int opcion;
        do {
            mostrarMenu();
            opcion = leerOpcion();
            procesarOpcion(opcion);
        } while (opcion != 14);  // 14 es la opcion para salir
        
        System.out.println("\nGracias por usar el sistema!");
        scanner.close();
    }

    // Muestra todas las opciones del menu
    private static void mostrarMenu() {
        System.out.println("\n========== MENU PRINCIPAL ==========");
        System.out.println("1. Insertar estudiante");
        System.out.println("2. Buscar estudiante por cedula");
        System.out.println("3. Eliminar estudiante");
        System.out.println("4. Recorrido Inorden");
        System.out.println("5. Recorrido Preorden");
        System.out.println("6. Recorrido Postorden");
        System.out.println("7. Recorrido por niveles (BFS)");
        System.out.println("8. Contar estudiantes");
        System.out.println("9. Calcular altura del arbol");
        System.out.println("10. Mostrar estudiante con mayor nota");
        System.out.println("11. Mostrar estudiante con menor nota");
        System.out.println("12. Mostrar estudiantes aprobados");
        System.out.println("13. Mostrar estudiantes reprobados");
        System.out.println("14. Salir");
        System.out.println("=====================================");
        System.out.print("Seleccione una opcion: ");
    }

    // Lee y valida la opcion ingresada por el usuario
    private static int leerOpcion() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;  // Retorna -1 si no es un numero valido
        }
    }

    // Procesa la opcion seleccionada por el usuario
    private static void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                insertarEstudiante();
                break;
            case 2:
                buscarEstudiante();
                break;
            case 3:
                eliminarEstudiante();
                break;
            case 4:
                arbol.recorridoInorden();
                break;
            case 5:
                arbol.recorridoPreorden();
                break;
            case 6:
                arbol.recorridoPostorden();
                break;
            case 7:
                arbol.recorridoPorNiveles();
                break;
            case 8:
                System.out.println("\nTotal de estudiantes: " + arbol.contarNodos());
                break;
            case 9:
                System.out.println("\nAltura del arbol: " + arbol.calcularAltura());
                break;
            case 10:
                arbol.buscarNotaMayor();
                break;
            case 11:
                arbol.buscarNotaMenor();
                break;
            case 12:
                arbol.mostrarAprobados();
                break;
            case 13:
                arbol.mostrarReprobados();
                break;
            case 14:
                System.out.println("\nSaliendo del sistema...");
                break;
            default:
                System.out.println("\nOpcion no valida. Intente nuevamente.");
        }
    }

    // Solicita los datos del estudiante y lo inserta en el arbol
    private static void insertarEstudiante() {
        System.out.println("\n=== INSERTAR ESTUDIANTE ===");
        
        System.out.print("Ingrese cedula: ");
        String cedula = scanner.nextLine();
        
        // Verificamos si ya existe un estudiante con esa cedula
        if (arbol.buscarEstudiante(cedula) != null) {
            System.out.println("Error: Ya existe un estudiante con esa cedula.");
            return;
        }
        
        System.out.print("Ingrese apellidos: ");
        String apellidos = scanner.nextLine();
        
        System.out.print("Ingrese nombres: ");
        String nombres = scanner.nextLine();
        
        System.out.print("Ingrese nota final (0-10): ");
        double notaFinal;
        try {
            notaFinal = Double.parseDouble(scanner.nextLine());
            // Validamos que la nota este en el rango correcto
            if (notaFinal < 0 || notaFinal > 10) {
                System.out.println("Error: La nota debe estar entre 0 y 10.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Ingrese un numero valido.");
            return;
        }
        
        System.out.print("Ingrese carrera: ");
        String carrera = scanner.nextLine();
        
        System.out.print("Ingrese nivel: ");
        String nivel = scanner.nextLine();
        
        // Creamos el estudiante y lo insertamos
        Estudiante estudiante = new Estudiante(cedula, apellidos, nombres, notaFinal, carrera, nivel);
        arbol.insertarEstudiante(estudiante);
        System.out.println("Estudiante insertado correctamente.");
    }

    // Busca un estudiante por su cedula y lo muestra
    private static void buscarEstudiante() {
        System.out.println("\n=== BUSCAR ESTUDIANTE ===");
        System.out.print("Ingrese cedula del estudiante: ");
        String cedula = scanner.nextLine();
        
        Estudiante estudiante = arbol.buscarEstudiante(cedula);
        if (estudiante != null) {
            System.out.println("\nEstudiante encontrado:");
            System.out.println(estudiante);
        } else {
            System.out.println("No se encontro un estudiante con la cedula " + cedula);
        }
    }

    // Elimina un estudiante del arbol
    private static void eliminarEstudiante() {
        System.out.println("\n=== ELIMINAR ESTUDIANTE ===");
        System.out.print("Ingrese cedula del estudiante a eliminar: ");
        String cedula = scanner.nextLine();
        
        if (arbol.eliminarEstudiante(cedula)) {
            System.out.println("Estudiante eliminado correctamente.");
        } else {
            System.out.println("No se encontro un estudiante con la cedula " + cedula);
        }
    }
}