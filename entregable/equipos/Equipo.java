package Equipos;
import probabilidades.*;

/**
 * Clase que representa un equipo de fútbol.
 */
public class Equipo {

    private String nombre;
    private Jugador jugadores;
    private ProbaGoles rendimiento; 
    private long golesAFavor;
    private long golesEnContra;
    private int victorias;
    private int derrotas;
    private int empates;

    /**
     * Constructor para crear un equipo con un nombre específico.
     * @param nombre Nombre del equipo.
     */
    public Equipo(String nombre){
        this.nombre = nombre;
        this.rendimiento = new ProbaGoles(0, 0);
        this.golesAFavor = 0;
        this.golesEnContra = 0;
        this.victorias = 0;
        this.empates = 0;
        this.derrotas = 0;
    }

    //region Getters

    /**
     * Obtiene el nombre del equipo.
     * @return Nombre del equipo.
     */
    public String getNombre(){
        return nombre;
    }

    /**
     * Obtiene los goles a favor del equipo.
     * @return Goles a favor.
     */
    public long getGolesAFavor(){
        return golesAFavor;
    }

    /**
     * Obtiene los goles en contra del equipo.
     * @return Goles en contra.
     */
    public long getGolesEnContra(){
        return golesEnContra;
    }

    /**
     * Obtiene el número de empates del equipo.
     * @return Número de empates.
     */
    public int getEmpates() {
        return empates;
    }

    /**
     * Obtiene el número de derrotas del equipo.
     * @return Número de derrotas.
     */
    public int getDerrotas() {
        return derrotas;
    }

    /**
     * Obtiene el número de victorias del equipo.
     * @return Número de victorias.
     */
    public int getVictorias() {
        return victorias;
    }

    //endregion

    //region Setters

    /**
     * Establece el nombre del equipo.
     * @param nombre Nombre del equipo.
     */
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    /**
     * Establece los goles a favor del equipo.
     * @param golesAFavor Goles a favor.
     */
    public void setGolesAFavor(long golesAFavor){
        this.golesAFavor = golesAFavor;
    }

    /**
     * Establece los goles en contra del equipo.
     * @param golesEnContra Goles en contra.
     */
    public void setGolesEnContra(long golesEnContra){
        this.golesEnContra = golesEnContra;
    }

    /**
     * Establece el número de victorias del equipo.
     * @param victorias Número de victorias.
     */
    public void setVictorias(int victorias) {
        this.victorias = victorias;
    }

    /**
     * Establece el número de derrotas del equipo.
     * @param derrotas Número de derrotas.
     */
    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }

    /**
     * Establece el número de empates del equipo.
     * @param empates Número de empates.
     */
    public void setEmpates(int empates) {
        this.empates = empates;
    }

    //endregion

    //region Métodos de clase

    /**
     * Actualiza el rendimiento del equipo basado en victorias y derrotas.
     * @param victorias Número de victorias.
     * @param derrotas Número de derrotas.
     */
    public void setRendimiento(int victorias, int derrotas){
        this.rendimiento.updateProba(victorias, derrotas);
    }

    /**
     * Obtiene los goles por partido del equipo.
     * @return Goles por partido.
     */
    public long getGolesPorPartido(){
        return this.rendimiento.goles();
    }

    //endregion
}

