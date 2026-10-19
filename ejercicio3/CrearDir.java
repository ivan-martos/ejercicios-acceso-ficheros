/*Realiza un programa Java que cree un directorio (de nombre NUEVODIR junto con tus iniciales),
 a continuación, crea dos ficheros vacíos en dicho directorio y uno de ellos lo renombra. Pista: 
 En este caso para crear los ficheros se definen 2 parámetros en el objeto File: File(File directorio,
String nombrefich), en el primero indicamos el directorio donde se  creará el fichero y en el segundo indicamos 
  el nombre del fichero. ¿Qué método habría que utilizar si queremos borrar un fichero? Añádelo en tu programa 
  forrando el fichero2 */
package ejercicio3;

import java.io.File;

public class CrearDir {
    public static void main(String[] args) {

        String directorio = "nuevodir_i";        

        File d  = new File(directorio);
         d.mkdir();

         File f1 = new File(d, "fichero1.txt");
         File f2 = new File(d, "fichero2.txt");

         try {
            f1.createNewFile();
            f2.createNewFile();

            File nuevo = new File(d,"ficheroRenombrado.txt");
            f1.renameTo(nuevo);
            f2.delete();

            
         } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
         }


        
    }
    
}
