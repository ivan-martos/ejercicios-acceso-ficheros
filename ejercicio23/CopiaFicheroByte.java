/*Ejercicio XXIII Realiza un programa Java que copie dos ficheros. El nombre de los dos ficheros origen
 y destino, se introducen desde la línea de comandos al ejecutar el programa. */
package ejercicio23;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopiaFicheroByte {
    public static void main(String[] args) {

        

        if(args.length<2){
            System.out.println("Debes introducir uan ruta de origen y otra de destino a  ficheros");
            return ;
        }

        String origen =  args[0];
        String destino =  args[1];
        File o =  new File(origen);
        File d = new File(destino);
        
        try (FileInputStream fis = new FileInputStream(o);
                FileOutputStream fos = new FileOutputStream(d)) {
                int leidos;
                while((leidos= fis.read())!= -1){
                    fos.write(leidos);
                }
        }catch(FileNotFoundException e){   
            System.out.println("Error :" + e.getMessage());                
        } catch (IOException e) {
           System.out.println("Error " + e.getMessage());
        }
        
    }
    
}
