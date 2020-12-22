package e2;

import java.util.HashMap;

public class Trabajador implements Componente{
    private final String name;
    private final int moneyperhour;
    HashMap<String, Float> horasProyecto = new HashMap<>();

    public Trabajador(String name, int moneyperhour) {
        this.name = name;
        if(moneyperhour>=0)
            this.moneyperhour = moneyperhour;
        else
            throw new IllegalArgumentException();

    }

    public void updateHours(float hours, Proyecto p){
        float newhours=hours + this.getHours(p);
        horasProyecto.put(p.getName(),newhours);
    }

    @Override
    public String mates (Proyecto p){
        StringBuilder mates= new StringBuilder();
        if(pertenece(p)){
            mates.append("Los cotrabajadores de ").append(this.getName()).append(" en el proyecto ").append(p.getName()).append(" son: ");
            for(Componente c1 : p.getComponentes()){
                mates.append(((Equipo) c1).teamMates(this));
            }
            mates.delete(mates.length()-2,mates.length());
            mates.append(".");
        }else{
            mates.append(this.getName()).append(" no pertenece al proyecto ").append(p.getName());
        }
        return mates.toString();
    }

    @Override
    public boolean pertenece(Proyecto p) {
        return horasProyecto.get(p.getName()) != null;
    }

    @Override
    public String infoString(Proyecto proyecto, int recursivo) {
        return "Worker " + name + ": " + getHours(proyecto) + " hours, " + getMoney(proyecto) + " €\n";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public float getMoney(Proyecto proyecto) {
        return getHours(proyecto)*moneyperhour;
    }

    @Override
    public float getHours(Proyecto proyecto) {
        if(horasProyecto.get(proyecto.getName())!=null)
           return horasProyecto.get(proyecto.getName());
        else
            return 0;
    }

    @Override
    public void inicializarHash(Proyecto p) {
        horasProyecto.putIfAbsent(p.getName(), 0f);
    }

}
