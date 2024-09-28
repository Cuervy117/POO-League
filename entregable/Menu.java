import competiciones.*;
import Equipos.*;
import java.io.IOException;
import java.util.Scanner;

/**
 * Clase que representa el menú de opciones para gestionar el campeonato.
 */
public class Menu {

    /**
     * Muestra el menú previo al campeonato y maneja las opciones seleccionadas por el usuario.
     * @param sc Scanner para la entrada de datos del usuario.
     * @param liga Liga en la que se registrarán los equipos y se generará el calendario.
     * @return La opción seleccionada por el usuario.
     * @throws IOException Si ocurre un error de entrada/salida.
     * @throws InterruptedException Si el hilo es interrumpido.
     */
    public static int menuPreCampeonato(Scanner sc, Liga liga) throws IOException, InterruptedException {

        System.out.println("1) Registrar equipos");
        System.out.println("2) Editar equipos");
        System.out.println("3) Generar Calendario");
        System.out.println("4) Salir");
        int opcion = sc.nextInt();
        sc.nextLine(); // para consumir el \n
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // limpia pantalla

        switch (opcion) {
            case 1 -> {
                String nombre, respuesta;
                do {
                    System.out.println("Ingresa el nombre de tu equipo: ");
                    nombre = sc.nextLine();

                    Equipo equipoCreado = new Equipo(nombre); // se crea el equipo en cada iteración del do-while con el constructor que requiere el nombre
                    liga.registrarEquipo(equipoCreado);

                    System.out.println("¿Quieres seguir registrando equipos? [Si/No]");
                    respuesta = sc.nextLine();

                    if (!respuesta.toLowerCase().equals("si") && !respuesta.toLowerCase().equals("no")) {
                        System.out.println("Ingresa una respuesta válida");
                    }

                } while (!respuesta.toLowerCase().equals("no"));
                Archivo.guardarEquipos(liga);

                System.out.println("Los equipos registrados fueron: ");
                liga.mostrarEquipos();
                System.out.println("Pulsa Enter para continuar ...");
                sc.nextLine();
            }

            case 2 -> {
                // editar equipos
                liga.mostrarEquipos();
                System.out.println("Que equipo quieres modificar");
                String equipo = sc.nextLine();

                System.out.println("Ingresa su nuevo nombre");
                equipo = sc.nextLine();
                Equipo e = new Equipo(equipo);
                liga.registrarEquipo(e);

                System.out.println("Pulsa Enter para continuar ...");
                sc.nextLine();
            }

            case 3 -> {
                System.out.println("Has elegido la opcion 3");
                Archivo.guardarEquiposExistentes(liga);
                liga.generarCalendario();

                System.out.println("Pulsa Enter para continuar ...");
                sc.nextLine();

                System.out.println("Para iniciar el campeonato pulsa enter!");
                sc.nextLine();
                do {
                    menuPostCampeonato(sc, liga);
                } while (menuPostCampeonato(sc, liga) != 5);
            }

            case 4 -> {
                System.out.println("Hasta luego! Saliendo...");
            }
        }
        return opcion;
    }


    /**
     * Muestra el menú posterior al campeonato y maneja las opciones seleccionadas por el usuario.
     * @param sc Scanner para la entrada de datos del usuario.
     * @param liga Liga en la que se registrarán los equipos y se generará el calendario.
     * @return La opción seleccionada por el usuario.
     * @throws IOException Si ocurre un error de entrada/salida.
     * @throws InterruptedException Si el hilo es interrumpido.
     */
    public static int menuPostCampeonato(Scanner sc, Liga liga) throws IOException, InterruptedException {
        System.out.println("1) Mostrar tabla");
        System.out.println("2) Jornadas Anteriores");
        System.out.println("3) Mostrar jornadas de un equipo");
        System.out.println("4) Simular Temporada");
        System.out.println("5) Salir");
        int opcion = sc.nextInt();
        sc.nextLine(); // para consumir el \n
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // limpia pantalla

        switch (opcion) {
            case 1 -> {
                System.out.println("Si la tabla aparece con ceros, asegúrate de simular la temporada primero");
                System.out.println("Consulte la tabla General");
                Archivo.escribirTablaGeneral(liga);
                System.out.println("Pulsa Enter para continuar ...");
                sc.nextLine();
            }
            case 2 -> {
                // está pensado para mostrar únicamente los partidos de una jornada específica
                System.out.println("Jornadas de la liga: ");
                System.out.println(liga.getJornadas().values());

                System.out.println("Ingresa la jornada que quieras consultar: ");
                int numeroJornada = sc.nextInt();
                sc.nextLine(); // consume el salto de linea

                liga.mostrarJornadas(numeroJornada);

                // ahora está pensado para mostrar el rango desde la primera jornada hasta la jornada deseada
                System.out.println("Ingresa la jornada hasta la que quieras consultar. El rango comienza desde la primera.");
                int limiteJornada = sc.nextInt();
                sc.nextLine(); // consume salto de linea
                liga.mostrarRangoJornadas(limiteJornada);
                System.out.println("Pulsa Enter para continuar ...");
                sc.nextLine();
            }
            case 3 -> {
                System.out.println("Ingresa el nombre del equipo que quieras ver sus jornadas");
                String nombreEquipo = sc.nextLine();
                liga.mostrarJornadasPorEquipo(nombreEquipo);
                System.out.println("Pulsa Enter para continuar ...");
                sc.nextLine();
            }
            case 4 -> {
                System.out.println("Simular temporada");
                liga.simularTemporada();
                Archivo.escribirTablaGeneral(liga);
                System.out.println("Temporada simulada. Consulte la tabla generada");
                System.out.println("Pulsa Enter para continuar e iniciar Playoffs ...");
                sc.nextLine();
                System.out.println("Iniciar PlayOffs");
                Playoff liguilla = new Playoff(liga);
                liguilla.almacenarParticipantes(liga, 8);
                liguilla.simularPlayoffs();
                System.out.println("Pulsa Enter para continuar ...");
                sc.nextLine();
            }
            case 5 -> {
                System.out.println("Hasta luego!");
            }
            default -> {
                System.out.println("Ingresa una opcion válida");
            }
        }
        return opcion;
    }
}
