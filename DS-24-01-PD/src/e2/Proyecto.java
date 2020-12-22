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

    public void addComponent (Componente c){
        if(c instanceof Trabajador) {
            throw new IllegalArgumentException();
        }else {
            if (!c.pertenece(this)) {
                componentes.add(c);
                c.inicializarHash(this);
            } else {
                throw new UnsupportedOperationException();
            }
        }
    }

    public String StringProyecto() {
        int recursivo = 1;
        StringBuilder info = new StringBuilder();
        info.append("Proyecto: ").append(name).append("\n");
        for (Componente c1 : componentes) {
            info.append("\t".repeat(Math.max(0, recursivo)));
            info.append(c1.infoString(this, recursivo));
            recursivo++;
        }
        return info.toString();
    }
}
