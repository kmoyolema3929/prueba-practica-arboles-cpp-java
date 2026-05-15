// Estudiante.java


/**
 * Clase que representa a un estudiante de la universidad
 */
public class Estudiante {
    // Atributos privados del estudiante
    private String cedula;
    private String apellidos;
    private String nombres;
    private double notaFinal;
    private String carrera;
    private String nivel;

    // Constructor para crear un nuevo estudiante
    public Estudiante(String cedula, String apellidos, String nombres, 
                      double notaFinal, String carrera, String nivel) {
        this.cedula = cedula;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.notaFinal = notaFinal;
        this.carrera = carrera;
        this.nivel = nivel;
    }

    // Metodos getter para acceder a los atributos
    public String getCedula() { return cedula; }
    public String getApellidos() { return apellidos; }
    public String getNombres() { return nombres; }
    public double getNotaFinal() { return notaFinal; }
    public String getCarrera() { return carrera; }
    public String getNivel() { return nivel; }

    // Metodos setter para modificar los atributos
    public void setCedula(String cedula) { this.cedula = cedula; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }
    public void setNombres(String nombres) { this.nombres = nombres; }
    public void setNotaFinal(double notaFinal) { this.notaFinal = notaFinal; }
    public void setCarrera(String carrera) { this.carrera = carrera; }
    public void setNivel(String nivel) { this.nivel = nivel; }

    // Metodo para verificar si el estudiante aprobo (nota >= 7)
    public boolean isAprobado() {
        return notaFinal >= 7.0;
    }

    // Metodo toString para mostrar la informacion del estudiante
    @Override
    public String toString() {
        return String.format("Cedula: %s | Nombre: %s %s | Nota: %.2f | Carrera: %s | Nivel: %s",
                cedula, nombres, apellidos, notaFinal, carrera, nivel);
    }
}