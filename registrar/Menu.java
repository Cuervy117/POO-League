import java.io.IOException;
import java.util.Scanner;

public class Menu{
        public static void menuPreCampeonato(Scanner sc)throws IOException, InterruptedException{

        Liga ligaMX = new Liga("Liga MX"); //aqui hay que hacerlo diferente, quiero que se puedan crear varias ligas


        System.out.println("1) Registrar equipos");
        System.out.println("2) Editar equipos");
        System.out.println("3) Generar Calendario");
        System.out.println("4) Iniciar Campeonato");
        int opcion = sc.nextInt();
        sc.nextLine(); //para consumir el \n
        //new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();//limpia pantalla

        switch (opcion) {
            case 1 ->{
                String nombre, respuesta; 
                do {
                    System.out.println("Ingresa el nombre de tu equipo: ");
                    nombre = sc.nextLine();   
                    
                    Equipo equipoCreado = new Equipo(nombre); //se crea el equipo en cada iteración del do-while con el constructor que requiere el nombre
                    ligaMX.registrarEquipo(equipoCreado);

                    System.out.println("¿Quieres seguir registrando equipos? [Si/No]");
                    respuesta = sc.nextLine();
                    
                    if(!respuesta.toLowerCase().equals("si") && !respuesta.toLowerCase().equals("no")) System.out.println("Ingresa una respuesta válida");

                } while (!respuesta.toLowerCase().equals("no"));
                Archivo.guardarEquipos(ligaMX);

                System.out.println("Los equipos registrados fueron: ");
                ligaMX.mostrarEquipos();
                

            }

            case 2->  {
                //editar equipos
            }

            case 3-> {
                System.out.println("Has elegido la opcion 3");
                Archivo.guardarEquiposExistentes(ligaMX);
                ligaMX.generarCalendario();
            }
        }

    }
}