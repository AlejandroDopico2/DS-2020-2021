package e3;

import e3.behaviors.DS_24_01;
import e3.behaviors.Negev;

public class Gunfight {
    public void duel(Gunslinger g1, Gunslinger g2){
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
            if(p1==GunslingerAction.SHOOT&&p2==GunslingerAction.SHOOT||p1==GunslingerAction.MACHINE_GUN&&p2==GunslingerAction.MACHINE_GUN){
                finish=true;
                System.out.println("Empateishon\n");
                //empateishon
            }else if(p1==GunslingerAction.MACHINE_GUN){
                finish=true;
                System.out.println("Gunslinger 1 está mamadísimo\n");
            }else if(p2==GunslingerAction.MACHINE_GUN){
                finish = true;
                System.out.println("Gunslinger 2 está mamadísimo\n");
            }else if(p1==GunslingerAction.SHOOT&&p2!=GunslingerAction.PROTECT){
                finish=true;
                System.out.println("Gunslinger 1 está mamadísimo\n");
                //gana el primero
            }else if(p2==GunslingerAction.SHOOT&&p1!=GunslingerAction.PROTECT){
                finish=true;
                System.out.println("Gunslinger 2 está mamadísimo\n");
                //gana el segundo
            }
            t++;
        }
    }
    public static void main(String [] args){
        Gunslinger g1 = new Gunslinger();
        Gunslinger g2 = new Gunslinger();
        DS_24_01 a = new DS_24_01();
        Negev b = new Negev();
        g1.setBehavior(a);
        g2.setBehavior(a);
        Gunfight epico = new Gunfight();
        epico.duel(g1,g2);
    }
}
