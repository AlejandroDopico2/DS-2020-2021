package e1;

import java.util.Random;

public class DadoTrucado extends Dado{

    @Override
    public int Tirada(int max){
        Random DadoT = new Random(2837);
        return DadoT.nextInt(max+1);
    }
}