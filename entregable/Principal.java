import competiciones.*;
import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args)throws IOException, InterruptedException {
        Scanner sc =new Scanner(System.in);
        Liga liga = new Liga("Liga MX"); //aqui hay que hacerlo diferente, quiero que se puedan crear varias ligas
        Archivo.guardarEquiposExistentes(liga);
        int opcion = 0;
        do { 
            opcion = Menu.menuPreCampeonato(sc, liga);
        } while (opcion != 4);
        
    }
}
