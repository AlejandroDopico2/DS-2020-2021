package e3.behaviors;

import e3.*;
import java.util.List;
import java.util.Random;
public class DS_24_01 implements Behavior{
    @Override
    public GunslingerAction action(Gunslinger g) {
        Random matar= new Random();
        int siguiente;
        if(g.getRivalActions().isEmpty()){
            return GunslingerAction.RELOAD;
        }else if(g.getLoads()==5) {
            return GunslingerAction.MACHINE_GUN;
        }else if(g.getRivalLoads()==4&&g.getLoads()!=0){
            return GunslingerAction.SHOOT;
        }else if(g.getRivalActions().get(g.getRivalActions().size()-1)== GunslingerAction.RELOAD) {
            return GunslingerAction.PROTECT;
        }else{
            siguiente=matar.nextInt(3);
            if(siguiente==0){
                return GunslingerAction.RELOAD;
            }else if(siguiente==1){
                return GunslingerAction.SHOOT;
            }else{
                return GunslingerAction.PROTECT;
            }
        }
    }
}
