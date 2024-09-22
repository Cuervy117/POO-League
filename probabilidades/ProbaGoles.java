package probabilidades;
import java.util.Random;
import java.lang.Math;
/**
 * Clase que se encarga de calcular la probabilidad de que un equipo meta goles 
 */
public class ProbaGoles{
    // Atributos 
    private float golesMax; // Cota superior
    private float golesMin; // Cota inferior 

    /**
     * Constructor para la clase ProbaGoles
     * @param puntos Los puntos del equipo hasta el momento
     * @param totalPartidos Los partidos jugados por el equipo hasta el momneto  
     */
    public ProbaGoles(int puntos, int totalPartidos){
        int partidosAFavor = puntos/3;
        golesMax = partidosAFavor == 0? 1f :(float)(Math.log((partidosAFavor / (totalPartidos - partidosAFavor + 1))) + 1);
        golesMin = (float)(Math.log(Math.pow(golesMax , 4) + 1) / 4);
    }

    /**
     * Metodo para actuazliar las cotas 
     * @param puntos Los puntos del equipo hasta el momento
     * @param totalPartidos Los partidos jugados por el equipo hasta el moment
     */
    public void updateGoles(int puntos, int totalPartidos){
        golesMax = (float)(Math.log((puntos/(totalPartidos + 1.0)) + 1) + 1);
        golesMin = (float)(Math.log(Math.pow(golesMax , 4) + 1) / 4);
    }

    /**
     * Metodo que calcula los goles dependiendo de las cotas
     * @return Devuelve un número de goles
     */
    public int getGoles(){
        Random rnd = new Random();
        return Math.round(rnd.nextFloat() * (golesMax - golesMin) + golesMin);
    }

}
