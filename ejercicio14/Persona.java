package ejercicio14;

import java.io.Serializable;

// ¡IMPORTANTE! Para guardar un objeto en un archivo, la clase DEBE implementar Serializable
public class Persona implements Serializable {
    
    // Esto es una buena práctica para controlar las versiones de tus objetos guardados
    private static final long serialVersionUID = 1L;
    
    private String nombre;
    private int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    // El toString() te vendrá genial para el próximo ejercicio cuando te toque leerlos y mostrarlos
    @Override
    public String toString() {
        return "Persona [Nombre=" + nombre + ", Edad=" + edad + "]";
    }
}