package e1;

import java.util.Random;

public class Dado {

    public static int Tirada(int max){
        Random Dado = new Random();

        return Dado.nextInt(max+1);
    }

}
