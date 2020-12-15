package e2;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;

public class Proyecto implements Componente {
    private final String name;
    private ArrayList<Componente> componentes= new ArrayList<>();

    public Proyecto(String name) {
        this.name = name;
    }
    public void addComponente (Componente c){
        componentes.add(c);
    }
    public String getName(){
        return name;
    }

    @Override
    public String printInfo(Proyecto proyecto) {
        StringBuilder info = new StringBuilder();
        info.append("Proyecto: ").append(name).append("\n");
        Iterator<Componente> si = componentes.iterator();
        while(si.hasNext()){
            Componente c1=si.next();
            info.append("\t").append(c1.printInfo(proyecto));
        }
        return info.toString();
    }

    @Override
    public int getMoney(Proyecto proyecto) {
        return 0;
    }

    @Override
    public int getHours(Proyecto proyecto) {
        return 0;
    }

    public static void main (String [] args){
        Proyecto Monguer = new Proyecto("Tremendo espectaculo");
        Trabajador Manolo = new Trabajador("Manolo", 20);
        Trabajador Jandro = new Trabajador("Jandro", 15);
        Trabajador Abel = new Trabajador("Abel", 15);
        Manolo.updatehours(30,Monguer);
        Jandro.updatehours(20,Monguer);
        Abel.updatehours(10,Monguer);

        //System.out.println(Manolo.getHours(Monguer));


        Equipo Jandromamon = new Equipo("Albañil");
        Equipo Jandromonheco = new Equipo("Comunismo");

        Jandromamon.addComponente(Manolo);
        Jandromamon.addComponente(Jandro);
        Jandromonheco.addComponente(Abel);

        Jandromamon.addComponente(Jandromonheco);

        Monguer.addComponente(Jandromamon);

        System.out.println(Monguer.printInfo(Monguer));

        System.out.println(Jandromamon.printInfo(Monguer));
        System.out.println(Jandromonheco.printInfo(Monguer));

    }
}
