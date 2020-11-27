package e3;

public class Gunfight {
    public String duel(Gunslinger g1, Gunslinger g2){
        boolean finish=false;
        int t=1;
        while((!finish)){
            GunslingerAction p1=g1.action();
            GunslingerAction p2=g2.action();
            System.out.println("Turno"+t);
            System.out.println("Gunslinger 1: " +p1);
            System.out.println("Gunslinger 2: " +p2);
            g1.rivalAction(p2);
            g2.rivalAction(p1);
//            if(p1==GunslingerAction.RELOAD){
//                g1.setLoads(g1.getLoads()+1);
//            }
//            if(p2==GunslingerAction.RELOAD){
//                g2.setLoads(g2.getLoads()+1);
//            }
//            if(p1==GunslingerAction.SHOOT){
//                g1.setLoads(g2.getLoads()-1);
//            }
//            if(p2==GunslingerAction.SHOOT){
//                g2.setLoads(g2.getLoads()-1);
//            }
            if(p1==GunslingerAction.SHOOT&&p2==GunslingerAction.SHOOT||p1==GunslingerAction.MACHINE_GUN&&p2==GunslingerAction.MACHINE_GUN){
                finish=true;
                System.out.println("Empateishon\n");
                return "Empateishon\n";
                //empateishon
            }else if(p1==GunslingerAction.MACHINE_GUN){
                finish=true;
                System.out.println("Gunslinger 1 HAS WON!!\n");
                return "Gunslinger 1 HAS WON!!\n";
                //gana el primero
            }else if(p2==GunslingerAction.MACHINE_GUN){
                finish=true;
                System.out.println("Gunslinger 2 HAS WON!!\n");
                return "Gunslinger 1 HAS WON!!\n";
                //gana el segundo
            }else  if(p1==GunslingerAction.SHOOT&&p2!=GunslingerAction.PROTECT){
                finish=true;
                System.out.println("Gunslinger 1 HAS WON!!\n");
                return "Gunslinger 1 HAS WON!!\n";
                //empateishon
            }else if(p2==GunslingerAction.SHOOT&&p1!=GunslingerAction.PROTECT){
                finish=true;
                System.out.println("Gunslinger 2 HAS WON!!\n");
                return "Gunslinger 2 HAS WON!!\n";
            }
            t++;
            System.out.println("The duel continues...\n");
        }
        return null;
    }
}
