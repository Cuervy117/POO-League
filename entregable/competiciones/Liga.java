package competiciones;
import equipos.*;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.TreeMap;

/**
 * Clase que representa una liga de fútbol.
 */
public class Liga {
    private String nombre;
    private TreeMap<Equipo, Integer> puntosPorEquipo; // la llave son los equipos ya que son únicos y cada llave contiene un valor que son los puntos
    private LinkedHashMap<Partido, Integer> jornadas;

    /**
     * Constructor para crear una liga con un nombre específico.
     * @param nombre Nombre de la liga.
     */
    public Liga(String nombre) {
        this.nombre = nombre;
        this.puntosPorEquipo = new TreeMap<>((Equipo e1, Equipo e2) -> e1.getNombre().compareTo(e2.getNombre())); // inicializa ordenando alfabeticamente
        this.jornadas = new LinkedHashMap<>();
    }

    //region Métodos de clase

    /**
     * Registra un equipo en la liga.
     * @param e Equipo a registrar.
     */
    public void registrarEquipo(Equipo e) {
        this.puntosPorEquipo.put(e, 0);
    }

    /**
     * Muestra los equipos registrados en la liga.
     */
    public void mostrarEquipos() {
        for (Entry<Equipo, Integer> entrada : puntosPorEquipo.entrySet()) {
            System.out.println(entrada.getKey().getNombre() + " " + entrada.getValue());
        }
    }

    /**
     * Muestra la temporada de cada equipo en la liga.
     */
    public void mostrarTemporadaPorEquipo() {
        for (Entry<Equipo, Integer> entrada : puntosPorEquipo.entrySet()) {
            Equipo equipo = entrada.getKey();
            System.out.println(equipo.getNombre() + "\t" + equipo.getVictorias() + "\t" + equipo.getEmpates() + "\t" + equipo.getDerrotas());
        }
    }

    /**
     * Muestra todas las jornadas de la liga.
     */
    public void mostrarJornadas() {
        for (Entry<Partido, Integer> entrada : jornadas.entrySet()) {
            System.out.println(entrada.getKey().mostrarPartido() + "\t" + entrada.getValue());
        }
    }

    /**
     * Muestra las jornadas de la liga para un número específico de jornada.
     * @param numeroJornada Número de la jornada a mostrar.
     */
    public void mostrarJornadas(Integer numeroJornada) {
        for (Entry<Partido, Integer> entrada : jornadas.entrySet()) {
            if (Objects.equals(jornadas.get(entrada.getKey()), numeroJornada)) {
                System.out.println(entrada.getKey().mostrarPartido() + "\t" + entrada.getValue());
            }
        }
    }

    /**
     * Muestra las jornadas de la liga hasta un número específico de jornada.
     * @param numeroJornada Número de la jornada límite a mostrar.
     */
    public void mostrarRangoJornadas(Integer numeroJornada) {
        for (Entry<Partido, Integer> entrada : jornadas.entrySet()) {
            if (jornadas.get(entrada.getKey()) <= numeroJornada) {
                System.out.println(entrada.getKey().mostrarPartido() + "\t" + entrada.getValue());
            } else {
                return;
            }
        }
    }

    /**
     * Muestra las jornadas de la liga para un equipo específico.
     * @param nombreEquipo Nombre del equipo cuyas jornadas se desean mostrar.
     */
    public void mostrarJornadasPorEquipo(String nombreEquipo) {
        for (Entry<Partido, Integer> entrada : jornadas.entrySet()) {
            if (entrada.getKey().getLocal().getNombre().equals(nombreEquipo) || entrada.getKey().getVisitante().getNombre().equals(nombreEquipo)) {
                System.out.println(entrada.getKey().mostrarPartido() + entrada.getValue());
            }
        }
    }
    /**
     * Simula la temporada completa de la liga, actualizando los puntos y estadísticas de cada equipo.
     */
    public void simularTemporada() {
        for (Entry<Partido, Integer> entrada : jornadas.entrySet()) {
            Partido partido = entrada.getKey();
            Equipo local = partido.getLocal();
            Equipo visitante = partido.getVisitante();

            int previosLocal = puntosPorEquipo.getOrDefault(local, 0);
            int previosVisitante = puntosPorEquipo.getOrDefault(visitante, 0);

            System.out.println(local.getNombre() + " " + local.getGolesPorPartido() + " - " + visitante.getNombre() + " " + visitante.getGolesPorPartido());

            switch (partido.ganadorLocal()) {
                case 0 -> {
                    // Empate
                    puntosPorEquipo.put(local, previosLocal + 1);
                    puntosPorEquipo.put(visitante, previosVisitante + 1);
                    local.setEmpates(local.getEmpates() + 1);
                    visitante.setEmpates(visitante.getEmpates() + 1);
                }
                case 1 -> {
                    // Gana local
                    puntosPorEquipo.put(local, previosLocal + 3);
                    local.setVictorias(local.getVictorias() + 1);
                    visitante.setDerrotas(visitante.getDerrotas() + 1);
                }
                case -1 -> {
                    // Gana visitante
                    puntosPorEquipo.put(visitante, previosVisitante + 3);
                    local.setDerrotas(local.getDerrotas() + 1);
                    visitante.setVictorias(visitante.getVictorias() + 1);
                }
            }

            local.setRendimiento(local.getVictorias(), local.getDerrotas());
            visitante.setRendimiento(visitante.getVictorias(), visitante.getDerrotas());
        }
        // para ordenar por puntos
    }
        /**
     * Genera el calendario de partidos para la liga.
     * Cada equipo juega contra todos los demás equipos una vez en casa y una vez fuera.
     * El calendario solo se genera si el número de equipos es par.
     */
    public void generarCalendario() {
        if (!puntosPorEquipo.isEmpty()) {
            System.out.println("Generando Calendario...");
            // Definir número de equipos participantes, n será la variable
            int n = puntosPorEquipo.size(); // antes estaba Archivo.contarEquipos()
            if (n % 2 == 0) { // Procede en caso de que el número de equipos sea par
                int l = 0; // Variable contadora para almacenar cada equipo local
                int v = 0; // Variable contadora para almacenar cada equipo visitante
                System.out.println("n vale " + n);
                Partido[][] calendario = new Partido[n - 1][n / 2]; // [filas][columnas]

                for (int i = 0; i < n - 1; i++) { // i es para filas
                    for (int j = 0; j < n / 2; j++) { // j es para columnas
                        if (l > puntosPorEquipo.size() - 2) {
                            l = 0; // Se evalúa que l no sobrepase el número de equipos que hay
                        }
                        if (v > puntosPorEquipo.size() - 2) {
                            v = 0;
                        }

                        Equipo local = (Equipo) puntosPorEquipo.keySet().toArray()[l]; // Se obtiene el equipo 'l' del mapa que contiene a los equipos ordenados
                        Equipo visitante = (Equipo) puntosPorEquipo.keySet().toArray()[(n - 2) - v]; // Se obtiene el equipo visitante
                        Equipo c = (Equipo) puntosPorEquipo.keySet().toArray()[puntosPorEquipo.size() - 1]; // Este es el último equipo en aparecer

                        if (i % 2 == 1 && j == 0) { // Evalúa si el ciclo está en fila impar y que también se encuentre en la primera columna
                            calendario[i][j] = new Partido(c, local); // Se asigna el último equipo como local
                        } else {
                            if (i % 2 == 0 && j == 0) {
                                calendario[i][j] = new Partido(local, c); // Se asigna el equipo local y el último equipo como visitante
                            } else {
                                calendario[i][j] = new Partido(local, visitante); // Se asigna el equipo local y el equipo visitante
                                v++; // Solamente en los casos donde no nos encontremos en la primera columna
                            }
                        }

                        l++; // l sigue recorriendo a los equipos
                    }
                }

                // Mostrar los partidos generados
                for (int a = 0; a < n - 1; a++) {
                    for (int b = 0; b < n / 2; b++) {
                        // prueba para almacenar en jornadas
                        jornadas.put(calendario[a][b], a + 1); // a representa el valor de la jornada disputada
                        // calendario[a][b].mostrarPartido();
                    }
                }
                mostrarJornadas();
            } else {
                System.out.println("El numero de equipos no es par");
            }
        } else {
            System.out.println("No has ingresado ningún equipo");
        }
    }
    /**
     * Obtiene el mapa de puntos por equipo.
     * @return Mapa de puntos por equipo.
     */
    public TreeMap<Equipo, Integer> getPuntosPorEquipo() {
        return puntosPorEquipo;
    }

    /**
     * Obtiene el mapa de jornadas.
     * @return Mapa de jornadas.
     */
    public LinkedHashMap<Partido, Integer> getJornadas() {
        return jornadas;
    }
    //endregion
}
