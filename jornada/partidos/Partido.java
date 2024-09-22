package jornada.partidos;
import equipos.Equipo;
import java.util.Random;

public class Partido{
    private Equipo local, visitante;
    private int golesLocal, golesVisitante;
    private int[] minGolesLocal;
    private int[] minGolesVisitante;
    
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
        local.addPartido();
        visitante.addPartido();
    }

    public String mostrarMarcador(){
        String marcador = "Goles Local\tGoles Visitante\n  --" + golesLocal + "--\t\t\t--" + golesVisitante + "--" + "\n";
        boolean mayor = golesLocal > golesVisitante;
        int i = mayor? golesVisitante : golesLocal;
        for(int j = 0; j < ((mayor)? golesLocal:golesVisitante); i++){
            marcador += mayor? "--" + minGolesLocal[j] + "--" : "" ;
            marcador += "\t";
            marcador += "--" + minGolesVisitante[golesVisitante - i] + "--\n";
            i--;
        }
    
        return marcador;
    }
    
}