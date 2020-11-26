package e1;

import java.util.ArrayList;
import java.util.Random;

public class Juego {
    private ArrayList<Heroe> EjercitoH = new ArrayList<>();
    private ArrayList<Bestia> EjercitoB = new ArrayList<>();

    public void setEjercitoH(ArrayList<Heroe> ejercitoH) {
        this.EjercitoH = ejercitoH;
    }

    public void setEjercitoB(ArrayList<Bestia> ejercitoB) {
        this.EjercitoB = ejercitoB;
    }

    public ArrayList<String> Batalla(Dado DadoT){

        ArrayList<String> Resumen = new ArrayList<>();
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
                if (B.getHP() <= 0) {
                    turno.append(B.getClass().getSimpleName()).append(" ").append(B.getName()).append(" dies! ").append("\n");
                    EjercitoB.remove(B);
                }
                if (H.getHP() <= 0) {
                    turno.append(H.getClass().getSimpleName()).append(" ").append(H.getName()).append(" dies! ").append("\n");
                    EjercitoH.remove(H);
                }
            }
            Resumen.add(turno.toString());
            turnos ++;
        }
        StringBuilder winner= new StringBuilder();
        if(EjercitoH.isEmpty()){
            winner.append("BESTIAS WIN!!!");
        }
        if(EjercitoB.isEmpty()){
            winner.append("HEROES WIN!!!");
        }
        Resumen.add(winner.toString());
        return Resumen;
    }
}
