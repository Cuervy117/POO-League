package jornada;
import java.util.ArrayList;
import jornada.partidos.Partido;
import equipos.Equipo;
import java.util.LinkedHashMap;
public class Jornada{
    private static int numJornada = 0;
    private ArrayList<Partido> listaDePartidos = new ArrayList<>();

    public Jornada(LinkedHashMap<String, Equipo> equipos, ArrayList<String> programacion){
        numJornada++;
        for(int i = 0; i < 18; i+=2){
            Partido a = new Partido(equipos.get(programacion.get(i)),equipos.get(programacion.get(i + 1)));
            a.simularPartido();
            listaDePartidos.add(a);
        }
    }

    public int getNumJornada(){
        return numJornada;
    }

    public void mostrarMarcadores(){
        System.out.println("Jornada numero " + numJornada);
        for(Partido e : listaDePartidos){
            System.out.println("Partido " + (listaDePartidos.indexOf(e) + 1));
            System.out.println(e.getLocal().getNombre() + " vs " + e.getVisitante().getNombre());
            //System.out.println(e.mostrarMarcador());
        }
    }
}