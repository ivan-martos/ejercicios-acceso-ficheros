/*Ejercicio IV: • Leer un fichero de texto(LeerFichTexto.java) Crea un programa java que lea los caracteres uno a uno 
del fichero java que está ejecutando (LeerFichTexto.java), y los muestre por pantalla. El método read() puede lanzar
 la excepción IOException ¿Cómo podríamos manejar esa excepción? Hay dos opciones posibles. Modifica el programa 
 anterior para que lo lea de 30 en 30. */
package ejercicio4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class LeerFichTexto {
    public static void main(String[] args) {
        
        String fichero = "quijote.txt";
        File f= new File(fichero);

        try (FileReader fr = new FileReader(f, StandardCharsets.UTF_8)) {
            int leidos;
            
            while ((leidos= fr.read())!= -1) {
                System.out.print((char)leidos);
                
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: no se ha encontrado el archivo " +  e.getMessage());
        }catch(IOException e){
            System.out.println("Error " + e.getMessage());
        }

        
    }
    
}
