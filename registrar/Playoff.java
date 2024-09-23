
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
    
        
        Map<Equipo, Integer> lideresOrdenados = new LinkedHashMap<>();
        for (int i = 0; i < numDeParticipantes && i < equipos.size(); i++) {
            Equipo equipo = equipos.get(i);
            lideresOrdenados.put(equipo, liga.puntosPorEquipo.get(equipo));
        }
    
       
        System.out.println("Ya se guardaron");
        lideresOrdenados.forEach((e, j) -> System.out.println(e.getNombre() + " " + j));
    }

    public void generarRondas(int numDeParticipantes ){
        for(int i = 0; i < numDeParticipantes/2; i ++){
            Partido ida = new Partido(equipos.get(i), equipos.get(numDeParticipantes-i-1));
            partidosPorRonda.put(ida, numDeParticipantes/2 ); //si son cuartos, va a recibir la clave 4, de modo que si lelgase a ser semifinales, la clave es 2
            Partido vuelta = new Partido(equipos.get(numDeParticipantes-i-1), equipos.get(i)); //es el partido con el local como visitante
            partidosPorRonda.put(vuelta, numDeParticipantes/2);
        }
        //ya están generadas las rondas
        
    }


    public void simularRonda(int numDeParticipantes) {
        // Resetea goles de todos los equipos antes de comenzar la ronda
        resetearGoles();
        ArrayList <Equipo> ganadores = new ArrayList<>();

        // Simular partidos de ida
        for (int i = 0; i < equipos.size()/2; i ++) {
            Equipo local = equipos.get(i);
            Equipo visitante = equipos.get(equipos.size() - i -1);
            Partido partidoIda = new Partido(local, visitante);

            // Lógica para la eliminatoria del partido de ida
            Equipo ganadorIda = partidoIda.eliminatoria();
            partidosPorRonda.put(partidoIda, equipos.size()/2); // Guardar el partido de ida

            // Simular partido de vuelta
            Partido partidoVuelta = new Partido(visitante, local);
            Equipo ganadorVuelta = partidoVuelta.eliminatoria();
            partidosPorRonda.put(partidoVuelta, equipos.size()/2); // Guardar el partido de vuelta

            if(local.getGolesAFavor() > visitante.getGolesAFavor()){
                ganadores.add(local);

            }else{
                ganadores.add(visitante);
            }

        }
        equipos = ganadores;
    }

    private void resetearGoles() {
        for (Equipo equipo : equipos) {
            equipo.setGolesAFavor(0);
            equipo.setGolesEnContra(0);
        }
    }

    public void iniciarTorneo(int numDeParticipantes){
        while(equipos.size() > 1){
            simularRonda(equipos.size());
        }
    }
}
    
    
    



