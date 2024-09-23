
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;


public class Playoff {
    LinkedHashMap<Partido, Integer> partidosPorRonda;
    TreeMap<Equipo, Integer> lideres;
    TreeSet<Equipo> participantes = new TreeSet<>();

    public Playoff(Liga liga){
        this.partidosPorRonda = new LinkedHashMap<>();
        this.participantes = new TreeSet<>();
        this.lideres = new TreeMap<>((Equipo e1, Equipo e2) -> {
            int puntos1 = liga.puntosPorEquipo.getOrDefault(e1, 0);
            int puntos2 = liga.puntosPorEquipo.getOrDefault(e2, 0);
            int puntosComparison = Integer.compare(puntos2, puntos1); // Orden descendente por puntos
            if (puntosComparison != 0) {
                return puntosComparison;
            } else {
                int difGoles1 = e1.getGolesAFavor() - e1.getGolesEnContra();
                int difGoles2 = e2.getGolesAFavor() - e2.getGolesEnContra();
                return Integer.compare(difGoles2, difGoles1); // Orden descendente por diferencia de goles
            }
        });
    }

    public void almacenarParticipantes(Liga liga, int numDeParticipantes) {
        int i = 0;
        
        for (Map.Entry<Equipo, Integer> entrada : liga.puntosPorEquipo.entrySet()) {
            if (i >= numDeParticipantes) {
                break;
            }
            participantes.add(entrada.getKey());
            i++;
        }

    }


}
