package e3;

import e3.behaviors.Agobiao;
import e3.behaviors.DS_24_01;
import e3.behaviors.Jandro;
import e3.behaviors.Negev;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GunfightTest {

    @Test
    public void si() {
        Gunslinger g1 = new Gunslinger();
        Gunslinger g2 = new Gunslinger();
        Negev a = new Negev();
        Agobiao b = new Agobiao();
        Gunfight epico = new Gunfight();
        g1.setBehavior(a);


//        //assertEquals("Gunslinger 1 HAS WON!!\n", epico.duel(g1,g2));
//        assertEquals(GunslingerAction.RELOAD,g1.action());
//        g1.rivalAction(GunslingerAction.RELOAD);
//        assertEquals(1,g1.getRivalLoads());
//        g1.rivalAction(GunslingerAction.SHOOT);
//        assertEquals(0, g1.getRivalLoads());
//        assertEquals(GunslingerAction.RELOAD,g1.action());
//        g1.setLoads(5);
//        assertEquals(5,g1.getLoads());
//        assertEquals(GunslingerAction.MACHINE_GUN,g1.action());
//        assertEquals(0,g1.getLoads());
//        g1.setLoads(1);
//        assertEquals(1, g1.getLoads());
//        assertEquals(GunslingerAction.RELOAD,g1.action());
//        assertThrows(IllegalArgumentException.class, () -> g1.setLoads(-2));
//
//        g2.setBehavior(b);
//        g2.rivalAction(GunslingerAction.PROTECT);
//        assertEquals(GunslingerAction.SHOOT, g2.action());

        Gunslinger g3 = new Gunslinger();
        Gunslinger g4 = new Gunslinger();
        DS_24_01 b1=new DS_24_01();
        Jandro b2=new Jandro();
        g3.setBehavior(b1);
        g4.setBehavior(b2);
        epico.duel(g3,g4);

    }

}