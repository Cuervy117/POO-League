import Equipos.*;
import competiciones.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map.Entry;

/**
 * Clase que maneja la lectura y escritura de archivos relacionados con los equipos y la liga.
 */
public class Archivo {

    //region Métodos de clase

    /**
     * Guarda los equipos de la liga en un archivo.
     * @param l Liga cuyos equipos se guardarán.
     */
    public static void guardarEquipos(Liga l) {
        try {
            Path packageActual = Paths.get(Archivo.class.getResource("Archivo.class").toURI()).getParent(); // Obtenemos el directorio del package
            Path directorio = packageActual.resolve("Equipos"); // Creamos la carpeta en caso de que no exista
            if (!Files.exists(directorio)) {
                Files.createDirectories(directorio);
            }
            Path ruta = directorio.resolve("Equipos.txt"); // Agregamos al directorio creado anteriormente el nombre del archivo
            BufferedWriter escritor = new BufferedWriter(new FileWriter(ruta.toFile(), false)); // para que no se amontone, se actualiza con cada ciclo
            for (Entry<Equipo, Integer> entrada : l.getPuntosPorEquipo().entrySet()) {
                escritor.write(entrada.getKey().getNombre() + "\t" + entrada.getValue());
                escritor.newLine();
            }

            System.out.println("Equipos guardados exitosamente");
            escritor.close();
        } catch (IOException | URISyntaxException e) {
            System.out.println("Error al guardar los equipos en el archivo: " + e.getMessage());
        }
    }

    /**
     * Cuenta el número de equipos en el archivo.
     * @return Número de equipos.
     */
    public static int contarEquipos() {
        int contadorLineas = 0;
        try {
            Path packageActual = Paths.get(Archivo.class.getResource("Archivo.class").toURI()).getParent();
            Path directorio = packageActual.resolve("Equipos");
            Path ruta = directorio.resolve("Equipos.txt");

            if (Files.exists(ruta)) {
                try (BufferedReader lector = new BufferedReader(new FileReader(ruta.toFile()))) {
                    String linea;
                    while ((linea = lector.readLine()) != null) {
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

    /**
     * Guarda los equipos existentes en la liga desde un archivo.
     * @param l Liga en la que se guardarán los equipos.
     */
    public static void guardarEquiposExistentes(Liga l) {
        try {
            Path packageActual = Paths.get(Archivo.class.getResource("Archivo.class").toURI()).getParent();
            Path directorio = packageActual.resolve("Equipos");
            Path ruta = directorio.resolve("Equipos.txt");

            if (Files.exists(ruta)) {
                try (BufferedReader lector = new BufferedReader(new FileReader(ruta.toFile()))) {
                    String linea;
                    while ((linea = lector.readLine()) != null) {
                        String[] bloques = linea.split("\t"); // separa cada elemento que esté tabulado
                        String nombre = bloques[0];
                        String valor = bloques[1];

                        l.getPuntosPorEquipo().put(new Equipo(nombre), Integer.valueOf(valor));
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
    /**
 * Escribe la tabla general de la liga en un archivo.
 * @param l Liga cuyos datos se utilizarán para generar la tabla.
 */
public static void escribirTablaGeneral(Liga l) {
    try {
        Path packageActual = Paths.get(Archivo.class.getResource("Archivo.class").toURI()).getParent(); // Obtenemos el directorio del package
        Path directorio = packageActual.resolve("Equipos"); // Creamos la carpeta en caso de que no exista
        if (!Files.exists(directorio)) {
            Files.createDirectories(directorio);
        }
        Path ruta = directorio.resolve("Tabla.txt"); // Agregamos al directorio creado anteriormente el nombre del archivo
        BufferedWriter escritor = new BufferedWriter(new FileWriter(ruta.toFile(), false)); // para que no se amontone, se actualiza con cada ciclo
        
        // aqui empieza tu codiguito
        int i = 1;
        // ordenar los equipos por puntaje
        
        for (Entry<Equipo, Integer> entrada : l.getPuntosPorEquipo().entrySet()) {
            Equipo equipo = entrada.getKey();
            String partidos = equipo.getVictorias() + "\t" + equipo.getEmpates() + "\t" + equipo.getDerrotas();
            String goles = equipo.getGolesAFavor() + "\t" + equipo.getGolesEnContra() + "\t" + (equipo.getGolesAFavor() - equipo.getGolesEnContra());
            escritor.write(i + "\t" + equipo.getNombre() + "\t" + partidos + "\t" + goles + "\t" + entrada.getValue());
            escritor.newLine();
            i++;
        }

        System.out.println("Tabla generada exitosamente");
        escritor.close();
    } catch (IOException | URISyntaxException e) {
        System.out.println("Error al generar la tabla" + e.getMessage());
    }
}

    //endregion
}