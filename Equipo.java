public class Equipo {

    private String nombre;
    private Jugador jugadores;

    public Equipo(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
}
