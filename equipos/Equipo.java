package equipos;
import java.util.ArrayList;
import equipos.jugadores.*;
import probabilidades.ProbaGoles;

public class Equipo{
    private ArrayList<Jugador> jugadores;
    private String nombre, estadio;
    private int puntos, partidos;
    private ProbaGoles goles;


    public Equipo(ArrayList<Jugador> jugadores, String nombre, String estadio){
        this.jugadores = jugadores;
        this.nombre = nombre;
        this.estadio = estadio;
        goles = new ProbaGoles(0, 0);
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

    public int getGoles(){
        return goles.getGoles();
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

    public void addPartido(){
        partidos++;
    }
    
    public void addPuntos(int puntos){
        this.puntos += puntos;
        goles.updateGoles(this.puntos, partidos);
    }
    // endregion

}