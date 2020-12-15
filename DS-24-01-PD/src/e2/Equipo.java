package e2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Equipo implements Componente {
    private final String name;
    private int money = 0;
    private int hours = 0;
    private ArrayList<Componente> componentes = new ArrayList<>();

    public Equipo(String name) {
        this.name = name;
    }

    public void addComponente(Componente c) {
        componentes.add(c);
    }

    @Override
    public String printInfo(Proyecto proyecto) {
        StringBuilder info = new StringBuilder();

        info.append("Team ").append(name).append(": ").append(getHours(proyecto)).append("hours, ").append(getMoney(proyecto)).append(" €\n");

        Iterator<Componente> si = componentes.iterator();
        while (si.hasNext()) {
            Componente c1 = si.next();
            info.append("\t").append(c1.printInfo(proyecto));
        }
        return info.toString();
    }

    @Override
    public int getMoney(Proyecto proyecto) {
        money = 0;
        Iterator<Componente> si = componentes.iterator();
        while (si.hasNext()) {
            Componente c1 = si.next();
            money += c1.getMoney(proyecto);
        }
        return money;
    }

    @Override
    public int getHours(Proyecto proyecto) {
        hours = 0;
        Iterator<Componente> si = componentes.iterator();
        while (si.hasNext()) {
            Componente c1 = si.next();
            hours += c1.getHours(proyecto);
        }
        return hours;
    }
}
