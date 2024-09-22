package equipos;
import java.util.ArrayList;
import equipos.jugadores.*;
import probabilidades.ProbaGoles;

public class Equipo{
    private ArrayList<Jugador> jugadores;
    private String nombre, estadio;
    private int puntos, partidos;
    private ProbaGoles goles;

    /**
     * Constructor para la clase Equipo
     * @param jugadores ArrayList de jugadores pertenecientes al equipo
     * @param nombre El nombre del equipo
     * @param estadio El nombre de su estadio
     */
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
    /**
     * Metodo para agregar un jugador a un equipo
     * @param jugador El jugador a agregar
     */
    public void addJugador(Jugador jugador){
        jugadores.add(jugador);
    }

    /**
     * Metodo que incrementa en uno los partidos jugados por el equipo
     */
    public void addPartido(){
        partidos++;
    }
    
    /**
     * Metodo que actualiza los puntos del equipo
     * @param puntos Los puntos ganados en un partido
     */
    public void addPuntos(int puntos){
        this.puntos += puntos;
        goles.updateGoles(this.puntos, partidos);
    }
    // endregion

}