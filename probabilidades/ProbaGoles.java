package probabilidades;
import java.util.Random;
import java.lang.Math;
/**
 * Clase que se encarga de calcular la probabilidad de que un equipo meta goles 
 */
public class ProbaGoles {
    // Atributos 
    private double golesMin;
    private double golesMax;

    /**
     * Constructor para la clase ProbaGoles
     * @param partidosGanados 
     * @param partidosPerdidos
     */
    public ProbaGoles(int partidosGanados, int partidosPerdidos){
        golesMax = Math.log((partidosGanados/(partidosPerdidos + 1)) + 1) + 1;
        golesMin = Math.log(Math.pow(golesMax , 4) + 1) / 4;
    }

    public void updateProba(int partidosGanados, int partidosPerdidos){
        golesMax = Math.log((partidosGanados/(partidosPerdidos + 1)) + 1) + 1;
        golesMin = Math.log(Math.pow(golesMax , 4) + 1) / 4;
    }
    
    public long goles(){
        Random rnd = new Random();
        return Math.round(rnd.nextDouble(golesMax - golesMin) + golesMin);
    }

}
