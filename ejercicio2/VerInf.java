/* Realiza un programa Java que muestre la información de un fichero.
- Nombre del fichero
- Ruta
- Ruta absoluta
- Indicar si puede escribir
- Indicar si puede leer- Tamaño
- Es un directorio- Es un fichero.
*/
package ejercicio2;

import java.io.File;

public class VerInf {
    public static void main(String[] args) {
        String  ruta = (args.length>0)? args[0]:".";

        File f = new File(ruta);

        if(!f.exists()){
            System.out.println("Error: no se ha entrado la ruta introducida\n");
            return;
        }
        if(f.isDirectory()){
            System.out.println("Error: Es un directorio y no un fichero\n");
            return ;
        }

        if(f!= null && f.length()>0){
            System.out.printf("nombre del fichero: %s\n",f.getName() );
            System.out.printf("La ruta es: %s\n",f.getPath() );
            System.out.printf("La ruta absoluta del fichero es: %s\n",f.getAbsolutePath());
            if(f.canRead()){
                System.out.println("El fichero se puede leer");                   
            }
             if (f.canWrite()) {
                    System.out.println("El fichero se puede escribir");
            }
            if(f.isDirectory()){
                System.out.println("Es un directorio");
            }else{
                System.out.println("no es un directorio");
            }

        }

    }
    
}
