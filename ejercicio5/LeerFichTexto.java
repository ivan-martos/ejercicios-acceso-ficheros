/*Crea un fichero de texto con algún editor de textos y después realiza un programa Java que visualice su contenido. 
Cambia el programa Java para que el nombre del fichero se acepte al ejecutar desde la línea de comandos. */
package ejercicio5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;

public class LeerFichTexto {
    public static void main(String[] args) {
        if(args.length<1){
            System.out.println("Error: debees indicar una ruta por consola" );
            return;
        }
        
        String fichero= args[0];
        File f= new File(fichero);

        if(!f.exists()||!f.isFile()){
            System.out.println("Error: no existe o no es un fichero");
            return ;
        }
        try (FileReader fr = new FileReader(f,StandardCharsets.UTF_8)) {
            int leidos;
            while((leidos= fr.read())!=-1){
                System.out.print((char)(leidos));
            }
        } catch(FileNotFoundException e){
            System.out.println("Error " + e.getMessage());
        }catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
    }
    
}
