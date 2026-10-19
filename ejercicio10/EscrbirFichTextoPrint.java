/*/ejercicio 9 anterior
Ejercicio IX: Crear un programa java (EscribirFichTextoBuf.java) que escriba 10 filas de caracteres en un fichero
 de texto y después de escribir cada fila salta una línea con el método newLine();
Ejercicio X: Modifica el ejemplo anterior utilizando la clase PrintWriter. */
package ejercicio10;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class EscrbirFichTextoPrint {
    public static void main(String[] args) {
        String fichero = "escrbirPrint.txt";
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

        try (PrintWriter pr = new PrintWriter(new FileWriter(f))) {
            for (int i = 0; i < 10; i++) {
               pr.println("linea " + (i+1)  +  " prueba numero " + (i+1) );
            }
            
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
    }
    
}
