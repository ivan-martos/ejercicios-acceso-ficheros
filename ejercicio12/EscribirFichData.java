/*Ejercicio XII: Escribe un programa java (EscribirFichData.java)que inserta datos en el fichero FichData.data, 
los datos los toma de dos arrays, uno contiene los nombres de una serie de personas 
String nombres[]={“Ana”, ”Luis”, ”Alicia”,”Pedro”} Y el otro sus edades
 int edades[] ={14,15,13,15}; 
 Recorremos los arrays y vamos escribiendo en el fichero el nombre dataOS.writeUTF(nombres[i]); Y
  la edad dataOS.writeInt(edades[i]); */
package ejercicio12;

import java.io.DataOutputStream;
import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.io.IOException;

public class EscribirFichData {
    public static void main(String[] args) {
        String fichero = "datos.dat";
        File f = new File(fichero);
        String[] nombres = { "Ana", "Luis", "Alicia", "Pedro" };
        int[] numeros = { 14, 15, 13, 15 };

        if (f.exists()) {
            if (!f.isFile()) {
                System.out.println("Error: no es un fichero");
                return;
            }
            if (!f.canWrite()) {
                System.out.println("Error:  no tienes permisos de escritura");
                return;
            }
            System.out.println("el fichero existe y se va a escribir en él");
        }else{
            System.out.println("El fichero no existe, se va a crear y a escribir en él");
        }
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(f))) {
            for (int i = 0; i < nombres.length; i++) {
                dos.writeUTF(nombres[i]);
                
                dos.writeInt(numeros[i]);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error " + e.getMessage());
        }
    }

}
