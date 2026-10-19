/*Ejercicio XIII: Escribe un programa java (LeerFichData.java) que visualiza los datos grabados 
anteriormente en el fichero, se deben recuperar en el mismo orden en el que se insertaron, es decir,
primero obtenemos el nombre y luego la edad. Utilizaremos dataIS.readUTF(); para el nombre dataIS.readInt();
para la edad. */
package ejercicio13;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LeerFichData {
    public static void main(String[] args) {
        String fichero = "datos.dat";
        File f = new File(fichero);

        if(!f.exists()){
            System.out.println("error la ruta no existe");
            return ;
        }
        if(!f.isFile()){
            System.out.println("Error no es un fichero");
            return;
        }
        if(!f.canRead()){
            System.out.println("Error no tienes permisos de escritura");
            return ;
        }
        if(f.length()==0){
            System.out.println("error el fichero está vacio");
            return ;
        }

        try (DataInputStream dis = new DataInputStream(new FileInputStream(f))) {            
            while ((true)) { // leemos en un bucle infinito y se rompe cuando no haya mas que leer con EOFException
               String nombre= dis.readUTF();
                int edad = dis.readInt();   
                System.out.printf("nombre: %s, Edad: %d\n",nombre,edad);      
            }
        }catch(FileNotFoundException e){
            System.out.println("Error no se pudo leer el fichero");    
        } catch (EOFException e) {
            System.out.println("Lectura finalizada, no quedan mas líneas " + e.getMessage());
        }catch(IOException e){
            System.out.println("Error " + e.getMessage());
        }
    }
    
}
