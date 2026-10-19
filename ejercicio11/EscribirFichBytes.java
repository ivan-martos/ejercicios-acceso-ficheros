/*Ejercicio XI: Escribe un programa java (EscribirFichBytes.java) que escribe bytes en un fichero 
y después los visualiza. Vamos a crear un flujo de salida hacia el fichero con FileOutputStream y 
un flujo de entrada con FileInputStream. 1. Escribimos los datos en el flujo de salida, por ejemplo,
 números del 1 al 100. 2. Visualizamos esos datos */
package ejercicio11;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class EscribirFichBytes {
    public static void main(String[] args) {
          String fichero = "escrbirOutPut.txt";
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
        try (FileOutputStream fos = new FileOutputStream(f)) {
           for (int i = 1; i <= 100; i++) {
            fos.write(i);
           }
            
        } catch (Exception e) {
           System.out.println("Error " + e.getMessage());
        }
        if(!f.exists()){
            System.out.println("Error: la ruta no existe");
            return ;
        }
        if(!f.isFile()){
            System.out.println("error: no es un fichero");
            return ;
        }
        if(!f.canRead()){
            System.out.println("Error no tienes permisos de lectura");
            return;
        }
        if(f.length()==0){
            System.out.println("Error: el fichero está vacío");
            return ;
        }
        try (FileInputStream fis = new FileInputStream(f)) {
            int leidos;
            byte[]bytes= new byte[100];
            /*while((leidos= fis.read())!=-1){
                System.out.print(leidos + " ");
            }*/
           while ((leidos = fis.read(bytes))!=-1) {
            for (byte b : bytes) {
                System.out.print(b + " ");
            }
           }
        } catch (Exception e) {
           System.out.print("Error " + e.getMessage());
        } 

    }
    
}
