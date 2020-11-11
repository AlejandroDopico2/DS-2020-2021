package e1;

import java.util.Random;

public class Heroe extends Personaje {

    public enum razaHeroe {HOBBIT, ELFO, HUMANO};

        private final Random r = new Random();

        String razaHeroe;

    Heroe(String name, int HP, int armor) {
        super(name, HP, armor);
    }

    public int calcularDmg (){

        return Math.max(r.nextInt(101), r.nextInt(101));
    }
}
