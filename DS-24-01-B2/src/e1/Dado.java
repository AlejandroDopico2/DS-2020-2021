package e1;

import java.util.Random;

public class Dado {
    public int DadoNormal(int tipo){
        Random Aleatorio = new Random();
        return Aleatorio.nextInt(tipo)+1;
    }
    public int DadoTrucado(int tipo){
        Random Aleatorio = new Random(2837);
        return Aleatorio.nextInt(tipo)+1;
    }
}
