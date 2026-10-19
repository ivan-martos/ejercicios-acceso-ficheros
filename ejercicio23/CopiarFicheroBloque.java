package ejercicio23;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopiarFicheroBloque {
    public static void main(String[] args) {

        if (args.length < 2) {
            System.out.println("Debes introducir ruta de origen y de destino a ficheros ");
            return;
        }
        String origen = args[0];
        String destino = args[1];

        File o = new File(origen);
        File d = new File(destino);
        if (!o.exists()) {
            System.out.printf("Error: la ruta %s no existe ", origen);
            return;
        }
        if (!o.isFile()) {
            System.out.printf("Error: %s  No es un fichero", origen);
            return;
        }
        if (o.length() == 0) {
            System.out.printf("Error!! el fichero: %s  está vacío", origen);
            return;
        }
        if (!o.canRead()) {
            System.out.printf("Error!!! no tienes permisos de lectura para el fichero  %s", origen);
            return;
        }
        if (d.exists()) {
            if (!d.isFile()) {
                System.out.printf("Error!! %s  no es un fichero", destino);
                return;
            }
            if (!d.canWrite()) {
                System.out.printf("Error!!! no tienes permisos de escritura para %s", destino);
                return;
            }
            System.out.printf("La ruta %s existe  y se va a sobrescribir", destino);
        } else {
            System.out.printf("La ruta %s no está creada, se creara y se copiará el nuevo fichero", destino);
        }

        try (FileInputStream fis = new FileInputStream(o);
                FileOutputStream fos = new FileOutputStream(d)) {
            byte[] bloque = new byte[1024];
            int leido;
            while ((leido = fis.read(bloque)) != -1) {
                fos.write(bloque, 0, leido);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error " + e.getMessage());
        }

    }

}
