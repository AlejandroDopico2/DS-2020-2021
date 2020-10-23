package e4;

import java.util.EnumSet;

public class TrafficJunction {
    EnumSet<Semaforo> junction;

    public TrafficJunction() {
        junction=EnumSet.allOf(Semaforo.class);
    }

    public void timesGoesBy () {
        for (Semaforo semaforo : junction) {
           Semaforo.cambioColor(semaforo, false);
            }
        }

    public void amberJunction(boolean active){
        if(active) {
            for (Semaforo semaforo : junction)
                Semaforo.cambioColor(semaforo, true);
        }else
            Semaforo.resetJunction();
        }

   @Override
    public String toString() {
        StringBuilder c= new StringBuilder();
       for(Semaforo s : Semaforo.values()){
           c.append("[").append(s.getNombre()).append(": ");
           if(s.getColor()==Color.AMBERNB) {
               c.append("AMBER OFF");
           }else if (s.getColor() == Color.AMBERB){
               c.append("AMBER ON");
           }else{
               c.append(s.getColor());
           }

           if(s.getColor()==Color.GREEN||s.getColor()==Color.AMBERNB) {
               c.append(" ").append(s.getContador());
           }
           c.append("]");
       }
       return c.toString();
    }
}