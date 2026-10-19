package ejercicio14;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class EscribirFichObject2 {
    public static void main(String[] args) {
        String fichero = "Objetos.txt";
        File f = new File(fichero);
        

        List<Persona> personas = List.of(
                new Persona("Ana", 14),
                new Persona("Luis", 15),
                new Persona("Alicia", 13),
                new Persona("Pedro", 15)
        );

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
            for (Persona p : personas) {
                oos.writeObject(p);
            }
        } catch (IOException e) {
            System.out.println("Error no se ha podido escribir " + e.getMessage());
        }

    }

}
