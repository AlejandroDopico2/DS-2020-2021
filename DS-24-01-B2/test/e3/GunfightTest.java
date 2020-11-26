package e3;

import e3.behaviors.DS_24_01;
import e3.behaviors.MyBeha;
import e3.behaviors.Negev;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GunfightTest {

    @Test
    public void si() {
        Gunslinger g1 = new Gunslinger();
        Gunslinger g2 = new Gunslinger();
        DS_24_01 a = new DS_24_01();
        Negev b = new Negev();
        MyBeha c = new MyBeha();
        g1.setBehavior(a);
        g2.setBehavior(c);
        Gunfight epico = new Gunfight();
        assertEquals("Gunslinger 1 está mamadísimo\n", epico.duel(g1,g2));

        g1.setBehavior(b);
        Gunfight epico2 = new Gunfight();
        assertEquals("Gunslinger 1 está mamadísimo\n", epico2.duel(g1, g2));
    }

}