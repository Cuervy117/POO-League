package equipos;
import java.util.ArrayList;
import equipos.jugadores.*;

public class Equipo{
    private ArrayList<Jugador> jugadores;
    private String nombre, estadio;
    private int puntos, partidos;

    public Equipo(ArrayList<Jugador> jugadores, String nombre, String estadio){
        this.jugadores = jugadores;
        this.nombre = nombre;
        this.estadio = estadio;
    }

    // region getters
    public ArrayList<Jugador> getJugadores(){
        return jugadores;
    }

    public String getNombre(){
        return nombre;
    }

    public String getEstadio(){
        return estadio;
    }

    public int getPuntos(){
        return puntos;
    }

    public int getPartidos(){
        return partidos;
    }
    // endregion
    
    // region setters
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setEstadio(String estadio){
        this.estadio = estadio;
    }
    // endregion

    // region Metodos de clase
    public void addJugador(Jugador jugador){
        jugadores.add(jugador);
    }

    public void addPuntos(int puntos){
        this.puntos += puntos;
    }
    // endregion

}