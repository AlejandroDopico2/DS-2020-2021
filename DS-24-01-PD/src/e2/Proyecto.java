package e2;

import java.util.ArrayList;

public class Proyecto {
    private final String name;
    private final ArrayList<Componente> componentes= new ArrayList<>();

    public Proyecto(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public ArrayList<Componente> getComponentes(){
        return componentes;
    }

    public void addTeam (Componente c){
        componentes.add(c);
        c.inicializarHash(this);
    }

    public String StringProyecto() {
        StringBuilder info = new StringBuilder();
        info.append("Proyecto: ").append(name).append("\n");
        for (Componente c1 : componentes) {
            info.append("\t").append(c1.printInfo(this));
        }
        return info.toString();
    }

    public String mates(Componente c){
        StringBuilder mates= new StringBuilder();
        if(c.pertenece(this)) {
            if(c instanceof Equipo) {
                mates.append("Los cotrabajadores del Team ").append(c.getName()).append(" en el proyecto ").append(this.getName()).append(" son: ");
            }else
                mates.append("Los cotrabajadores de ").append(c.getName()).append(" en el proyecto ").append(this.getName()).append(" son: ");
            for (Componente c1 : this.getComponentes()) {
                if (!this.getName().equals(c1.getName())) {
                    if (c1 instanceof Trabajador) {
                        mates.append(c1.getName()).append(", ");
                    } else {
                        mates.append(((Equipo) c1).TeamMates(c));
                    }
                }
            }
            mates.delete(mates.length() - 2, mates.length());
            mates.append(".");
        }else{
            System.out.println(this.getName() + " no pertenece al proyecto "+ this.getName());
        }
        return mates.toString();
    }


    public static void main (String [] args){
        Proyecto Monguer = new Proyecto("Tremendo espectaculo");
        Proyecto FTerrible = new Proyecto("Pecheo duro");
        Trabajador Manolo = new Trabajador("Manolo", 20);
        Trabajador Jandro = new Trabajador("Jandro", 15);
        Trabajador Abel = new Trabajador("Abel", 15);
        Manolo.updateHours(30f,Monguer);
        Jandro.updateHours(20f,Monguer);
        Abel.updateHours(10f,Monguer);
        Trabajador Juse = new Trabajador("Juse", 10);

        System.out.println(Manolo.getHours(Monguer));


        Equipo Jandromamon = new Equipo("Albañil");
        Equipo Jandromonheco = new Equipo("Comunismo");
        Equipo TodoMal = new Equipo("F");

        Jandromamon.addComponente(Manolo);
        Jandromamon.addComponente(Jandro);
        Jandromonheco.addComponente(Abel);
        TodoMal.addComponente(Juse);

        Jandromamon.addComponente(Jandromonheco);
        Jandromonheco.addComponente(TodoMal);
        Monguer.addTeam(Jandromamon);
        FTerrible.addTeam(Jandromamon);

        Jandromamon.addComponente(Juse);

        Manolo.updateHours(30f, FTerrible);

        System.out.println(Monguer.StringProyecto());

        System.out.println(FTerrible.StringProyecto());

        //System.out.println(Juse.mates(Monguer));

        //System.out.println(TodoMal.mates(Monguer));

        System.out.println(Monguer.mates(TodoMal));
    }
}
