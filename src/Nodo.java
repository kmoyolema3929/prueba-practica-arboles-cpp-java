// Nodo.java


/**
 * Clase que representa un nodo del arbol binario de busqueda
 * Cada nodo contiene un estudiante y referencias a sus hijos izquierdo y derecho
 */
public class Nodo {
    // Atributos del nodo
    private Estudiante estudiante;  // Dato que almacena el nodo
    private Nodo izquierdo;          // Referencia al hijo izquierdo
    private Nodo derecho;            // Referencia al hijo derecho

    // Constructor que crea un nodo con un estudiante
    public Nodo(Estudiante estudiante) {
        this.estudiante = estudiante;
        this.izquierdo = null;  // Inicialmente no tiene hijo izquierdo
        this.derecho = null;    // Inicialmente no tiene hijo derecho
    }

    // Metodos getter y setter
    public Estudiante getEstudiante() { return estudiante; }
    public void setEstudiante(Estudiante estudiante) { this.estudiante = estudiante; }

    public Nodo getIzquierdo() { return izquierdo; }
    public void setIzquierdo(Nodo izquierdo) { this.izquierdo = izquierdo; }

    public Nodo getDerecho() { return derecho; }
    public void setDerecho(Nodo derecho) { this.derecho = derecho; }
}