package e3.behaviors;

import e3.*;
import java.util.List;
import java.util.Random;

public class Negev implements Behavior {

    @Override
    public GunslingerAction action(Gunslinger g) {
        if(g.getRivalActions().isEmpty()){
            return GunslingerAction.RELOAD;
        }else if(g.getLoads()==5){
            return GunslingerAction.MACHINE_GUN;
        }else{
            return GunslingerAction.RELOAD;
        }
    }
}
