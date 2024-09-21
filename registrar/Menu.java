import java.io.IOException;
import java.util.Scanner;

public class Menu{
        public static void menu(Scanner sc)throws IOException, InterruptedException{
        System.out.println("1) Registrar equipos");
        System.out.println("2) ");
        int opcion = sc.nextInt();
        switch (opcion) {
            case 1 ->{
                String nombre, respuesta; 
                Liga ligaMX = new Liga("Liga MX"); //aqui hay que hacerlo diferente

                do {
                    System.out.println("Ingresa el nombre de tu equipo: ");
                    nombre = sc.nextLine();   
                    
                    Equipo equipoCreado = new Equipo(nombre); //se crea el equipo en cada iteración del do-while con el constructor que requiere el nombre
                    ligaMX.registrarEquipo(equipoCreado);

                    System.out.println("¿Quieres seguir registrando equipos? [Si/No]");
                    respuesta = sc.next();

                    if(!respuesta.toLowerCase().equals("si") || !respuesta.toLowerCase().equals("no"))
                        System.out.println("Ingresa una respuesta válida");
                    
                } while (respuesta.toLowerCase().equals("si"));

                System.out.println("Los equipos registrados fueron: ");
                ligaMX.mostrarEquipos();
                

            }
        }

    }
}