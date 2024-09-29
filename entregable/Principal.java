import competiciones.*;
import java.io.IOException;
import java.util.Scanner;

public class Principal {
    
    /** 
     * @param args
     * @throws IOException
     * @throws InterruptedException
     */
    public static void main(String[] args)throws IOException, InterruptedException {
        Scanner sc =new Scanner(System.in);
        Liga liga = new Liga("Liga MX");
        Archivo.guardarEquiposExistentes(liga);
        int opcion = 0;
        do { 
            opcion = Menu.menuPreCampeonato(sc, liga);
        } while (opcion != 4);
        
    }
}
