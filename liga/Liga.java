package liga;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import equipos.Equipo;
import jornada.Jornada;
import java.util.LinkedHashSet;
public class Liga{
    // Atrinutos
    private LinkedHashMap<String, Equipo> equipos = new LinkedHashMap<>();
    private LinkedHashSet<Jornada> jornadas = new LinkedHashSet<>();
    private boolean campeonatoIniciado = false;
    private String nombre;
    /**
     * Constructor de la clase Liga
     * @param nombre El nombre de la liga
     */
    public Liga(String nombre){
        this.nombre = nombre;
    }

    // region Getters
    public LinkedHashMap<String,Equipo> getEquipos(){
        return equipos;
    }

    public LinkedHashSet<Jornada> getJornadas(){
        return jornadas;
    }

    public boolean getEstadoLiga(){
        return campeonatoIniciado;
    }

    public String getNombre(){
        return nombre;
    }
    // endregion
    
    // region Metodos de clase

    /**
     * Metodo que registra un equipo en la liga
     * @param equipo Equipo a registrar
     */
    public void registrarEquipo(Equipo equipo){
        equipos.put(equipo.getNombre(), equipo);
    }

    /**
     * Metodo que imprime la informacion de cada equipo en la liga
     */
    public void infoEquipos(){
        for(String e : equipos.keySet()){
            System.out.println(equipos.get(e).getNombre() + " Puntos: " + equipos.get(e).getPuntos() + " Partidos: " + equipos.get(e).getPartidos());
        }
    }

    /**
     * sin terminar
     */
    public void generarCalendario(){
        System.out.println("Generando Calendario...");
    }

    public void iniciarCampeonato(){
        campeonatoIniciado = true;
    }

    public void consultarTabla(){
        System.out.println("Generando Tabla...");
    }

    /**
     * Metodo que genera una jornada
     * @param programacion Partidos programados(relacion 0 juega con 1, 2 juega con 3, ... , n juega con n+1)
     */
    public void simularJornada(ArrayList<String> programacion){
        Jornada j = new Jornada(equipos, programacion);
        jornadas.add(j);
    }
    
    /**
     * Metodo que imprime las jornadas existentes en la liga
     */
    public void consultarJornadas(){
        System.out.println("Consultando Jornadas");
        /*for(Jornada e : jornadas){
            e.mostrarMarcadores();
        }*/
        Iterator<Jornada> a = jornadas.iterator();
        int i = 0;
        int inicio;
        Jornada aux;
        do{
            aux = a.next();
            inicio = aux.getNumJornada();
            i++;
        }while(i < inicio);

        aux.mostrarMarcadores();

    }
    /**
     * Sin terminar
     */
    public void incluirPlayoff(){
        System.out.println("No se que es esto pibes");
    }
    /**
     * Metodo que reprograma los partidos
     * @param programacion
     */
    public static void actualizarProgramacion(ArrayList<String> programacion){
        String aux = programacion.get(0);
        programacion.remove(0);
        programacion.add(aux);
    }
    // endregion

}