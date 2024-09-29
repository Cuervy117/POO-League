package competiciones;
import Equipos.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Scanner;

/**
 * Clase que representa un torneo de playoffs.
 */
public class Playoff {
    LinkedHashMap<Partido, Integer> partidosPorRonda;
    Map<Equipo, Integer> lideresOrdenados;

    /**
     * Constructor para crear un torneo de playoffs basado en una liga.
     * @param liga La liga de la cual se extraen los equipos para el playoff.
     */
    public Playoff(Liga liga){
        this.partidosPorRonda = new LinkedHashMap<>();
        this.lideresOrdenados = new LinkedHashMap<>(); 
    }

    //region Métodos de clase

    /**
     * Almacena los participantes del playoff basándose en su rendimiento en la liga.
     * @param liga La liga de la cual se extraen los equipos.
     * @param numDeParticipantes Número de equipos que participarán en el playoff.
     */
    public void almacenarParticipantes(Liga liga, int numDeParticipantes) {
        List<Equipo> equipos = new ArrayList<>(liga.getPuntosPorEquipo().keySet());
        equipos.sort((e1, e2) -> {
            int puntos1 = liga.getPuntosPorEquipo().get(e1);
            int puntos2 = liga.getPuntosPorEquipo().get(e2);
            int puntosComparison = Integer.compare(puntos2, puntos1); 
            if (puntosComparison != 0) {
                return puntosComparison;
            } else {
                Long difGoles1 = e1.getGolesAFavor() - e1.getGolesEnContra();
                Long difGoles2 = e2.getGolesAFavor() - e2.getGolesEnContra();
                int difGolesComparison = Long.compare(difGoles2, difGoles1); 
                if (difGolesComparison != 0) {
                    return difGolesComparison;
                } else {
                    return e1.getNombre().compareTo(e2.getNombre()); 
                }
            }
        });
    
        for (int i = 0; i < numDeParticipantes && i < equipos.size(); i++) {
            Equipo equipo = equipos.get(i);
            lideresOrdenados.put(equipo, liga.getPuntosPorEquipo().get(equipo));
        }
    
        System.out.println("Ya se guardaron");
        lideresOrdenados.forEach((e, j) -> System.out.println(e.getNombre() + " " + j));
    }

    /**
     * Simula los playoffs hasta determinar el campeón.
     */
    public void simularPlayoffs(Scanner sc) {
        List<Equipo> equipos = new ArrayList<>(lideresOrdenados.keySet());
        List<Equipo> ganadores = new ArrayList<>();

        while (equipos.size() > 1) {
            System.out.println("\tRonda: " +  equipos.size()/2);
            
            ganadores = simularRonda(equipos, sc);
            equipos = ganadores;
        }

        if (equipos.size() == 1) {
            System.out.println("Campeón: " + equipos.get(0).getNombre());
        }
    }

    /**
     * Simula una ronda de playoffs.
     * @param equipos Lista de equipos que participan en la ronda.
     * @return Lista de equipos ganadores de la ronda.
     */
    private List<Equipo> simularRonda(List<Equipo> equipos, Scanner sc) {
        List<Equipo> ganadores = new ArrayList<>();

        int n = equipos.size();
        for (int i = 0; i < n / 2; i++) {
            Equipo local = equipos.get(i); // Primer puesto
            Equipo visitante = equipos.get(n - 1 - i); // Último puesto
            local.setGolesAFavor(0);
            visitante.setGolesAFavor(0);

            Partido partidoIda = new Partido(local, visitante);
            partidoIda.ganadorLocal();
            partidosPorRonda.put(partidoIda, equipos.size() / 2); // Almacena el partido de ida
            System.out.println(local.getNombre() + " " + partidoIda.getGolesLocal()+ " - " + partidoIda.getGolesVisitante()+ " " + visitante.getNombre() );
            Partido partidoVuelta = new Partido(visitante, local);
            partidoVuelta.ganadorLocal();

            if (local.getGolesAFavor() == visitante.getGolesAFavor()) {
                Partido remontada = new Partido(visitante, local);
                System.out.println("Tiempos extra");
                remontada.eliminatoria();
                partidosPorRonda.put(remontada, equipos.size()/2); //En caso de tener empate global
            }else{
                partidosPorRonda.put(partidoVuelta, equipos.size()/2); //Almacena el partido de vuelta
                System.out.println(visitante.getNombre() + " " + partidoVuelta.getGolesLocal()+ " - " + partidoVuelta.getGolesVisitante()+ " " + local.getNombre() );

            }
            
            if (local.getGolesAFavor() > visitante.getGolesAFavor()) {
                ganadores.add(local);
            } else {
                ganadores.add(visitante);
            }
            System.out.println("====  Global ==== ");
            System.out.println(local.getNombre() + " " + local.getGolesAFavor() + " - " + visitante.getGolesAFavor() + " " + visitante.getNombre());
            System.out.println("Presiona Enter para continuar...");
            sc.nextLine();

        }
        return ganadores;
    }

        public void mostrarRondas(Integer numeroJornada) {

        for (Entry<Partido, Integer> entrada : partidosPorRonda.entrySet()) {
            if (Objects.equals(partidosPorRonda.get(entrada.getKey()), numeroJornada)) {
                Equipo local = entrada.getKey().getLocal();
                Equipo visitante = entrada.getKey().getVisitante();
                Partido partido = entrada.getKey();
                // Determina el ganador global
                System.out.println(local.getNombre() + " " + partido.getGolesLocal() + " - " + partido.getGolesVisitante() + " " + visitante.getNombre());

            }
        }
    }

    //endregion

    //region Getters

    /**
     * Obtiene los partidos por ronda.
     * @return Mapa de partidos por ronda.
     */
    public LinkedHashMap<Partido, Integer> getPartidosPorRonda() {
        return partidosPorRonda;
    }

    //endregion
}

    



