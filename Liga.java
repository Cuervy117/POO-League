import java.util.ArrayList;

public class Liga {
    String nombre;
    ArrayList <Equipo> equipos;

    public Liga(String nombre){
        this.nombre = nombre;
        this.equipos = new ArrayList<Equipo>();

    }

    public  void registrarEquipo(Equipo e){
        this.equipos.add(e);
    }

    public void mostrarEquipos(){
        for (Equipo e: equipos){
            System.out.println(e.getNombre());
        }

    }
}
