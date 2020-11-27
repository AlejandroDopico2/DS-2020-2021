package e3.behaviors;

import e3.Behavior;
import e3.Gunslinger;
import e3.*;
import java.util.List;
import java.util.Random;

public class Jandro implements Behavior {

        @Override
        public GunslingerAction action(Gunslinger g) {
            int last;
            if( g.getRivalActions().size() > 0)
                last = g.getRivalActions().size() -1;
            else
                last = g.getRivalActions().size();

            if(g.getLoads()==0 && g.getRivalLoads()== 0){
                return GunslingerAction.RELOAD;
            }else if(g.getRivalLoads() == 0 && g.getLoads() > 0 && g.getRivalActions().get(last).equals(GunslingerAction.PROTECT)){
                return GunslingerAction.SHOOT;
            }else if(g.getRivalLoads() == 4 && g.getLoads() > 0 && g.getRivalActions().get(last).equals(GunslingerAction.RELOAD)){
                return GunslingerAction.SHOOT;
            }else if(g.getRivalLoads() == 0 ){
                return GunslingerAction.RELOAD;
            }else if(g.getLoads() == 5){
                return GunslingerAction.MACHINE_GUN;
            }else if(g.getRivalLoads() < 4 ){
                return GunslingerAction.PROTECT;
            }else if(g.getRivalActions().get(last).equals(GunslingerAction.SHOOT)){
                return GunslingerAction.SHOOT;
            }
            return GunslingerAction.RELOAD;
        }
}
