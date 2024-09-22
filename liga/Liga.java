package liga;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import equipos.Equipo;
import jornada.Jornada;
import java.util.LinkedHashSet;
public class Liga{
    private LinkedHashMap<String, Equipo> equipos;
    private LinkedHashSet<Jornada> jornadas;
    private int numeroDeEquipos = equipos.size();
    private boolean campeonatoIniciado = false;

    public void registrarEquipo(Equipo equipo){
        equipos.put(equipo.getNombre(), equipo);
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
        System.out.println(jornadas.toString());
    }

    public void incluirPlayoff(){
        System.out.println("No se que es esto pibes");
    }


}