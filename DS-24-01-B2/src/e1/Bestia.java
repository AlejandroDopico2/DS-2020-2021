package e1;

import java.util.Random;

public class Bestia extends Personaje {

    public enum razaBestia {TRASGO, ORCO};

    private final Random r = new Random();

    String razaBestia;

    Bestia(String name, int HP, int armor) {
        super(name, HP, armor);
    }

    public int calcularDmg (){
        int dmg;
        return dmg = r.nextInt(91);
    }
}