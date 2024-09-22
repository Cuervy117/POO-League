package liga;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import equipos.Equipo;
import jornada.Jornada;
import java.util.LinkedHashSet;
public class Liga{
    private LinkedHashMap<String, Equipo> equipos = new LinkedHashMap<>();
    private LinkedHashSet<Jornada> jornadas = new LinkedHashSet<>();
    private boolean campeonatoIniciado = false;

    public void registrarEquipo(Equipo equipo){
        equipos.put(equipo.getNombre(), equipo);
    }

    public void infoEquipos(){
        for(String e : equipos.keySet()){
            System.out.println(equipos.get(e).getNombre() + " Puntos: " + equipos.get(e).getPuntos() + " Partidos: " + equipos.get(e).getPartidos());
        }
    }

    public void generarCalendario(){
        System.out.println("Generando Calendario...");
    }

    public void iniciarCampeonato(){
        campeonatoIniciado = true;
    }

    public void consultarTabla(){
        System.out.println("Generando Tabla...");
    }

    public void simularJornada(ArrayList<String> programacion){
        Jornada j = new Jornada(equipos, programacion);
        jornadas.add(j);
    }
    
    public void consultarJornadas(){
        System.out.println("Consultando Jornadas");
        for(Jornada e : jornadas){
            e.mostrarMarcadores();
        }
    }

    public void incluirPlayoff(){
        System.out.println("No se que es esto pibes");
    }

    public static void actualizarProgramacion(ArrayList<String> programacion){
        String aux = programacion.get(0);
        programacion.remove(0);
        programacion.add(aux);
    }

}