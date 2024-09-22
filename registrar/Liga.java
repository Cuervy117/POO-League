import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class Liga {
    String nombre;
    TreeMap<Equipo, Integer> puntosPorEquipo; //la llave son los equipos ya que son únicos y cada llave contiene un valor que son los puntos
    LinkedHashMap<Partido, Integer> jornadas;

    public Liga(String nombre){
        this.nombre = nombre;
        this.puntosPorEquipo = new TreeMap<>((Equipo e1, Equipo e2) -> e1.getNombre().compareTo(e2.getNombre()) //el tree map va a estar ordenado inicialmente por orden alfabético
        );
        this.jornadas = new LinkedHashMap<>();
    }

    public  void registrarEquipo(Equipo e){
        this.puntosPorEquipo.put(e, 0);
    }

    public void mostrarEquipos(){
        Set <Equipo> set = puntosPorEquipo.keySet(); //creo un set únicamente de equipos para poderlos ordenar alfabeticamente
        /*for(Entry <Equipo, Integer> entrada : puntosPorEquipo.entrySet()){
            System.out.println(entrada.getKey().getNombre());
        }*/
        for(Equipo equipo: set){
            System.out.println(equipo.getNombre());
        }

    }

    public void mostrarJornadas(){
        for(Entry <Partido, Integer> entrada : jornadas.entrySet()){
            System.out.println( entrada.getKey().mostrarPartido() + "\t" + entrada.getValue());
        }
    }

    /*public void generarCalendario(){
        if(!puntosPorEquipo.isEmpty()){
            System.out.println("Generando Calendario...");
            //definir numero de equipos participantes, n será la variable
            int n = puntosPorEquipo.size(); // antes estaba Archivo.contarEquipos()
            if(n % 2 == 0){ //procede en caso de que el número de archivos sea par
                int l = 0; //variable contadora para almacenar cada equipo local
                int v = 0; //variable contadora para almacenar cada equipo visitante
                System.out.println("n vale " + n);
                Partido[][] calendario = new Partido[n-1][n/2]; //[filas][columnas]
                for(int i = 0; i < n-1  ; i ++ ){ //i es para filas
                    for(int j = 0; j < n/2; j ++){ //j es paara columnas
                        //calendario[i][j] = new Partido();
                        if(l == puntosPorEquipo.size()-1 ){
                            l = 0; //se evalúa que k no sobrepase el número de equipos que hay, de esa forma vamos llenando de forma ordenada y ascendente
                        }
                        if (v == puntosPorEquipo.size()-2){
                            v = 0;
                        }

                        Equipo local = (Equipo) puntosPorEquipo.keySet().toArray()[l]; //se obtiene el equipo 'l' del mapa que contiene a los equipos ordenados
                        //Equipo visitante = (Equipo) puntosPorEquipo.reversed().keySet().toArray()[v+1]; //esto es para los visitantes y se necesita invertir el orden
                        Equipo visitante = (Equipo) puntosPorEquipo.keySet().toArray()[(n-2)-v];
                        Equipo c = (Equipo) puntosPorEquipo.keySet().toArray()[puntosPorEquipo.size()-1]; //este es el último equipo en aparecer
                        if (i % 2 == 1 && j == 0){ //evalua si el ciclo está en fila impar y que también se encuentre en la primer columna
                            calendario[i][j] = new Partido(c, local); //se asigna el ultimo equipo como local
                            //calendario[i][j].setVisitante(local); //se asigna como visitante el equipo obtenido hasta este momento
                        }
                        else{
                            if(i % 2 == 0 && j == 0){
                                //calendario[i][j].setLocal(local);
                                calendario[i][j] = new Partido(local, c);
                                //calendario[i][j].setVisitante(c);
                            }else{
                                //calendario[i][j].setLocal(local);
                                calendario[i][j] = new Partido(local, visitante);
                                //calendario[i][j].setVisitante(visitante);
                                v++; //solamente en los casos donde no nos encontremos en la primer columna
                            }

                        }
                        
                        l++; //l sigue recorriendo a los equipos 
                    }                        
                    
                }

                for(int a = 0; a < n - 1 ; a ++ ){
                    for(int b = 0;  b < n/2; b ++){
                        calendario[a][b].mostrarPartido();

                    }
                } //i es para filas
            }else{
                System.out.println("El numero de equipos no es par");
            }

            

        }
        else{
            System.out.println("No has ingresado ningún equipo");
        } 

        
    }*/

public void generarCalendario() {
    if (!puntosPorEquipo.isEmpty()) {
        System.out.println("Generando Calendario...");
        // Definir número de equipos participantes, n será la variable
        int n = puntosPorEquipo.size(); // antes estaba Archivo.contarEquipos()
        if (n % 2 == 0) { // Procede en caso de que el número de equipos sea par
            int l = 0; // Variable contadora para almacenar cada equipo local
            int v = 0; // Variable contadora para almacenar cada equipo visitante
            System.out.println("n vale " + n);
            Partido[][] calendario = new Partido[n - 1][n / 2]; // [filas][columnas]

            for (int i = 0; i < n - 1; i++) { // i es para filas
                for (int j = 0; j < n / 2; j++) { // j es para columnas
                    if (l == puntosPorEquipo.size() - 1) {
                        l = 0; // Se evalúa que l no sobrepase el número de equipos que hay
                    }
                    if (v == puntosPorEquipo.size() - 2) {
                        v = 0;
                    }

                    Equipo local = (Equipo) puntosPorEquipo.keySet().toArray()[l]; // Se obtiene el equipo 'l' del mapa que contiene a los equipos ordenados
                    Equipo visitante = (Equipo) puntosPorEquipo.keySet().toArray()[(n - 2) - v]; // Se obtiene el equipo visitante
                    Equipo c = (Equipo) puntosPorEquipo.keySet().toArray()[puntosPorEquipo.size() - 1]; // Este es el último equipo en aparecer

                    if (i % 2 == 1 && j == 0) { // Evalúa si el ciclo está en fila impar y que también se encuentre en la primera columna
                        calendario[i][j] = new Partido(c, local); // Se asigna el último equipo como local
                    } else {
                        if (i % 2 == 0 && j == 0) {
                            calendario[i][j] = new Partido(local, c); // Se asigna el equipo local y el último equipo como visitante
                        } else {
                            calendario[i][j] = new Partido(local, visitante); // Se asigna el equipo local y el equipo visitante
                            v++; // Solamente en los casos donde no nos encontremos en la primera columna
                        }
                    }

                    l++; // l sigue recorriendo a los equipos
                }
            }

            // Mostrar los partidos generados
            for (int a = 0; a < n - 1; a++) {
                for (int b = 0; b < n / 2; b++) {
                    //prueba para almacenar en jornadas
                    jornadas.put(calendario[a][b], a + 1); //a representa el valor de la jornada disputada
                    //calendario[a][b].mostrarPartido();
                
                }
            }
            mostrarJornadas();
        } else {
            System.out.println("El numero de equipos no es par");
        }
    } else {
        System.out.println("No has ingresado ningún equipo");
    }
    
}

    
    




}
