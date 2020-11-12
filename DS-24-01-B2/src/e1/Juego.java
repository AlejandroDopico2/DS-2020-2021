package e1;

import java.util.ArrayList;
import java.util.Random;

public class Juego {

    public int Dado(int tipo){
        Random Aleatorio = new Random();
       return Aleatorio.nextInt(tipo)+1;
    }
    public int DadoTrucado(int tipo){
        Random Aleatorio = new Random(2837);
        return Aleatorio.nextInt(tipo)+1;
    }

}
