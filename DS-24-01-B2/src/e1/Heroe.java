package e1;

import java.util.Random;

public class Heroe extends Personaje {
    Heroe(String name, int HP, int armor) { super(name, HP, armor); }

    @Override
    public int calcularDmg() {
        return 0;
    }
}
