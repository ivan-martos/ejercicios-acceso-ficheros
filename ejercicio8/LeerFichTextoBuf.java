/*Crear un programa java (LeerFichTextoBuf.java) que lea el fichero línea por línea (por ejemplo que lea el fichero 
del ejercicio anterior LeerFichTexto.java) y las va visualizando por pantalla. Haz un control de excepciones. */
package ejercicio8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeerFichTextoBuf {
    public static void main(String[] args) {
        
        String fichero = "quijote.txt";
        File f = new File(fichero);
         if(!f.exists()){
            System.out.println("Error el fichero no existe");
            return ;
         }
         if(!f.isFile()){
            System.out.println("Error no es un fichero");
            return ;
         }
         if(!f.canRead()){
            System.out.println("Error no tienes permisos de lectura");
            return;
         }
         if(f.length()==0){
            System.out.println("Error el fichero esta vacío");
            return ;
         }
         try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String linea;
            while((linea=br.readLine())!=null){
                System.out.println(linea);

            }
            
         } catch (FileNotFoundException e) {
            System.out.println("Error " + e.getMessage());
         }catch(IOException e){
            System.out.println("Error " + e.getMessage());
         }

    }
    
}
