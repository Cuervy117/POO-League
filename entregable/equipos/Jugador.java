package equipos;
public class Jugador{
    private String nombre, posicion;
    private int edad, goles, agresividad, amonestaciones;
    private boolean lesionado;
    /**
     * Constructor de la clase Jugador
     * @param nombre El nombre del jugador
     * @param posicion La posición que juega
     * @param edad La edad del jugador
     */
    public Jugador(String nombre, String posicion, int edad){
        this.nombre = nombre;
        this.posicion = posicion;
        this.edad = edad;
    }

    // region Getters
    public String getNombre(){
        return nombre;
    }

    public String getPosicion(){
        return posicion;
    }

    public int getEdad(){
        return edad;
    }

    public int getGoles(){
        return goles;
    }

    public int getAgresividad(){
        return agresividad;
    }

    public int getAmonestaciones(){
        return amonestaciones;
    }

    public boolean getLesion(){
        return lesionado;
    }
    // endregion

    // region setters
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setPosicion(String posicion){
        this.posicion = posicion;
    }

    public void setEdad(int edad){
        this.edad = edad;
    }

    public void setAgresividad(int agresividad){
        this.agresividad = agresividad;
    }
    // endregion
    
    // region Métodos de clase
    /**
     * Metodo que obtiene un String con los datos importantes de un jugador
     * @return Informacion del jugador
     */
    public String obtenerDatos(){
        return "Nombre: " + nombre + " Edad: " + edad + " Posicion: " + posicion;
    }
    /**
     * Metodo que devuelve las estadisticas de un jugador
     * @return Estadisticas del jugador
     */
    public String obtenerEstadisticas(){
        return "Goles: " + goles + " agresividad: " + agresividad + " Amonestaciones: " + amonestaciones;
    }
    /**
     * Metodo que aumenta en uno la cantidad de goles anotados
     */
    public void aumentarGoles(){
        goles ++;
    }
    /**
     * Metodo que lesiona al jugador si no lo está
     */
    public void lesionar(){
        if(!lesionado) lesionado = true;
    }
    /**
     * Metodo que aumenta en uno las amonestaciones del jugador
     */
    public void amonestar(){
        amonestaciones++;
    }
    // endregion
}
