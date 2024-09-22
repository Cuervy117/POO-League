public class Equipo {

    private String nombre;
    private Jugador jugadores;
    private ProbaGoles rendimiento; 
    private int golesAFavor ;
    private int golesEnContra;
    private int victorias ;
    private int derrotas ;
    private int empates ;
    public Equipo(String nombre){
        this.nombre = nombre;
        this.rendimiento = new ProbaGoles(0, 0);
        this.golesAFavor = 0;
        this.golesEnContra = 0;
        this.victorias = 0;
        this.empates = 0;
        this.derrotas = 0;
    }

    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setGolesAFavor(int golesAFavor){
        this.golesAFavor = golesAFavor;
    }

    public void setGolesEnContra(int golesEnContra){
        this.golesEnContra = golesEnContra;
    }

    public int getGolesAFavor(){
        return golesAFavor;
    }

    public int getGolesEnContra(){
        return golesEnContra;
    }

    public void setRendimiento(int victorias, int derrotas){
        this.rendimiento.updateProba(victorias, derrotas);
    }

    public int getEmpates() {
        return empates;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public int getVictorias() {
        return victorias;
    }

    public void setVictorias(int victorias) {
        this.victorias = victorias;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }

    public void setEmpates(int empates) {
        this.empates = empates;
    }

    public long getGolesPorPartido(){
        return this.rendimiento.goles();
    }

}
