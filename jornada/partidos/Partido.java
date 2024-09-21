package jornada.partidos;
import equipos.Equipo;
public class Partido{
    private Equipo local, visitante;
    private int golesLocal, golesVisitante;
    
    public Partido(Equipo local, Equipo visitante){
        this.local = local;
        this.visitante = visitante;
    }

    // region getters
    public Equipo getLocal(){
        return local;
    }

    public Equipo getVisitante(){
        return visitante;
    }

    public int getGolesLocal(){
        return golesLocal;
    }

    public int getGolesVisitante(){
        return golesVisitante;
    }
    // endregion

    
}