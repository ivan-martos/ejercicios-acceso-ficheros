/*Ejercicio XVIII Crea un programa Java (AccesoAleatorio.java) que reciba un identificador de empleado
 desde la línea de comandos y visualice sus datos. Si el empleado no existe debe visualizar mensaje
  indicándolo */
package ejercicio18;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class AccesoAleatorio {
    public static void main(String[] args) {
        final int TAMANO_REGISTRO = 36;
        // comprobamos que nos han pasado un argumento al ejercutar

        if (args.length == 0) {
            System.out.println("Error: Debes indicar el id del empleado que quieres buscar");
            return;
        }
        // ahora transformamos el argumento que nos pasan por consola(es un String) a
        // numero
        int idBuscado = Integer.parseInt(args[0]);
        // creamos nuestro file como siempre
        File f = new File("empleados.dat");
        // creamos el raf(acceso aleatorio para accesdeer al archivo)
        try (RandomAccessFile raf = new RandomAccessFile(f, "rw")) {
            // calculamos la posición exacta usando la formula para calcular
            int posicion = (idBuscado - 1) * TAMANO_REGISTRO;
            // ahora comprobamos si el usuario existe
            if (idBuscado < 1 || posicion >= raf.length()) {
                System.out.printf("El usuario con id %s no existe", idBuscado);
                return;
            }
            // posicionamos el puntero en el punto exacto donde vamos a leer
            raf.seek(posicion);
            int idRegistro = raf.readInt(); // leemos el int y lo guardamos en una variable
            char[] apellido = new char[10]; // creamos array para guardar cada letra del apellido max 10
            for (int i = 0; i < apellido.length; i++) { // recorremos la array de apellido
                apellido[i] = raf.readChar(); // guardamos cada letra que vamos leyendo
            }
            String apellidoString = new String(apellido);// pasamos el apellido a String con este metodo
            int departamento = raf.readInt(); // leemos y guardamos el departmaento
            double salario = raf.readDouble();// guardamos el salario en un double
            // imprimimos los datos que hemos leido del registro completo
            System.out.printf("Id: %d  Apellido: %s   Departamento: %d    Salario: %.2f", idRegistro, apellidoString,
                    departamento, salario);

        } catch (FileNotFoundException e) {
            System.out.println("Error: No se encuentra el archivo " + f);
        } catch (IOException e) {
            System.out.println("Error de lectura: " + e.getMessage());
        }

    }

}