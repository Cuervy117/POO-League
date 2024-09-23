
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Playoff {
    LinkedHashMap<Partido, Integer> partidosPorRonda;
    List<Equipo> equipos;

    public Playoff(Liga liga){
        this.partidosPorRonda = new LinkedHashMap<>();
        this.equipos = new ArrayList<>(liga.puntosPorEquipo.keySet());

    }

    public void almacenarParticipantes(Liga liga, int numDeParticipantes) {
        List<Equipo> equipos = new ArrayList<>(liga.puntosPorEquipo.keySet());
    
        // Ordenar la lista de equipos según los criterios
        equipos.sort((e1, e2) -> {
            int puntos1 = liga.puntosPorEquipo.get(e1);
            int puntos2 = liga.puntosPorEquipo.get(e2);
            int puntosComparison = Integer.compare(puntos2, puntos1); // Orden descendente por puntos
            if (puntosComparison != 0) {
                return puntosComparison;
            } else {
                Long difGoles1 = e1.getGolesAFavor() - e1.getGolesEnContra();
                Long difGoles2 = e2.getGolesAFavor() - e2.getGolesEnContra();
                int difGolesComparison = Long.compare(difGoles2, difGoles1); // Orden descendente por diferencia de goles
                if (difGolesComparison != 0) {
                    return difGolesComparison;
                } else {
                    return e1.getNombre().compareTo(e2.getNombre()); // Orden ascendente por nombre
                }
            }
        });
    
        // Crear un mapa para almacenar los líderes ordenados
        Map<Equipo, Integer> lideresOrdenados = new LinkedHashMap<>();
        for (int i = 0; i < numDeParticipantes && i < equipos.size(); i++) {
            Equipo equipo = equipos.get(i);
            lideresOrdenados.put(equipo, liga.puntosPorEquipo.get(equipo));
        }
    
        // Imprimir los líderes ordenados
        System.out.println("Ya se guardaron");
        lideresOrdenados.forEach((e, j) -> System.out.println(e.getNombre() + " " + j));
    }
    
    


}
