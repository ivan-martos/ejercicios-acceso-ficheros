package ejercicio15;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import ejercicio14.Persona;

public class LeerFichObject {
    public static void main(String[] args) {

        String fichero = "Objetos.txt";
        File f = new File(fichero);

        if (!f.exists()) {
            System.out.println("Error el fichero no existe");
            return;
        }
        if (!f.isFile()) {
            System.out.println("Error no es un fichero");
            return;
        }
        if (f.length() == 0) {
            System.out.println("Error el fichero esta vacío");
            return;
        }
        if (!f.canRead()) {
            System.out.println("Error no tienes permisos para leer");
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
            while (true) {
                Persona p = (Persona) ois.readObject();
                System.out.println(p);              
            }
            //con bandera boolean para  prescindire de while(true)
            /*boolean finArchivo = false;
            
            while (!finArchivo) {
                try {
                    Persona p = (Persona) ois.readObject();
                    System.out.println(p);
                } catch (EOFException e) {
                    finArchivo = true; // Esto rompe el bucle de forma limpia
                    System.out.println("Se ha terminado de leer.");
                }
            } */
            //modo  simplificado pero más difícil de ver
            // metemos los objetos en una lista  y la recorremos para mostrarla por consola
            /*// Lees el objeto y le dices a Java que es una Lista de Personas
                List<Persona> listaRecuperada = (List<Persona>) ois.readObject();

            // Y ya la imprimes o la recorres normalmente con un for
                for(Persona p : listaRecuperada) {
                System.out.println(p);
                } */
        } catch (EOFException e) {
            System.out.println("Se ha terminado de leer " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error " + e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println("Error " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error " + e.getMessage());

        }

    }

}
