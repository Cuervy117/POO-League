package equiposs;
import java.util.ArrayList;
import equiposs.jugadores.*;;
public class Equipo{
    private String nombreEquipo;
    private String estadio;
    private ArrayList<Jugador> jugadores;
    private int puntos;

    public Equipo(String nombreEquipo, String estadio){
        this.nombreEquipo = nombreEquipo;
        this.estadio = estadio;
    }

    public void agregarJugador(Jugador jugador){
        jugadores.add(jugador);
    }

    public void anadirPuntos(int puntos){
        this.puntos += puntos;
    }

    public void obtenerDatos(){
        System.out.println(nombreEquipo);
        System.out.println(estadio);
        System.out.println(jugadores.toString());
    }

    public void obtenerPuntos(){
        System.out.println(puntos);
    }

}