package ejercicio13;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LeerFichData2 {
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
            System.out.println("Error no tienes permisos de lectura");
            return ;
        }
        if(f.length()==0){
            System.out.println("error el fichero está vacio");
            return ;
        }
         try (DataInputStream dis = new DataInputStream(new FileInputStream(f))) {            
            while (dis.available()>0) { // con esto no nos hace falta el  EofException y tampoco bucle infinito
               String nombre= dis.readUTF();
                int edad = dis.readInt();   
                System.out.printf("nombre: %s, Edad: %d\n",nombre,edad);      
            }
        }catch(FileNotFoundException e){
            System.out.println("Error no se pudo leer el fichero");    
        
        }catch(IOException e){
            System.out.println("Error " + e.getMessage());
        }
       
    } 
}
