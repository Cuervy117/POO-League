package jornada.partidos;
import equipos.Equipo;
import java.util.Random;

public class Partido{
    // Atributos
    private Equipo local, visitante;
    private int golesLocal, golesVisitante;
    private int[] minGolesLocal;
    private int[] minGolesVisitante;
    
    /**
     * Constructor de la clase partido
     * @param local El equipo local
     * @param visitante El equipo visitante
     */
    public Partido(Equipo local, Equipo visitante){
        this.local = local;
        this.visitante = visitante;
        golesLocal = local.getGoles();
        golesVisitante = visitante.getGoles();
    }
 
    // region getters
    public Equipo getLocal(){
        return local;
    }

    public Equipo getVisitante(){
        return visitante;
    }

    public long getGolesLocal(){
        return golesLocal;
    }

    public long getGolesVisitante(){
        return golesVisitante;
    }

    public String getMarcador(){
        return "Goles Visitante : " + golesVisitante + " Goles Local : " + golesLocal;
    }
    // endregion

    // region Metodos de clase
    /**
     * Metodo que simula un partido entre los equipos local y visitante
     */
    public void simularPartido(){
        int auxGolesLocal = golesLocal, auxGolesVisitante = golesVisitante;
        minGolesLocal = new int[golesLocal];
        minGolesVisitante = new int[golesVisitante];

        Random rn = new Random();
        for(int i = 0; i < 90; i += 10){
            if (rn.nextInt(10) < 2 && auxGolesLocal > 0) {
                minGolesLocal[minGolesLocal.length - auxGolesLocal] = rn.nextInt(10) + i;
                auxGolesLocal--;
            }
            if (rn.nextInt(10) > 8 && auxGolesVisitante > 0) {
                minGolesVisitante[minGolesVisitante.length - auxGolesVisitante] = rn.nextInt(10) + i;
                auxGolesVisitante--;
            }
        }

        while(auxGolesLocal > 0){
            minGolesLocal[minGolesLocal.length - auxGolesLocal] = 95;
            auxGolesLocal--;
        }
        while (auxGolesVisitante > 0) {
            minGolesVisitante[minGolesVisitante.length - auxGolesVisitante] = 95;
            auxGolesVisitante--;
        }

        if(golesLocal > golesVisitante){
            local.addPuntos(3);
        }else if(golesVisitante > golesLocal){
            visitante.addPuntos(3);
        }else{
            local.addPuntos(1);
            visitante.addPuntos(1);
        }

        local.addPartido();
        visitante.addPartido();
    }

    /**
     * Metodo(temporal) que genera un marcador con los goles y minutos de cada equipo
     * @return Cadena de texto con el marcador 
     */
    public String mostrarMarcador(){
        String marcador = "Goles Local\tGoles Visitante\n  --" + golesLocal + "--\t\t\t--" + golesVisitante + "--" + "\n";
        boolean menor = golesLocal <= golesVisitante;
        int i = menor? golesVisitante : golesLocal;
        for(int j = 0; j < ((menor)? golesLocal:golesVisitante); j++){
            marcador += "  --" + minGolesLocal[j] + "--";
            marcador += "\t\t\t";
            marcador += "--" + minGolesVisitante[j] + "--\n";
            i--;
        }
        while(i > 0){
            if(menor){
                marcador += "  \t\t\t--" + minGolesVisitante[golesVisitante - i] + "--";
                i--;
            }else{
                marcador += "  --" + minGolesLocal[golesLocal - i] + "--";
                i--;
            }
        }
    
        return marcador;
    }
    // endregion
}