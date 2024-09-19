package jornada.partidos;
import java.util.Random;

public class Probabilidades {
    private double cotaInferior;
    private double cotaSuperior;

    public Probabilidades(int partidosGanados, int partidosPerdidos, int empates){
        cotaSuperior = Math.log((partidosGanados/(partidosPerdidos + 1)) + 1) + 1;
        cotaInferior = Math.log(Math.pow(cotaSuperior , 4) + 1) / 4;
    }

    public void imprimirCotas(){
        System.out.println(cotaInferior);
        System.out.println(cotaSuperior);
    }

}
