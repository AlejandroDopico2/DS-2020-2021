package e1;

import java.util.ArrayList;
import java.util.Random;

public class Juego {
    ArrayList<Heroe> EjercitoH = new ArrayList<>();
    ArrayList<Bestia> EjercitoB = new ArrayList<>();

    public Juego(){
    }

    public void Batalla(Dado DadoT){
        ArrayList<StringBuilder> Resumen = new ArrayList<>();
        Heroe H;
        Bestia B;
        int i,turnos=1;
        while (!EjercitoH.isEmpty() && !EjercitoB.isEmpty()) {
            StringBuilder turno = new StringBuilder(100);
            turno.append("Turn").append(turnos).append("\n");
            for (i=0;i<EjercitoH.size()&&i<EjercitoB.size();i++) {
                H = EjercitoH.get(i);
                B = EjercitoB.get(i);
                turno.append("Fight between ").append(H.getName()).append(" (Energy= ").append(H.getHP()).append(") and ").append(B.getName()).append("(Energy=").append(B.getHP()).append(")").append("\n");

                H.Ataque(DadoT, B);
                B.Ataque(DadoT, H);
            }
            for (i=0;i<EjercitoH.size()&&i<EjercitoB.size();i++) {
                H = EjercitoH.get(i);
                B = EjercitoB.get(i);
                if (B.getHP() < 0) {
                    turno.append(B.getClass().getSimpleName()).append(" ").append(B.getName()).append(" dies! ").append("\n");
                    EjercitoB.remove(B);
                    i--;
                }
                if (H.getHP() < 0) {
                    turno.append(H.getClass().getSimpleName()).append(" ").append(H.getName()).append(" dies! ").append("\n");
                    EjercitoH.remove(H);
                    i--;
                }
            }


            Resumen.add(turno);
            turnos ++;
        }
        for(i=0;i<Resumen.size();i++){
            System.out.println(Resumen.get(i));
        }

        if(EjercitoH.isEmpty()){
            System.out.println("BESTIAS WIN!!!");
        }
        if(EjercitoB.isEmpty()){
            System.out.println("HEROES WIN!!!");
        }
    }

    public static void main(String [] args){
        DadoTrucado puede = new DadoTrucado();
        Juego josemanuel = new Juego();
        Heroe si = new Elfos ("Juse", 150, 30);
        Heroe sisoy = new Elfos ("Abel", 150, 30);
        Bestia messirve = new Orcos ("Jandro", 150, 30);
        Bestia no = new Orcos ("Paco", 150, 30);

        josemanuel.EjercitoH.add(si);
        josemanuel.EjercitoH.add(sisoy);
        josemanuel.EjercitoB.add(messirve);
        josemanuel.EjercitoB.add(no);

        josemanuel.Batalla(puede);
    }

}
