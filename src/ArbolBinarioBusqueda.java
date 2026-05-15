// ArbolBinarioBusqueda.java


import java.util.LinkedList;
import java.util.Queue;

/**
 * Arbol binario de busqueda para gestionar estudiantes
 * Los estudiantes se ordenan por cedula (menor a mayor)
 */
public class ArbolBinarioBusqueda {
    private Nodo raiz;  // Raiz del arbol

    // Constructor: inicializa el arbol vacio
    public ArbolBinarioBusqueda() {
        this.raiz = null;
    }

    /**
     * Inserta un estudiante en el arbol
     * Usa recursividad para encontrar la posicion correcta
     */
    public void insertarEstudiante(Estudiante estudiante) {
        raiz = insertarRecursivo(raiz, estudiante);
    }

    // Metodo recursivo para insertar
    private Nodo insertarRecursivo(Nodo actual, Estudiante estudiante) {
        // Caso base: si el nodo esta vacio, creamos uno nuevo
        if (actual == null) {
            return new Nodo(estudiante);
        }

        // Comparamos la cedula para decidir si va a la izquierda o derecha
        int comparacion = estudiante.getCedula().compareTo(actual.getEstudiante().getCedula());

        // Si la cedula es menor, va al subarbol izquierdo
        if (comparacion < 0) {
            actual.setIzquierdo(insertarRecursivo(actual.getIzquierdo(), estudiante));
        } 
        // Si la cedula es mayor, va al subarbol derecho
        else if (comparacion > 0) {
            actual.setDerecho(insertarRecursivo(actual.getDerecho(), estudiante));
        } 
        // Si son iguales, el estudiante ya existe
        else {
            System.out.println("Error: Ya existe un estudiante con la cedula " + estudiante.getCedula());
        }
        return actual;
    }

    /**
     * Busca un estudiante por su cedula
     * Retorna el estudiante si lo encuentra, null en caso contrario
     */
    public Estudiante buscarEstudiante(String cedula) {
        Nodo resultado = buscarRecursivo(raiz, cedula);
        return resultado != null ? resultado.getEstudiante() : null;
    }

    // Metodo recursivo para buscar
    private Nodo buscarRecursivo(Nodo actual, String cedula) {
        // Caso base: no encontramos el nodo
        if (actual == null) {
            return null;
        }

        // Comparamos la cedula buscada con la del nodo actual
        int comparacion = cedula.compareTo(actual.getEstudiante().getCedula());

        // Si son iguales, encontramos el estudiante
        if (comparacion == 0) {
            return actual;
        } 
        // Si es menor, buscamos en el subarbol izquierdo
        else if (comparacion < 0) {
            return buscarRecursivo(actual.getIzquierdo(), cedula);
        } 
        // Si es mayor, buscamos en el subarbol derecho
        else {
            return buscarRecursivo(actual.getDerecho(), cedula);
        }
    }

    /**
     * Elimina un estudiante por su cedula
     * Retorna true si se elimino, false si no se encontro
     */
    public boolean eliminarEstudiante(String cedula) {
        // Primero verificamos si existe
        if (buscarEstudiante(cedula) == null) {
            return false;
        }
        raiz = eliminarRecursivo(raiz, cedula);
        return true;
    }

    // Metodo recursivo para eliminar
    private Nodo eliminarRecursivo(Nodo actual, String cedula) {
        if (actual == null) {
            return null;
        }

        int comparacion = cedula.compareTo(actual.getEstudiante().getCedula());

        // Buscamos el nodo a eliminar
        if (comparacion < 0) {
            actual.setIzquierdo(eliminarRecursivo(actual.getIzquierdo(), cedula));
        } else if (comparacion > 0) {
            actual.setDerecho(eliminarRecursivo(actual.getDerecho(), cedula));
        } else {
            // Encontramos el nodo a eliminar
            
            // Caso 1: Nodo hoja (sin hijos)
            if (actual.getIzquierdo() == null && actual.getDerecho() == null) {
                return null;
            } 
            // Caso 2: Solo tiene hijo derecho
            else if (actual.getIzquierdo() == null) {
                return actual.getDerecho();
            } 
            // Caso 3: Solo tiene hijo izquierdo
            else if (actual.getDerecho() == null) {
                return actual.getIzquierdo();
            } 
            // Caso 4: Tiene dos hijos
            else {
                // Buscamos el sucesor inorden (el menor del subarbol derecho)
                Nodo sucesor = encontrarMinimo(actual.getDerecho());
                // Reemplazamos el estudiante actual con el del sucesor
                actual.setEstudiante(sucesor.getEstudiante());
                // Eliminamos el sucesor
                actual.setDerecho(eliminarRecursivo(actual.getDerecho(), sucesor.getEstudiante().getCedula()));
            }
        }
        return actual;
    }

    // Encuentra el nodo con el valor minimo en un subarbol
    private Nodo encontrarMinimo(Nodo actual) {
        while (actual.getIzquierdo() != null) {
            actual = actual.getIzquierdo();
        }
        return actual;
    }

    /**
     * Recorrido Inorden: Izquierdo - Raiz - Derecho
     * Este recorrido muestra los estudiantes ordenados por cedula
     */
    public void recorridoInorden() {
        System.out.println("\n=== Recorrido Inorden ===");
        inordenRecursivo(raiz);
        System.out.println();
    }

    private void inordenRecursivo(Nodo actual) {
        if (actual != null) {
            inordenRecursivo(actual.getIzquierdo());  // Primero izquierdo
            System.out.println(actual.getEstudiante()); // Luego raiz
            inordenRecursivo(actual.getDerecho());    // Finalmente derecho
        }
    }

    /**
     * Recorrido Preorden: Raiz - Izquierdo - Derecho
     */
    public void recorridoPreorden() {
        System.out.println("\n=== Recorrido Preorden ===");
        preordenRecursivo(raiz);
        System.out.println();
    }

    private void preordenRecursivo(Nodo actual) {
        if (actual != null) {
            System.out.println(actual.getEstudiante()); // Primero raiz
            preordenRecursivo(actual.getIzquierdo());  // Luego izquierdo
            preordenRecursivo(actual.getDerecho());    // Finalmente derecho
        }
    }

    /**
     * Recorrido Postorden: Izquierdo - Derecho - Raiz
     */
    public void recorridoPostorden() {
        System.out.println("\n=== Recorrido Postorden ===");
        postordenRecursivo(raiz);
        System.out.println();
    }

    private void postordenRecursivo(Nodo actual) {
        if (actual != null) {
            postordenRecursivo(actual.getIzquierdo());  // Primero izquierdo
            postordenRecursivo(actual.getDerecho());    // Luego derecho
            System.out.println(actual.getEstudiante()); // Finalmente raiz
        }
    }

    /**
     * Recorrido por niveles (BFS - Breadth First Search)
     * Utiliza una cola para visitar los nodos nivel por nivel
     */
    public void recorridoPorNiveles() {
        System.out.println("\n=== Recorrido por Niveles (BFS) ===");
        if (raiz == null) {
            System.out.println("El arbol esta vacio");
            return;
        }

        // Creamos una cola para almacenar los nodos a visitar
        Queue<Nodo> cola = new LinkedList<>();
        cola.add(raiz);  // Agregamos la raiz

        // Mientras la cola no este vacia
        while (!cola.isEmpty()) {
            Nodo actual = cola.poll();  // Sacamos el primer nodo
            System.out.println(actual.getEstudiante());

            // Agregamos los hijos a la cola
            if (actual.getIzquierdo() != null) {
                cola.add(actual.getIzquierdo());
            }
            if (actual.getDerecho() != null) {
                cola.add(actual.getDerecho());
            }
        }
        System.out.println();
    }

    /**
     * Cuenta el numero total de nodos en el arbol
     */
    public int contarNodos() {
        return contarNodosRecursivo(raiz);
    }

    private int contarNodosRecursivo(Nodo actual) {
        if (actual == null) {
            return 0;  // Arbol vacio
        }
        // 1 (nodo actual) + nodos izquierda + nodos derecha
        return 1 + contarNodosRecursivo(actual.getIzquierdo()) + contarNodosRecursivo(actual.getDerecho());
    }

    /**
     * Calcula la altura del arbol (numero de niveles - 1)
     * Un arbol vacio tiene altura -1
     * Un arbol con un solo nodo tiene altura 0
     */
    public int calcularAltura() {
        return calcularAlturaRecursivo(raiz);
    }

    private int calcularAlturaRecursivo(Nodo actual) {
        if (actual == null) {
            return -1;  // Altura de arbol vacio es -1
        }
        // Calculamos altura de ambos subarboles
        int alturaIzq = calcularAlturaRecursivo(actual.getIzquierdo());
        int alturaDer = calcularAlturaRecursivo(actual.getDerecho());
        // La altura es 1 + la mayor de las dos alturas
        return 1 + Math.max(alturaIzq, alturaDer);
    }

    /**
     * Busca y muestra el estudiante con la nota mas alta
     * Recorre todo el arbol comparando notas
     */
    public void buscarNotaMayor() {
        if (raiz == null) {
            System.out.println("El arbol esta vacio");
            return;
        }
        Estudiante mayor = buscarNotaMayorRecursivo(raiz);
        System.out.println("\n=== Estudiante con Mayor Nota ===");
        System.out.println(mayor);
    }

    private Estudiante buscarNotaMayorRecursivo(Nodo actual) {
        Estudiante mayor = actual.getEstudiante();
        
        // Revisamos subarbol izquierdo
        if (actual.getIzquierdo() != null) {
            Estudiante mayorIzq = buscarNotaMayorRecursivo(actual.getIzquierdo());
            if (mayorIzq.getNotaFinal() > mayor.getNotaFinal()) {
                mayor = mayorIzq;
            }
        }
        
        // Revisamos subarbol derecho
        if (actual.getDerecho() != null) {
            Estudiante mayorDer = buscarNotaMayorRecursivo(actual.getDerecho());
            if (mayorDer.getNotaFinal() > mayor.getNotaFinal()) {
                mayor = mayorDer;
            }
        }
        
        return mayor;
    }

    /**
     * Busca y muestra el estudiante con la nota mas baja
     */
    public void buscarNotaMenor() {
        if (raiz == null) {
            System.out.println("El arbol esta vacio");
            return;
        }
        Estudiante menor = buscarNotaMenorRecursivo(raiz);
        System.out.println("\n=== Estudiante con Menor Nota ===");
        System.out.println(menor);
    }

    private Estudiante buscarNotaMenorRecursivo(Nodo actual) {
        Estudiante menor = actual.getEstudiante();
        
        if (actual.getIzquierdo() != null) {
            Estudiante menorIzq = buscarNotaMenorRecursivo(actual.getIzquierdo());
            if (menorIzq.getNotaFinal() < menor.getNotaFinal()) {
                menor = menorIzq;
            }
        }
        
        if (actual.getDerecho() != null) {
            Estudiante menorDer = buscarNotaMenorRecursivo(actual.getDerecho());
            if (menorDer.getNotaFinal() < menor.getNotaFinal()) {
                menor = menorDer;
            }
        }
        
        return menor;
    }

    /**
     * Muestra todos los estudiantes aprobados (nota >= 7)
     * Usa recorrido inorden para mostrar ordenados
     */
    public void mostrarAprobados() {
        System.out.println("\n=== Estudiantes Aprobados (Nota >= 7) ===");
        mostrarAprobadosRecursivo(raiz);
        System.out.println();
    }

    private void mostrarAprobadosRecursivo(Nodo actual) {
        if (actual != null) {
            mostrarAprobadosRecursivo(actual.getIzquierdo());
            if (actual.getEstudiante().isAprobado()) {
                System.out.println(actual.getEstudiante());
            }
            mostrarAprobadosRecursivo(actual.getDerecho());
        }
    }

    /**
     * Muestra todos los estudiantes reprobados (nota < 7)
     */
    public void mostrarReprobados() {
        System.out.println("\n=== Estudiantes Reprobados (Nota < 7) ===");
        mostrarReprobadosRecursivo(raiz);
        System.out.println();
    }

    private void mostrarReprobadosRecursivo(Nodo actual) {
        if (actual != null) {
            mostrarReprobadosRecursivo(actual.getIzquierdo());
            if (!actual.getEstudiante().isAprobado()) {
                System.out.println(actual.getEstudiante());
            }
            mostrarReprobadosRecursivo(actual.getDerecho());
        }
    }

    /**
     * Verifica si el arbol esta vacio
     */
    public boolean estaVacio() {
        return raiz == null;
    }
}