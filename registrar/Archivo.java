import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map.Entry;

public class Archivo{

    public static void guardarEquipos(Liga l){
        try {
            Path packageActual = Paths.get(Archivo.class.getResource("Archivo.class").toURI()).getParent(); // Obtenemos el directorio del package
            Path directorio = packageActual.resolve("Equipos"); // Creamos la carpeta en caso de que no existe
            if (!Files.exists(directorio)) {
                Files.createDirectories(directorio);
            }
            Path ruta = directorio.resolve("Equipos.txt"); // Agregamos al directorio creado anteriormente el nombre del archivo
            BufferedWriter escritor = new BufferedWriter(new FileWriter(ruta.toFile(), false)); //para que no se amontone, se actualiza con cada ciclo
            //aqui va mi codigo
            /*Set <Equipo> set = l.puntosPorEquipo.keySet();
            for(Equipo e: set){
                escritor.write(e.getNombre());
                escritor.newLine();
            }*/     
              for(Entry <Equipo, Integer> entrada : l.puntosPorEquipo.entrySet()){
            escritor.write(entrada.getKey().getNombre());
            escritor.newLine();
        }

            System.out.println("Equipos guardados exitosamente");
            escritor.close();
        } catch (IOException | URISyntaxException e) {
            System.out.println("Error al guardar los equipos en el archivo" + e.getMessage());
        }  
    }

}