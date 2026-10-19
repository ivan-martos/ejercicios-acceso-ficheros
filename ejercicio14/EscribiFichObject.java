/*Ejercicio XIV: Crea programa java (EscribirFichObject.java) que escriba objetos Persona en un fichero. 
Necesitamos crear un flujo de salida a disco con FileOutputStream y a continuación crear el flujo de salida 
ObjectOutputStream que es el que procesa los datos y se ha de vincular al fichero de
FileOutputStream: File fichero = new File (“FichPersona.dat”);
FileOutputStream fileout = new FileOutputStream(fichero); ObjectOutputStream datoOS = new ObjectOutputStream(fileout);
El método writeObjetct() escribe los objetos al flujo de salida y los guarda en un fichero de disco:
dataOS.writeObject(persona); */
package ejercicio14;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class EscribiFichObject {
    public static void main(String[] args) {
        String fichero = "Objetos.txt";
        File f = new File(fichero);
        

        Persona p1 = new Persona("Ana", 20);
        Persona p2 = new Persona("Luisa", 14);
        Persona p3 = new Persona("Jesusa", 15);

        if (f.exists()) {
            if (!f.isFile()) {
                System.out.println("Error no es un fichero");
                return;
            }
            if (!f.canWrite()) {
                System.out.println("Error no tienes permisos de escritura");
                return;
            }
            System.out.println("El fichero existe y se va a sobrescribir");
        } else {
            System.out.println("El fichero no existe se va a crear y a escribir en él");
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f))) {
            oos.writeObject(p1);
            oos.writeObject(p2);
            oos.writeObject(p3);

        } catch (IOException e) {
            System.out.println("Error no se a podido escribir " + e.getMessage());
        }

    }

}
