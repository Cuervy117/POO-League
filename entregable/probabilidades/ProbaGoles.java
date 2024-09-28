package probabilidades;
import java.util.Random;

/**
 * Clase que se encarga de calcular la probabilidad de que un equipo meta goles.
 */
public class ProbaGoles {
    // Atributos 
    private double golesMin;
    private double golesMax;

    /**
     * Constructor para la clase ProbaGoles.
     * @param partidosGanados Número de partidos ganados.
     * @param partidosPerdidos Número de partidos perdidos.
     */
    public ProbaGoles(int partidosGanados, int partidosPerdidos){
        golesMax = Math.log((partidosGanados / (partidosPerdidos + 1)) + 1) + 1;
        golesMin = Math.log(Math.pow(golesMax, 4) + 1) / 4;
    }

    //region Métodos de clase

    /**
     * Actualiza la probabilidad de goles basada en partidos ganados y perdidos.
     * @param partidosGanados Número de partidos ganados.
     * @param partidosPerdidos Número de partidos perdidos.
     */
    public void updateProba(int partidosGanados, int partidosPerdidos){
        golesMax = Math.log((partidosGanados / (partidosPerdidos + 1)) + 1) + 1;
        golesMin = Math.log(Math.pow(golesMax, 4) + 1) / 4;
    }

    /**
     * Calcula el número de goles basado en la probabilidad.
     * @return Número de goles.
     */
    public long goles(){
        Random rnd = new Random();
        return Math.round(rnd.nextDouble(golesMax - golesMin) + golesMin);
    }

    //endregion
}
