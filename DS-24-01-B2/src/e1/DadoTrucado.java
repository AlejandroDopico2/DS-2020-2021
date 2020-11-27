package e1;

import java.util.Random;

public class DadoTrucado extends Dado{

    @Override
    public int tirada(int max){
        Random DadoT = new Random(2539);
        return DadoT.nextInt(max+1);
    }
}