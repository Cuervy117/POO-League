import probabilidades.*;
import registrar.*;
import liga.*;
import jornada.*;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import equipos.*;

public class Test{
    public static void main(String[] args) {
        Liga l = new Liga("Mx");
        l.registrarEquipo(new Equipo(null, "Equipo", null));
        Archivo.guardarEquipos(l);
        System.out.println(Archivo.contarEquipos());
        Liga mx = new Liga("ms");
        Archivo.guardarEquiposExistentes(mx);
        System.out.println(1);
        LinkedHashMap<String, Equipo> a = mx.getEquipos();
        Set<Entry<String, Equipo>> e = a.entrySet();
        for(Entry<String, Equipo> f : e){
            System.out.println(f.getKey());
        }
    }
}