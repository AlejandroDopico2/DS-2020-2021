package e1;

import java.awt.image.DataBufferDouble;

abstract class Heroe extends Personaje {
    Heroe(String name, int HP, int armor) {
        super(name, HP, armor);
    }

    public void Ataque (Dado Dado, Personaje rival){
        int dmg =  Math.max(Dado.Tirada(100), Dado.Tirada(100));

        rival.Damage(dmg);
    }
}
