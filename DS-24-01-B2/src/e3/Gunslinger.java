package e3;

import java.util.LinkedList;
import java.util.List;

public class Gunslinger{
    Behavior behavior;
    private int Loads;
    List<GunslingerAction> RivalAction=new LinkedList<>();
    private int RivalLoads;

    public GunslingerAction action() {
        //   public GunslingerAction action(Gunslinger g); LLamo al behavior del Guneslinger y ahí ia diside que tiene que ahser
        return this.behavior.action(this);
    }

    public int getLoads(){
        return Loads;
    }
    public void rivalAction(GunslingerAction action){
        if(action== GunslingerAction.RELOAD){
            RivalLoads++;
        }
        RivalAction.add(action);
    }
    public List<GunslingerAction> getRivalActions(){
        return RivalAction;
    }
    public int getRivalLoads(){
        return RivalLoads;
    }
    public void setBehavior(Behavior behavior){
        this.behavior=behavior;
    }

    public void setLoads(int loads) {
        if (loads < 0) {
            throw new IllegalArgumentException("no");
        } else {
            this.Loads = loads;
        }
    }
}
