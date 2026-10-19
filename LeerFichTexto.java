
import java.io.FileReader;
import java.io.IOException;

public class LeerFichTexto {
    public static void main(String[] args) {
        String nombreFichero;

        if (args.length < 1) {
            nombreFichero = "prueba.txt";
        } else {
            nombreFichero = args[0];
        }
        /*
         * try (FileReader fr = new FileReader(nombreFichero)) { // para leer caracter a caracter        
         * int caracter;
         * while ((caracter = fr.read()) != -1) {
         * System.out.print((char)caracter);
         * }
         * 
         * } catch (IOException e) {
         * System.out.println("Error: el archivo no se ha encontrado");
         * }
         */

        try (FileReader fr = new FileReader(nombreFichero)) {
            int caracterLeidos;
            char[]caracteres = new char[20];
            while ((caracterLeidos = fr.read(caracteres)) != -1) {
                System.out.println(caracteres);
                    
            }

        } catch (IOException e) {
            System.out.println("Error: el archivo no se ha encontrado");
        }

    }

}
