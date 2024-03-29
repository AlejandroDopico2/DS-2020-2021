package e3.behaviors;

import e3.*;
import java.util.List;
import java.util.Random;

public class Predecible implements Behavior{
    @Override
    public GunslingerAction action(Gunslinger g) {
        if(g.getRivalActions().isEmpty()){
            return GunslingerAction.RELOAD;
        }else if(g.getLoads()==5) {
            return GunslingerAction.MACHINE_GUN;
        }else if(g.getRivalActions().get(g.getRivalActions().size()-1)==GunslingerAction.RELOAD){
            return GunslingerAction.PROTECT;
        }else if(g.getLoads()!=0){
            return GunslingerAction.SHOOT;
        }else{
            return GunslingerAction.RELOAD;
        }
    }
}
