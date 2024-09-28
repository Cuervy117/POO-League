package competiciones;
import equipos.*;

/**
 * Clase que representa un partido de fútbol entre dos equipos.
 */
public class Partido {
    int minutos = 90;
    private Equipo local;
    private Equipo visitante;

    /**
     * Constructor para crear un partido con equipos local y visitante.
     * @param local Equipo local.
     * @param visitante Equipo visitante.
     */
    public Partido(Equipo local, Equipo visitante){
        this.local = local;
        this.visitante = visitante;
    }

    /**
     * Constructor por defecto.
     */
    public Partido(){

    }

    /**
     * Constructor para crear un partido con solo el equipo local.
     * @param local Equipo local.
     */
    public Partido(Equipo local){
        this.local = local;
    }

    //region Setters

    /**
     * Establece el equipo local.
     * @param local Equipo local.
     */
    public void setLocal(Equipo local){
        this.local = local;
    }

    /**
     * Establece el equipo visitante.
     * @param visitante Equipo visitante.
     */
    public void setVisitante(Equipo visitante){
        this.visitante = visitante;
    }

    //endregion

    //region Getters

    /**
     * Obtiene el equipo local.
     * @return Equipo local.
     */
    public Equipo getLocal(){
        return local;
    }

    /**
     * Obtiene el equipo visitante.
     * @return Equipo visitante.
     */
    public Equipo getVisitante(){
        return visitante;
    }

    //endregion

    //region Métodos de clase

    /**
     * Muestra el partido en formato "local - visitante".
     * @return String con el formato "local - visitante".
     */
    public String mostrarPartido(){
        return this.local.getNombre() + " - " + this.visitante.getNombre();
    }

    /**
     * Determina el resultado del partido.
     * @return 1 si gana el equipo local, 0 si empatan, -1 si gana el equipo visitante.
     */
    public int ganadorLocal(){
        Long golesLocal = local.getGolesPorPartido(), golesVisitante = visitante.getGolesPorPartido();
        local.setGolesAFavor(local.getGolesAFavor() + golesLocal);
        local.setGolesEnContra(local.getGolesEnContra() + golesVisitante);

        visitante.setGolesAFavor(visitante.getGolesAFavor() + golesVisitante);
        visitante.setGolesEnContra(visitante.getGolesEnContra() + golesLocal);
        
        if(golesLocal > golesVisitante){
            return 1;
        } else if(golesLocal.equals(golesVisitante)){
            return 0; // empate
        } else {
            return -1; // derrota local
        }
    }

    /**
     * Determina el equipo ganador en una eliminatoria.
     * @return Equipo ganador.
     */
    public Equipo eliminatoria() {
        Long golesLocal = local.getGolesPorPartido();
        Long golesVisitante = visitante.getGolesPorPartido();
    
        long golesAFavorLocal = local.getGolesAFavor() + golesLocal;
        long golesEnContraLocal = local.getGolesEnContra() + golesVisitante;
    
        long golesAFavorVisitante = visitante.getGolesAFavor() + golesVisitante;
        long golesEnContraVisitante = visitante.getGolesEnContra() + golesLocal;
    
        local.setGolesAFavor(golesAFavorLocal);
        local.setGolesEnContra(golesEnContraLocal);
    
        visitante.setGolesAFavor(golesAFavorVisitante);
        visitante.setGolesEnContra(golesEnContraVisitante);
    
        if (golesLocal > golesVisitante) {
            System.out.println("Final");
            System.out.println(local.getNombre() + " " + golesLocal + " - "+ golesVisitante + " " + visitante.getNombre());
            return local;
        } else if (golesLocal < golesVisitante) {
            System.out.println("Final");
            System.out.println(local.getNombre() + " " +golesLocal + " - "+ golesVisitante + " " + visitante.getNombre());
            return visitante;
        } else {
            System.out.println("Tiempos extra");
            local.setGolesAFavor(golesAFavorLocal - golesLocal);
            local.setGolesEnContra(golesEnContraLocal - golesVisitante);
    
            visitante.setGolesAFavor(golesAFavorVisitante - golesVisitante);
            visitante.setGolesEnContra(golesEnContraVisitante - golesLocal);
    
            return eliminatoria();
        }
    }

    //endregion
}

