package e2;

import java.util.ArrayList;

public class Proyecto {
    private final String name;
    private ArrayList<Componente> componentes= new ArrayList<>();

    public Proyecto(String name) {
        this.name = name;
    }
    public void addComponente (Componente c){
        componentes.add(c);
        c.anadir(c,this);
    }

    public String getName(){
        return name;
    }

    public String StringProyecto() {
        StringBuilder info = new StringBuilder();
        info.append("Proyecto: ").append(name).append("\n");
        for (Componente c1 : componentes) {
            info.append("\t").append(c1.printInfo(this));
        }
        return info.toString();
    }

    public static void main (String [] args){
        Proyecto Monguer = new Proyecto("Tremendo espectaculo");
        Proyecto FTerrible = new Proyecto("Pecheo duro");
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
        FTerrible.addComponente(Jandromamon);

        Manolo.updatehours(30, FTerrible);

        System.out.println(Monguer.StringProyecto());

        System.out.println(Jandromamon.printInfo(Monguer));
        System.out.println(Jandromonheco.printInfo(Monguer));

        System.out.println(FTerrible.StringProyecto());

        System.out.println(Manolo.printInfo(Monguer));

    }
}
