
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Playoff {
    LinkedHashMap<Partido, Integer> partidosPorRonda;
    Map<Equipo, Integer> lideresOrdenados;

    public Playoff(Liga liga){
        this.partidosPorRonda = new LinkedHashMap<>();
        this.lideresOrdenados = new LinkedHashMap<>(); 
    }

    public void almacenarParticipantes(Liga liga, int numDeParticipantes) {
        List <Equipo> equipos = new ArrayList<>(liga.puntosPorEquipo.keySet());
        equipos.sort((e1, e2) -> {
            int puntos1 = liga.puntosPorEquipo.get(e1);
            int puntos2 = liga.puntosPorEquipo.get(e2);
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
            lideresOrdenados.put(equipo, liga.puntosPorEquipo.get(equipo));
        }
    
       
        System.out.println("Ya se guardaron");
        lideresOrdenados.forEach((e, j) -> System.out.println(e.getNombre() + " " + j));
    }

    public void simularPlayoffs() {
        List<Equipo> equipos = new ArrayList<>(lideresOrdenados.keySet());

        while (equipos.size() > 1) {
            equipos = simularRonda(equipos);
            
        }

        if (equipos.size() == 1) {
            System.out.println("Campeón: " + equipos.get(0).getNombre());
        }
    }

    private List<Equipo> simularRonda(List<Equipo> equipos) {
        List<Equipo> ganadores = new ArrayList<>();

        int n = equipos.size();
        for (int i = 0; i < n / 2; i++) {
            Equipo local = equipos.get(i); // Primer puesto

            Equipo visitante = equipos.get(n - 1 - i); // Último puesto

            local.setGolesAFavor(0);
            visitante.setGolesAFavor(0);


            Partido partidoIda = new Partido(local, visitante);
            Equipo ganadorIda = partidoIda.eliminatoria();
            partidosPorRonda.put(partidoIda, equipos.size()/2); // Almacena el partido de ida
            System.out.println(ganadorIda.getNombre() + " " + ganadorIda.getGolesAFavor());

            Partido partidoVuelta = new Partido(visitante, local);
            Equipo ganadorVuelta = partidoVuelta.eliminatoria();
            partidosPorRonda.put(partidoVuelta, equipos.size()/2); // Almacena el partido de vuelta
            System.out.println(ganadorVuelta.getNombre() + " " + ganadorVuelta.getGolesAFavor());
            // Determina el ganador global
           System.out.println("Global ");
           System.out.println(local.getNombre() + " " +local.getGolesAFavor() + " - "+ visitante.getGolesAFavor() + " " + visitante.getNombre());
           if(local.getGolesAFavor() > visitante.getGolesAFavor()){
                ganadores.add(local);
           }
           else{
                ganadores.add(visitante);
           }
        }
        return ganadores;
    }

    private List<Equipo> obtenerGanadores(List<Equipo> equipos) {
        // Esta función debe retornar la lista de ganadores tras una ronda
        List<Equipo> ganadores = new ArrayList<>();
        for (int i = 0; i < equipos.size(); i += 2) {
            // Asumiendo que los ganadores son los equipos que se pasan
            ganadores.add(equipos.get(i)); // Ajusta esta lógica según la lógica de tu eliminatoria
        }
        return ganadores;
    }

    public LinkedHashMap<Partido, Integer> getPartidosPorRonda() {
        return partidosPorRonda;
    }



}
    
    
    



