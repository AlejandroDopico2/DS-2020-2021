package e1;

import java.util.Random;

public class Dado {

    public int tirada(int max){
        Random Dado = new Random();
        return Dado.nextInt(max+1);
    }
}
