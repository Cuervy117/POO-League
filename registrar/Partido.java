public class Partido {
    int minutos = 90;
    private Equipo local;
    private Equipo visitante;
    public Partido(Equipo local, Equipo visitante){
        this.local = local;
        this.visitante = visitante;
    }
    public Partido(){

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

    /*public void mostrarPartido(){
        System.out.println(this.local.getNombre() + " - " + this.visitante.getNombre());
    }*/

    public String mostrarPartido(){
        return this.local.getNombre() + " - " + this.visitante.getNombre();
    }

    public Equipo getLocal(){
        return local;
    }

    public Equipo getVisitante(){
        return visitante;
    }

    public int ganadorLocal(){
        /*for(int i = minutos; i >= 0; i--){
            System.out.println("Minuto: " + (minutos - i));
            
        }*/
        //System.out.println(local.getGolesPorPartido() + " - " + visitante.getGolesPorPartido());
        if(local.getGolesPorPartido() > visitante.getGolesPorPartido()){
            return 1;
        }
        else{
            if(local.getGolesPorPartido() == visitante.getGolesPorPartido()){
                //empate
                return 0;
            }else{
                //derrota local
                return -1;
            }
        }
    }

}
