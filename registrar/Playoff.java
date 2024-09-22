
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeSet;


public class Playoff {
    LinkedHashMap<Partido, Integer> partidosPorRonda;
    TreeSet<Equipo> participantes = new TreeSet<>();

    public Playoff(){
        this.partidosPorRonda = new LinkedHashMap<>();
        this.participantes = new TreeSet<>();
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
