package e1;

import java.util.ArrayList;
import java.util.Random;

public class Juego {
    ArrayList<Heroe> EjercitoH = new ArrayList<>();
    ArrayList<Bestia> EjercitoB = new ArrayList<>();
    Dado DadoT = new Dado();

    public void Batalla(){
        // Se crea una lista de String
        Heroe H;
        Bestia B;

        while (!EjercitoH.isEmpty() || !EjercitoB.isEmpty()) {
            H = EjercitoH.get(0);
            B = EjercitoB.get(0);

            H.Ataque(DadoT, B);
            B.Ataque(DadoT, H);



            //H.takeDamage();

        }
    }

}
