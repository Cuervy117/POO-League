package registrar;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import liga.*;
import equipos.*;
public class Archivo{

    public static void guardarEquipos(Liga l){
        try {
            Set<Map.Entry<String, Equipo>> equipos = l.getEquipos().entrySet();
            Iterator<Map.Entry<String, Equipo>> a = equipos.iterator();
            Map.Entry<String,Equipo> aux;
            Path packageActual = Paths.get(Archivo.class.getResource("Archivo.class").toURI()).getParent(); // Obtenemos el directorio del package
            Path directorio = packageActual.resolve("Equipos"); // Creamos la carpeta en caso de que no existe
            if (!Files.exists(directorio)) {
                Files.createDirectories(directorio);
            }
            Path ruta = directorio.resolve("Equipos.txt"); // Agregamos al directorio creado anteriormente el nombre del archivo
            BufferedWriter escritor = new BufferedWriter(new FileWriter(ruta.toFile(), false)); //para que no se amontone, se actualiza con cada ciclo
            while(a.hasNext()){
                aux = a.next();
                escritor.write(aux.getKey() + "\t" + aux.getValue().getPuntos());
                escritor.newLine();
            }
            escritor.write("FN");
            System.out.println("Equipos guardados exitosamente");
            escritor.close();
        } catch (IOException | URISyntaxException e) {
            System.out.println("Error al guardar los equipos en el archivo" + e.getMessage());
        }  
    }

    public static int contarEquipos() {
    int contadorLineas = 0;
    try {
        Path packageActual = Paths.get(Archivo.class.getResource("Archivo.class").toURI()).getParent();
        Path directorio = packageActual.resolve("Equipos");
        Path ruta = directorio.resolve("Equipos.txt");

        if (Files.exists(ruta)) {
            try (BufferedReader lector = new BufferedReader(new FileReader(ruta.toFile()))) {
                String linea = lector.readLine();
                while (!linea.equals("FN")) {
                    contadorLineas++;
                }
            } catch (IOException e) {
                System.out.println("Error al leer el archivo: " + e.getMessage());
            }
        } else {
            System.out.println("El archivo no existe.");
        }
    } catch (URISyntaxException e) {
        System.out.println("Error al determinar la ruta del archivo: " + e.getMessage());
    }
    return contadorLineas;
    }

     
    public static void guardarEquiposExistentes(Liga l) {
        
        try {
            Path packageActual = Paths.get(Archivo.class.getResource("Archivo.class").toURI()).getParent();
            Path directorio = packageActual.resolve("Equipos");
            Path ruta = directorio.resolve("Equipos.txt");

            if (Files.exists(ruta)) {
                try (BufferedReader lector = new BufferedReader(new FileReader(ruta.toFile()))) {
                    String linea = lector.readLine();
                    String[] bloques;
                    while (!linea.equals("FN")) {
                        bloques = linea.split("\t"); //separa cada elemento que esté tabulado
                        String nombre = bloques[0];
                        String valor = bloques[1];
                        Equipo e = new Equipo(null, nombre, null);
                        e.addPuntos(Integer.parseInt(valor));
                        l.registrarEquipo(e);
                        linea = lector.readLine();
                    }
                } catch (IOException e) {
                    System.out.println("Error al leer el archivo: " + e.getMessage());
                }
            } else {
                System.out.println("El archivo no existe.");
            }
        } catch (URISyntaxException e) {
            System.out.println("Error al determinar la ruta del archivo: " + e.getMessage());
        }
        
    }
}