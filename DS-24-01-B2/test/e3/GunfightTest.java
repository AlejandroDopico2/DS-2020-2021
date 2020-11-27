package e3;

import e3.behaviors.DS_24_01;
import e3.behaviors.ModoMonguer;
import e3.behaviors.Negev;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GunfightTest {

    @Test
    public void si() {
        Gunslinger g1 = new Gunslinger();
        Gunslinger g2 = new Gunslinger();
        DS_24_01 a = new DS_24_01();
        ModoMonguer b = new ModoMonguer();
        g1.setBehavior(a);
        g2.setBehavior(a);
        Gunfight epico = new Gunfight();
        assertEquals("Gunslinger 1 HAS WON!!\n", epico.duel(g1,g2));
    }

}