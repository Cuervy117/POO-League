import java.io.IOException;
import java.util.Scanner;

public class Menu{
        public static void menuPreCampeonato(Scanner sc, Liga liga)throws IOException, InterruptedException{

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
                    liga.registrarEquipo(equipoCreado);

                    System.out.println("¿Quieres seguir registrando equipos? [Si/No]");
                    respuesta = sc.nextLine();
                    
                    if(!respuesta.toLowerCase().equals("si") && !respuesta.toLowerCase().equals("no")) System.out.println("Ingresa una respuesta válida");

                } while (!respuesta.toLowerCase().equals("no"));
                Archivo.guardarEquipos(liga);

                System.out.println("Los equipos registrados fueron: ");
                liga.mostrarEquipos();
                

            }

            case 2->  {
                //editar equipos
            }

            case 3-> {
                System.out.println("Has elegido la opcion 3");
                Archivo.guardarEquiposExistentes(liga);
                liga.generarCalendario();
            }

            case 4 -> {
                System.out.println("Para iniciar el campeonato pulsa enter!");
                //mostrar tabla inicial

            }
        }

    }

    public static void menuPostCampeonato(Scanner sc, Liga liga)throws IOException, InterruptedException{
        System.out.println("2) Jornadas Anteriores");
        System.out.println("3) Mostrar jornadas de un equipo");
        System.out.println("4) Simular Temporada");
        int opcion = sc.nextInt();
        sc.nextLine(); //para consumir el \n

        switch(opcion){
            case 2 -> {
                //está pensado para mostrar únicamente los partidos de una jornada específica
                System.out.println("Jornadas de la liga: ");
                System.out.println(liga.jornadas.values());

                System.out.println("Ingresa la jornada que quieras consultar: ");
                int numeroJornada = sc.nextInt();
                sc.nextLine(); //consume el salto de linea

                liga.mostrarJornadas(numeroJornada);

                //ahora está pensado para mostrar el rango desde la primera jornada hasta la jornada deseada
                System.out.println("Ingresa la jornada hasta la que quieras consultar. El rango comienza desde la primera.");
                int limiteJornada = sc.nextInt();
                sc.nextLine(); //consume salto de linea
                liga.mostrarRangoJornadas(limiteJornada);
            }
            case 3->{

                System.out.println("Ingresa el nombre del equipo que quieras ver sus jornadas");
                String nombreEquipo = sc.nextLine();
                liga.mostrarJornadasPorEquipo(nombreEquipo);
            }
            case 4 -> {
                System.out.println("Simular temporada");
                liga.simularTemporada();
                System.out.println("Consulte la tabla General");
                Archivo.escribirTablaGeneral(liga);
            }
        }
        
    }
}