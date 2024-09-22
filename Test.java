import liga.Liga;
import equipos.Equipo;
import java.util.ArrayList;
class Test{
    public static void main(String[] args) {
        ArrayList<String> progra = new ArrayList<>();
        Liga a = new Liga();
        for(int i = 0; i < 18; i++){
            a.registrarEquipo(new Equipo(null, ("Equipo " + (i + 1)), null));
            progra.add(("Equipo " + (i + 1)));
        }
        System.out.println(progra.toString());
        a.infoEquipos();
        for(int j = 0; j < 17; j++){
            a.simularJornada(progra);
            Liga.actualizarProgramacion(progra);
            System.out.println(progra.toString());
        }
        a.consultarJornadas();
        a.infoEquipos();

    }
}