package e1;

import java.awt.image.DataBufferDouble;

abstract class Heroe extends Personaje {
    Heroe(String name, int HP, int armor) {
        super(name, HP, armor);
    }

    public void ataque (Dado dado, Personaje rival){
        int dmg =  Math.max(dado.tirada(100), dado.tirada(100));
        rival.damage(dmg);
    }
}