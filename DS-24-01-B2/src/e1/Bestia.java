package e1;

import java.util.Random;

public class Bestia extends Personaje {
    Bestia(String name, int HP, int armor) { super(name, HP, armor); }

    @Override
    public int calcularDmg() {
        return 0;
    }
}