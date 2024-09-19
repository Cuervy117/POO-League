package jornada.partidos;
import java.util.Random;

public class Probabilidades {
    private double cotaInferior;
    private double cotaSuperior;

    public Probabilidades(int partidosGanados, int partidosPerdidos, int empates){
        cotaInferior =2 * Math.log(partidosPerdidos + 1)*Math.exp(-partidosPerdidos);
        cotaSuperior = Math.log(partidosGanados + 1) + 1;
    }

    public void imprimirCotas(){
        System.out.println(cotaInferior);
        System.out.println(cotaSuperior);
    }

}
