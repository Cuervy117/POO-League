package liga;
import java.util.ArrayList;

import equipos.Equipo;
import jornada.Jornada;
public class Liga{
    private ArrayList<Equipo> listaEquipos;
    private ArrayList<Jornada> listaJornadas;
    private int numeroDeEquipos = listaEquipos.size();
    private boolean campeonatoIniciado = false;

    public void registrarEquipo(Equipo equipo){
        listaEquipos.add(equipo);
    }

    public void generarCalendario(){
        System.out.println("Generando Calendario...");
    }

    public void iniciarCampeonato(){
        campeonatoIniciado = true;
    }

    public void consultarTabla(){
        System.out.println(listaEquipos.toString() + numeroDeEquipos);
        System.out.println("Generando Tabla...");
    }

    public void iniciarJornada(){

    }
    public void consultarJornadas(){
        System.out.println("Consultando Jornadas");
        System.out.println(listaJornadas.toString());
    }

    public void incluirPlayoff(){
        System.out.println("No se que es esto pibes");
    }
}