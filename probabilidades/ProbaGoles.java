package probabilidades;
import java.util.Random;
import java.lang.Math;
/**
 * Clase que se encarga de calcular la probabilidad de que un equipo meta goles 
 */
public class ProbaGoles {
    // Atributos 
    private float golesMin;
    private float golesMax;

    /**
     * Constructor para la clase ProbaGoles
     * @param puntos 
     * @param totalPartidos
     */
    public ProbaGoles(int puntos, int totalPartidos){
        int partidosAFavor = (puntos) / 3;
        golesMax = (float)(Math.log((partidosAFavor / (totalPartidos - partidosAFavor + 1))) + 1);
        golesMin = (float)(Math.log(Math.pow(golesMax , 4) + 1) / 4);
    }
    
    public void updateGoles(int puntos, int totalPartidos){
        golesMax = (float)(Math.log((puntos/(totalPartidos + 1.0)) + 1) + 1);
        golesMin = (float)(Math.log(Math.pow(golesMax , 4) + 1) / 4);
    }
    public long goles(){
        Random rnd = new Random();
        return Math.round(rnd.nextFloat() * (golesMax - golesMin) + golesMin);
    }

}
