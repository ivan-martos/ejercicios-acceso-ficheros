/*Ejercicio IX: Crear un programa java (EscribirFichTextoBuf.java) que escriba 10 filas de caracteres en un fichero
 de texto y después de escribir cada fila salta una línea con el método newLine(); */
package ejercicio9;

import java.io.BufferedWriter;
import java.io.File;

import java.io.FileWriter;
import java.io.IOException;

public class EscribirFichTextoBuf {
    public static void main(String[] args) {
        String fichero = "escrbirBuf.txt";
        File f = new File(fichero);

        if (f.exists()) {
            if (!f.isFile()) {
                System.out.println("Error no es un fichero");
                return;
            }
            if (!f.canWrite()) {
                System.out.println("Error no tienes permisos de escritura");
                return;
            }
            System.out.println("El fichero existe y se va a escribir en él");
        } else {
            System.out.println("El fichero no existe: se va crear y a escribir en el");
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(f))) {
            for (int i = 0; i < 10; i++) {
                bw.write("linea " + (i + 1) + " prueba de escritura " + (i + 1));
                bw.newLine();

            }

        } catch (IOException e) {
            System.out.println("Error no se ha podido escribir en el archivo");
        }

    }

}
