package e4;

import java.util.EnumSet;
import java.util.Iterator;

public class TrafficJunction {
    EnumSet<Semaforo> junction;
    Iterator<Semaforo> iterate;
    public TrafficJunction() {
        junction=EnumSet.allOf(Semaforo.class);
        iterate=junction.iterator();
    }

    public void timesGoesBy () {
        for (Semaforo semaforo : junction) {
            Semaforo.cambioColor(semaforo, false);
//            if (!Semaforo.cambioColor(semaforo, false)) {
//                System.out.println("Si");
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
        StringBuilder c= new StringBuilder(new String(""));
       for(Semaforo semaforo : junction){
           c.append("[").append(semaforo.getNombre()).append(": ");
           if(semaforo.getColor()==Color.AMBERNB) {
               c.append("AMBER OFF");
           }else if (semaforo.getColor() == Color.AMBERB){
               c.append("AMBER ON");
           }else{
               c.append(semaforo.getColor());
           }

           if(semaforo.getColor()==Color.GREEN||semaforo.getColor()==Color.AMBERNB) {
               c.append(" ").append(semaforo.getContador());
           }
           c.append("]");
       }
       return c.toString();
    }


}


