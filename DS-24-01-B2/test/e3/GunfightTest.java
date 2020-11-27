package e3;

import e3.behaviors.Predecible;
import e3.behaviors.Metralleta;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GunfightTest {

    @Test
    public void GunslingerTest() {
        Gunslinger g1 = new Gunslinger();
        Gunslinger g2 = new Gunslinger();
        Metralleta a = new Metralleta();
        Predecible b = new Predecible();
        g1.setBehavior(a);


        assertEquals(GunslingerAction.RELOAD,g1.action());
        g1.rivalAction(GunslingerAction.RELOAD);
        assertEquals(1,g1.getRivalLoads());
        g1.rivalAction(GunslingerAction.SHOOT);
        assertEquals(0, g1.getRivalLoads());
        assertEquals(GunslingerAction.RELOAD,g1.action());
        g1.setLoads(5);
        assertEquals(5,g1.getLoads());
        assertEquals(GunslingerAction.MACHINE_GUN,g1.action());
        assertEquals(0,g1.getLoads());
        g1.setLoads(1);
        assertEquals(1, g1.getLoads());
        assertEquals(GunslingerAction.RELOAD,g1.action());
        assertThrows(IllegalArgumentException.class, () -> g1.setLoads(-2));

        g2.setBehavior(b);
        assertEquals(GunslingerAction.RELOAD,g2.action());
        g2.rivalAction(GunslingerAction.PROTECT);
        assertEquals(GunslingerAction.SHOOT, g2.action());
        assertEquals(GunslingerAction.RELOAD, g2.action());
        g2.setLoads(5);
        assertEquals(GunslingerAction.MACHINE_GUN,g2.action());



    }
    @Test
    void DuelTest(){
        Gunslinger g3 = new Gunslinger();
        Gunslinger g4 = new Gunslinger();
        Metralleta c = new Metralleta();
        Predecible d = new Predecible();
        g3.setBehavior(c);
        g4.setBehavior(d);
        Gunfight batalla = new Gunfight();
        batalla.duel(g3,g4);
    }

}