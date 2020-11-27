package e3;

public class Gunfight {
    public void duel(Gunslinger g1, Gunslinger g2){
        boolean finish=false;
        int t=1;
        while(!finish && t<51){
            GunslingerAction p1=g1.action();
            GunslingerAction p2=g2.action();
            System.out.println("Turno "+t);
            System.out.println("Gunslinger 1: " +p1);
            System.out.println("Gunslinger 2: " +p2);
            g1.rivalAction(p2);
            g2.rivalAction(p1);
            if(p1==GunslingerAction.SHOOT&&p2==GunslingerAction.SHOOT||p1==GunslingerAction.MACHINE_GUN&&p2==GunslingerAction.MACHINE_GUN){
                finish=true;
                System.out.println("Empateishon\n");
                //empateishon
            }else if(p1==GunslingerAction.MACHINE_GUN){
                finish=true;
                System.out.println("Gunslinger 1 HAS WON!!\n");
                //gana el primero
            }else if(p2==GunslingerAction.MACHINE_GUN){
                finish=true;
                System.out.println("Gunslinger 2 HAS WON!!\n");
                //gana el segundo
            }else  if(p1==GunslingerAction.SHOOT&&p2!=GunslingerAction.PROTECT){
                finish=true;
                System.out.println("Gunslinger 1 HAS WON!!\n");
                //empateishon
            }else if(p2==GunslingerAction.SHOOT&&p1!=GunslingerAction.PROTECT){
                finish=true;
                System.out.println("Gunslinger 2 HAS WON!!\n");
            }else if(t==50){
                System.out.println("Empateishon\n");
            }else{
                System.out.println("The duel continues...\n");
            }
            t++;
        }
    }
}
