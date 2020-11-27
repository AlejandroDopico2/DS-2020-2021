package e3.behaviors;

import e3.Behavior;
import e3.Gunslinger;
import e3.GunslingerAction;

public class ModoMonguer implements Behavior {
    @Override
    public GunslingerAction action (Gunslinger g){
        if (g.getRivalActions().isEmpty() || g.getLoads() == 0)
            return GunslingerAction.RELOAD;
        else
            return GunslingerAction.PROTECT;
    }
}
