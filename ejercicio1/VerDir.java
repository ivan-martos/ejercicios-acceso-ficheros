/*Realiza un programa Java que muestre los ficheros de un directorio.
 El nombre del directorio se pasará al programa desde la línea de comandos al ejecutarlo. */
package ejercicio1;

import java.io.File;

public class VerDir {
    public static void main(String[] args) {

        String ruta = (args.length>0)? args[0]:"."; //coge la ruta pasada como argumento, si no en la que está 
        File f = new File(ruta);

        if(!f.exists()){ // la ruta que le pasamos no existe?
            System.out.printf("No existe el fichero o directorio (%s)", ruta);
            return ; // si no existe nos vamos con return
        }
        if(!f.isDirectory()){
            System.out.printf("La ruta (%s) no es un directorio, es un archivo.\n ", ruta );
            return ; // si no es una directorio me voy con return
        }
        File[] ficheros = f.listFiles(); // si estamos aqui es que existe y es un directorio entonces llenamos con lo que hay dentro del directorio
        System.out.printf("--- Contenido de: %s ---",f.getAbsolutePath() );
        if(ficheros != null && ficheros.length > 0){
            for (File fich : ficheros) {
                if(fich.isDirectory()){
                    System.out.println("[Carpeta] " + fich.getName());
                }else{
                    System.out.println("[Archivo] " + fich.getName());
                }
            }
        }else{
            System.out.println("El directorio está vacío");
        }
     }
}
