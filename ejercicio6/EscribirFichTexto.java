/*Crea un programa Java que escriba caracteres en un fichero de nombre FichTexto.txt 
(si no existe lo crea). Los caracteres se escriben uno a uno y se obtienen de un string. */
package ejercicio6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class EscribirFichTexto {
    public static void main(String[] args) {
        String fichero ="escribir.txt";
        File f = new File(fichero);
        String texto="Hola Mundo, esto es una prueba de escritura en ficheros con File";

        if(f.exists()){
            if(!f.isFile()){
                System.out.println("Error no es un fichero");
                return ;
            }
            if(!f.canRead()){
                System.out.println("Error no tiene permisos de escritura");
                return;
            }
            System.out.println("El fichero ya existe y se va a escribir en él");
        }else{
            System.out.println("El fichero no existe pero se va a crear y escribir en él");
        }
        try (FileWriter fw = new FileWriter(f)) {
            fw.write(texto);
            
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
