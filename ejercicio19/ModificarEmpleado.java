/*Crea un programa Java (ModificarEmpleado.java) que reciba desde la línea de comandos un identificador
 de empleado y un importe. Se debe sumar al salario del empleado el importe tecleado. El programa debe 
 visualizar el apellido, el salario antiguo y el nuevo. Si el identificador no existe se visualizará 
 un mensaje indicándolo */
package ejercicio19;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ModificarEmpleado {
    public static void main(String[] args) {
        final int TAMANO_REGISTRO = 36;
        if(args.length<2){
            System.out.println("Debes introducir un numero de empleado y un importe");
            return ;
        }
        File f = new File("empleados.dat");
        int idBuscado =  Integer.parseInt(args[0]);// pasamos a int el argumento uno pasado por consola
        double importe = Double.parseDouble(args[1]); //pasamos a double el argumento 2 pasado por consola

         try (RandomAccessFile raf = new RandomAccessFile(f, "rw")) { // necesitamos leer y escribir para modificar
            int posicion = (idBuscado-1) * TAMANO_REGISTRO; 
            if(idBuscado<1 || posicion >= raf.length()){
                System.out.println("el id que buscas no esta en la lista ");
                return ;
            }
            raf.seek(posicion + 4);  //avanzo el puntero 4 bytes del id          
            char[]apellido = new char[10]; //creamos una arary para guardar el apellido
            for (int i = 0; i < apellido.length; i++) { //recorremos la array para guardar caracteres
                apellido[i] =  raf.readChar();     //    guardamos cada caracte del apellido        
            }
            String apellidoString = new String(apellido);// convertimos lo de la array en un sTring
            raf.seek(posicion+28); // avanzamos el puntero  id =  4 + apellido 20  + departamento + 4 =  28 bytes
            double salario = raf.readDouble(); // leemos el salario antiguo
            System.out.printf("Id: %d   Apellido: %s   Salario: %.2f",idBuscado, apellidoString, salario ); // mostramos por pantalla lo leído
            double nuevoSalario =  importe + salario;    // guardamos en nuevio salario el salario + el importe que pasemos por consola        
            raf.seek(posicion+28); // colocamos el puntero de nuevo a la altura del salario en este usuario
            raf.writeDouble(nuevoSalario);// y escribimos el nuevo salario
            System.out.printf("El empleado con id: %d  Apellido: %s  su Salario actualizado ahora es: %.2f",idBuscado, apellidoString, nuevoSalario ); // mostramos por pantalla  todo actualizado

         } catch (FileNotFoundException e) { // capturamos exception por si no encuentra el archivo
            System.out.println("Error no se ha encontrado el archivo " + e.getMessage());
         }catch(IOException e){ // capturamos io por si  se produce algun error de escritura/lectura
            System.out.println("Error " + e.getMessage());
         }


        
    }
    
}
