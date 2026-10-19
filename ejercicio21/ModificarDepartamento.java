/*Ejercicio XXI Realiza un programa Java que permita modificar los datos de un departamento.
 El programa recibe desde la línea de comandos el número de departamento a modificar, 
 el nuevo nombre de departamento y la nueva localidad. Si el departamento no existe visualiza un mensaje 
 indicándolo. Visualiza también los datos antiguos del departamento y los nuevos datos. */
package ejercicio21;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ModificarDepartamento {
    public static void main(String[] args) {
        
        if(args.length<3){
            System.out.println("Debes introducir numero de departamento a buscar, el nuevo  nombre y la localidad ");
            return;
        }
        String fichero =  "Departamentos.dat";
        String temporal =  "temporal.dat";
        File f =  new File(fichero);
        File t = new File(temporal);
        int numDept =  Integer.parseInt(args[0]);
        boolean encontrado = false;

        try (DataInputStream dis = new DataInputStream(new FileInputStream(f));
                DataOutputStream dos =  new DataOutputStream(new FileOutputStream(t))) {            
            while(true){
                int depLeido= dis.readInt();
                String nombreLeido = dis.readUTF();
                String localidadLeida= dis.readUTF();
                if(depLeido == numDept ){                   
                    dos.writeInt(depLeido);
                    dos.writeUTF(args[1]);
                    dos.writeUTF(args[2]);
                    encontrado = true; 
                    System.out.printf("Departamento: %d    Nombre nuevo: %s    Localidad nueva: %s ",numDept,args[1], args[2] );
                }else{
                    dos.writeInt(depLeido);
                    dos.writeUTF(nombreLeido);
                    dos.writeUTF(localidadLeida);
                }
            }
        }catch(FileNotFoundException e){
            System.out.println("Error no se ha encontrado el fichero" + e.getMessage());
        } catch (EOFException e) {
            System.out.println("Se ha acabado de leer el fichero");
        }catch(IOException e){
            System.out.println("Error " + e.getMessage());
        }

        if(!encontrado){
            System.out.println("El departamento " + numDept + " no se ha encontrado en el fichero");
            t.delete();
            t.renameTo(f);
            System.out.println("Fichero actualizado correctamente");
        }
    }
    
}