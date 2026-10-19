/*Ejercicio XX Crea un programa Java que cree un fichero binario para guardar datos de departamentos, 
dale el nombre Departamentos.dat. Introduce varios departamentos. Los datos para cada departamento son:
Número de departamento: entero.-- Nombre: string Localidad: string */
package ejercicio20;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class DatosDepartamento {
    public static void main(String[] args) {
        int[] numDept = { 10, 20, 30, 40 };
        String[] nombresDept = { "Contabilidad", "Informatica", "Ventas", "Recursos Humanos" };
        String[] localidadesDept = { "Madrid", "Sevilla", "Valencia", "Bilbao" };

        String fichero = "Departamentos.dat";
        File f = new File(fichero);

        if (f.exists()) {
            if (!f.isFile()) {
                System.out.println("Error no es un fichero");
                return;
            }
            if (!f.canWrite()) {
                System.out.println("Error no tienes permisos de escritura");
            }
            System.out.println("El fichero ya existe, se va a escribir en él");
        } else {
            System.out.println("El fichero no existe, se va a crear y a escribier en él");
        }

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(f))) {
            for (int i = 0; i < nombresDept.length; i++) {
                dos.writeInt(numDept[i]);
                dos.writeUTF(nombresDept[i]);
                dos.writeUTF(localidadesDept[i]);
            }

        } catch (IOException e) {
            System.out.println("error " + e.getMessage());
        }

    }

}
