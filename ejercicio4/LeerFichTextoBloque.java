package ejercicio4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class LeerFichTextoBloque {
    public static void main(String[] args) {
        String fichero = "quijote.txt";
        File f = new File(fichero);
        int leidos;
        char[] caracteres = new char[30];
        try (FileReader fr = new FileReader(f,StandardCharsets.UTF_8)) {
            while ((leidos=fr.read(caracteres))!= -1) {
               // System.out.println(new String(caracteres,0,leidos)); imprime el array desde el cero hasta lo que tenga leidos
               for (int i = 0; i < caracteres.length; i++) {
                 System.out.print(caracteres[i]);
               }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: no se ha encontrado el archivo");
        } catch(IOException e){
            System.out.println("Error " + e.getMessage() );
        }
    }

}
