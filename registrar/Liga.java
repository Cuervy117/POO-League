import java.util.LinkedHashMap;
import java.util.Set;
import java.util.TreeMap;

public class Liga {
    String nombre;
    TreeMap<Equipo, Integer> puntosPorEquipo; //la llave son los equipos ya que son únicos y cada llave contiene un valor que son los puntos
    LinkedHashMap<Partido, Integer> jornadas;

    public Liga(String nombre){
        this.nombre = nombre;
        this.puntosPorEquipo = new TreeMap<>((Equipo e1, Equipo e2) -> e1.getNombre().compareTo(e2.getNombre()) //el tree map va a estar ordenado inicialmente por orden alfabético
        );
        this.jornadas = new LinkedHashMap<>();
    }

    public  void registrarEquipo(Equipo e){
        this.puntosPorEquipo.put(e, 0);
    }

    public void mostrarEquipos(){
        Set <Equipo> set = puntosPorEquipo.keySet(); //creo un set únicamente de equipos para poderlos ordenar alfabeticamente
        /*for(Entry <Equipo, Integer> entrada : puntosPorEquipo.entrySet()){
            System.out.println(entrada.getKey().getNombre());
        }*/
        for(Equipo equipo: set){
            System.out.println(equipo.getNombre());
        }

    }

    public void generarCalendario(){

        if(Archivo.contarEquipos() == 0){
            System.out.println("No hay equipos");

        }
        int i = 0, j = 0;
        //definir numero de equipos participantes, n será la variable
        
        Partido[][] calendario;
        
        
    }




}
