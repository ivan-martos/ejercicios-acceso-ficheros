/*Crea un programa Java que en lugar de leer los caracteres uno a uno, lo escriba todo el array fic.write(cad) Pista:
 Tenemos que definir un array con distintos valores, los que quieras (provincias, nombres de atletas, días de la semana)
  y luego tienes que recorrer ese array que has definido y escribir los valores en el fichero de texto. 
  ¡IMPORTANTE!
   Hay que tener en cuenta que si el fichero existe cuando vayamos a escribir caracteres sobre él, todo lo que tenía 
   almacenado sobre el se borrará. Si queremos añadir caracteres al final usaremos la clase FileWriter, colocando en el 
   segundo parámetro del constructor el valor true: 33 FileWriter fic = new FileWriter (fichero,true); */
package ejercicio7;

import java.io.File;
import java.io.FileWriter;

public class EscribirFichTexto2 {
    public static void main(String[] args) {
        String fichero = "escribir2.txt";
        File f = new File(fichero);

        String[] ciudades= {"Madrid", "Sevilla","Barcelona","Toledo"};

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
        try (FileWriter fw = new FileWriter(f, true)) {
            for (String c : ciudades) {
                fw.write(c + "\n");
                System.out.println();
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
