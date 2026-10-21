package ejerciciosLibro;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class VerPermisos {
     public  static void main(String[] args) {
        String ruta = (args.length>0)? args[0]: ".";
        File f =  new File(ruta);
        if(!f.exists()){
            System.out.println("Error la ruta no existe");
            return ;
        }
        if(f.isFile()){
            System.out.printf("Error : (%s)  es im fichero ", f);
            return ;
        }else if (f.isDirectory()){
            File[] directorios = f.listFiles();

            SimpleDateFormat sdf = new  SimpleDateFormat("dd/MM/yyyy");
            for (File d : directorios) {
                System.out.printf("el nombre del fichero es %s%n",d.getName());
                System.out.printf("El tamaño  es %d bytes%n",d.length());

                System.out.printf( " Permisos %s%s%S%n",
                                    d.canRead() ? "r" : "-",
                                    d.canWrite() ? "w" : "-",
                                    d.canExecute() ? "x" : "-"); 
                System.out.println("-------------------------");

               String modificacionFecha = sdf.format(new Date(d.lastModified()));
               System.out.printf("última modificación %s%n", modificacionFecha);
               System.out.println("------------------------------");
            }
        }

    
    }
}
