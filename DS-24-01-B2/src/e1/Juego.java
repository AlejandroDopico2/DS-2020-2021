package e1;

import java.util.ArrayList;
import java.util.Random;

public class Juego {
    ArrayList<Heroe> EjercitoH = new ArrayList<>();
    ArrayList<Bestia> EjercitoB = new ArrayList<>();
    DadoTrucado DadoT = new DadoTrucado();

    public Juego(){
    }

    public void Batalla(){
        // Se crea una lista de String
        Heroe H;
        Bestia B;
        int i=0;

        while (!EjercitoH.isEmpty() || !EjercitoB.isEmpty()) {
            H = EjercitoH.get(0);
            B = EjercitoB.get(0);

            System.out.println(H.getHP());
            System.out.println(B.getHP());

            H.Ataque(DadoT, B);
            B.Ataque(DadoT, H);

            System.out.println(H.getHP());
            System.out.println(B.getHP());

            if(B.getHP()<0){
                EjercitoB.remove(B);
            }
            if(H.getHP()<0){
                EjercitoH.remove(H);
            }
        }
    }

    public static void main(String [] args){
        Juego josemanuel = new Juego();
        Heroe si = new Elfos ("Juse", 150, 30);
        Bestia messi = new Orcos ("Jandro", 150, 30);

        josemanuel.EjercitoH.add(si);
        josemanuel.EjercitoB.add(messi);

        josemanuel.Batalla();
    }

}
