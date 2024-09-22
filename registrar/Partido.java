public class Partido {
    int minutos = 90;
    private Equipo local;
    private Equipo visitante;
    public Partido(Equipo local, Equipo visitante){
        this.local = local;
        this.visitante = visitante;
    }

    public Partido(Equipo local){
        this.local = local;
    }

    public void setLocal(Equipo local){
        this.local = local;
    }

    public void setVisitante(Equipo visitante){
        this.visitante = visitante;
    }

    public void mostrarPartido(){
    }
}
