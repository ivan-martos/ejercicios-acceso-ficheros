/*Ejercicio XVI: Crea programa java (EscribirFicheroAleatorio.java) que inserta datos de empleados en un fichero 
aleatorio. Los datos a insertar son: el apellido, el departamento, el salario, se obtienen de varios arrays que se
 llenan en el programa, los datos de van introduciendo de forma secuencial. Por cada empleado también se insertará un
  identificador que coincidirá con el índice+1 con el que se recorren los arrays. La longitud del registro de cada
   empleado es la misma (36 bytes) y los tipos que se insertan y su tamaño en bytes es la siguiente: 
   Ejercicio XVI (continuación): • Se inserta en primer lugar un entero, que es el identificador, 
   ocupa 4 bytes. • A continuación una cadena de 10 caracteres, es el apellido, cada carácter Unicode ocupa 2 bytes, 
   por tanto el apellido ocupa 20 bytes. • Un tipo entero que es el departamento, ocupa 4 bytes. • Un tipo Double que 
   es el salario, ocupa 8 bytes. Recuerda: tamaño de otros tipos: short (2 bytes), byte (1 byte),
    long (8 bytes), boolean (1 bit), float (4 bytes)…. 56 El fichero se abre en modo “rw” para lectura y escritura. */
package ejercicio16;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class EscribirFicheroAleatorio {
    public static void main(String[] args) {

        
        String fichero = "empleados.dat";
        File f =  new File(fichero);
        // 1. Creas tus datos de prueba en arrays paralelos
        String[] apellidos = { "Fernandez", "Gil", "Lopez", "Ramos", "Sevilla", "Casilla", "Rey" };
        int[] departamentos = { 10, 20, 10, 10, 30, 30, 20 };
        Double[] salarios = { 1000.45, 2400.60, 3000.0, 1500.56, 2200.0, 1435.87, 2000.0 };
        
        try (RandomAccessFile raf = new RandomAccessFile(f, "rw")) {
            for (int i = 0; i < apellidos.length; i++) {
                raf.writeInt(i+1); 
                 // para escribier el apellido usamos el metodo de String
                StringBuffer sb =  new StringBuffer(apellidos[i]); // metemos el apellido
                sb.setLength(10);//forzamos a sea de 10 caracteres, si es mas corto añade espacios, si es mas lo corta
                raf.writeChars(sb.toString());// escribimos el apellido      
                raf.writeInt(departamentos[i]);                         
                raf.writeDouble(salarios[i]);                
            }
        } catch (IOException e) {
            System.out.println("Error" + e.getMessage());
        }
    
    
    }

}
