/*Ejercicio XVII Crea un programa java (LeerFichAleatorio.java) que toma el fichero anterior y visualiza todos
 los registros. El posicionamiento para empezar a recorrer los registros empieza en 0, para recuperar los siguientes
  registros hay que sumar 36 (tamaño del registro) a la variable utilizada para su conocimiento. 
  Pasos:
--Declara el fichero de acceso aleatorio.--
--Situarnos al principio y recorrer el fichero (for(;;)
--Nos posicionamos en posición (file.seek(posición)
--Leemos id de empleado y recorremos los caracteres del aepellido
--Obtengo resto de información y la escribo 
--Me posiciono en el siguiente empleado (36 bytes 4 +20+4+8)
--Si he recorrido todos los bytes salgo del for 
      if (file.getFilePointer()==file.length()) break; */
package ejercicio17;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;

import javax.tools.FileObject;

public class LeerFichAleatorio {
    public static void main(String[] args) {
        String fichero = "empleados.dat";
        File f = new File(fichero);
        if (!f.exists()) {
            System.out.println("Error la ruta no existe");
            return;
        }
        if (!f.isFile()) {
            System.out.println("Error no es un fichero");
            return;
        }
        if (!f.canRead()) {
            System.out.println("error  no tienes permisos de lectura");
            return;
        }
        if (f.length() == 0) {
            System.out.println("Error el fichero está  vacío");
            return;
        }

        try (RandomAccessFile raf = new RandomAccessFile(f, "r")) {
            int posicion = 0;

            for (;;) {
                if (raf.getFilePointer() == raf.length()) {
                    break;
                }
                raf.seek(posicion);
                int id = raf.readInt();
                char[] apellido = new char[10];
                for (int i = 0; i < 10; i++) {
                    apellido[i] = raf.readChar();
                }
                String apellidosString = new String(apellido);
                int departamento =raf.readInt();
                double salario = raf.readDouble();
                System.out.printf("ID: %d | Apellido: %s | Departamento: %d | Salario: %.2f\n", id,apellidosString , departamento,salario);
            posicion += 36; //sumamos cada registro(todos deben ser iguales)
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error " + e.getMessage());
        }

    }
}
