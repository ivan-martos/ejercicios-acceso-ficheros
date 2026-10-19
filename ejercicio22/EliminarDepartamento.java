/*Ejercicio XXII Realiza un programa Java que permita eliminar un departamento. 
El programa recibe desde línea de comandos el número de departamento a eliminar. 
Si el departamento no existe visualiza un mensaje indicándolo. Visualiza también el número 
total de departamentos que existen en un fichero */
package ejercicio22;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class EliminarDepartamento {
    public static void main(String[] args) {
        String fichero = "Departamento.dat";
        String temporal = "temporal.dat";
        File f = new File(fichero);
        File t = new File(temporal);
        boolean encontrado =  false;
        int contDep = 0;

        if (args.length < 1) {
            System.out.println("Debes meter un número de departamento");
            return;
        }    
        int numDept = Integer.parseInt(args[0]);
    

        try (DataInputStream dis = new DataInputStream(new FileInputStream(f));
                DataOutputStream dos = new DataOutputStream(new FileOutputStream(t))) {
            while (true) {
                int depLeido = dis.readInt();
                String nombreLeido = dis.readUTF();
                String nombreLocalidad= dis.readUTF();
                if(depLeido == numDept){
                    encontrado = true;
                }else{
                    dos.writeInt(depLeido);
                    dos.writeUTF(nombreLeido);
                    dos.writeUTF(nombreLocalidad);
                    contDep ++ ;
                }
            }
        } catch (EOFException e) {
            System.out.println("Se ha terminado de leer el fichero");
        } catch (IOException e) {
            System.out.println("Error " + e.getMessage());
        }
        if(!encontrado){
            System.out.printf("El departamento %d  no existe " ,numDept);
            t.delete();
        }else{
            f.delete();
            t.renameTo(f);
            System.out.println("Departamento eliminado correctamente");
        }
        System.out.printf("Numero total de departamentos en el fichero es: %d\n", contDep );

    }

}
