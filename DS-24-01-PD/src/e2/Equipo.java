package e2;

import java.util.ArrayList;

public class Equipo implements Componente {
    private final String name;
    private final ArrayList<Componente> componentes = new ArrayList<>();

    public Equipo(String name) {
        this.name = name;
    }

    public void addComponente(Componente c) {
        componentes.add(c);
    }

    @Override
    public String printInfo(Proyecto proyecto, int recursivo) {
        StringBuilder info = new StringBuilder();

        info.append("Team ").append(name).append(": ").append(getHours(proyecto)).append(" hours, ").append(getMoney(proyecto)).append(" €\n");
        recursivo++;
        for (Componente c1 : componentes) {
            info.append("\t".repeat(Math.max(0, recursivo)));
            info.append(c1.printInfo(proyecto, recursivo));
        }
        return info.toString();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public float getMoney(Proyecto proyecto) {
        float money = 0;
        for (Componente c1 : componentes) {
            money += c1.getMoney(proyecto);
        }
        return money;
    }

    @Override
    public float getHours(Proyecto proyecto) {
        float hours = 0;
        for (Componente c1 : componentes) {
            hours += c1.getHours(proyecto);
        }
        return hours;
    }

    @Override
    public void inicializarHash(Proyecto p) {
        for (Componente c1 : componentes) {
            c1.inicializarHash(p);
        }
    }

    public String TeamMates(Componente c){ //función auxiliar recursiva que recurre en cada equipo
        StringBuilder mates = new StringBuilder();
        for(Componente c1 : componentes){
            if(!c.getName().equals(c1.getName())){
                if (c1 instanceof Trabajador) {
                    mates.append(c1.getName()).append(", ");
                } else {
                    mates.append(((Equipo) c1).TeamMates(c));
                }
            }
        }
        return mates.toString();
    }

    public boolean contiene(Componente c){
        boolean exists=false;
        if(this.equals(c)){
            return true;
        }else {
            for (Componente c1 : componentes) {
                if(c1 instanceof Equipo)
                    exists = ((Equipo) c1).contiene(c);
            }
        }
        return exists;
    }

    @Override
    public String mates(Proyecto p) {
        StringBuilder mates= new StringBuilder();
       if(pertenece(p)) {
           mates.append("Los cotrabajadores del Team ").append(this.getName()).append(" en el proyecto ").append(p.getName()).append(" son: ");
           for (Componente c1 : p.getComponentes()) {
               mates.append(((Equipo) c1).TeamMates(this));
           }
           mates.delete(mates.length() - 2, mates.length());
           mates.append(".");
       }else{
           mates.append(this.getName()).append(" no pertenece al proyecto ").append(p.getName());
       }
        return mates.toString();
    }

    @Override
    public boolean pertenece(Proyecto p) {
        boolean result=false;
        if(p.getComponentes().contains(this)) {
            result = true;
        }else{
            for(Componente c1: p.getComponentes()){
                result=((Equipo) c1).contiene(this);
            }
        }
        return result;
    }
}
