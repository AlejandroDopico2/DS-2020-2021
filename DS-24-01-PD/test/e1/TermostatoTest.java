package e1;

import org.junit.jupiter.api.Test;
import org.junit.Assert;

import static org.junit.jupiter.api.Assertions.*;

class TermostatoTest {

    @Test
    public void TemperatureTest() {
        Termostato t = new Termostato();
        t.newTemperature(20.1f);

        assertEquals(20.1f, t.temperature);
        assertEquals(Off.getInstancia(), t.estado);

    // MODO MANUAL
        t.manualMode();

        assertEquals(Manual.getInstancia(), t.estado);

        t.newTemperature(20.1f);
        t.newTemperature(21.5f);
        t.newTemperature(21.1f);

        t.offMode(); // Cambio a OFF
        assertEquals(Off.getInstancia(), t.estado);
        assertFalse(t.on);

        t.manualMode(); // Cambio a Manual
        assertEquals(Manual.getInstancia(), t.estado);
        assertTrue(t.on);




    // MODO TIMER
        t.timerMode(19);
        assertEquals(Timer.getInstancia(), t.estado);

        assertThrows(UnsupportedOperationException.class, ()-> t.timerMode(20));
        assertThrows(UnsupportedOperationException.class, ()-> t.timerMode(20));


        t.newTemperature(21.0f);

        assertEquals(14, t.time);

        t.newTemperature(21.9f);

        t.newTemperature(22.8f);
        t.newTemperature(22.5f);
        t.newTemperature(21.4f);

        t.programMode(20);
        t.newTemperature(21.2f);
        t.newTemperature(20.8f);

        t.newTemperature(20.1f);
        assertFalse(t.on);
        t.newTemperature(19.2f);
        assertTrue(t.on);

        t.newTemperature(19.9f);
        t.newTemperature(20.7f);
        t.newTemperature(22.8f);

        assertThrows(UnsupportedOperationException.class, ()-> t.timerMode(20));

        t.offMode();
        assertEquals(Off.getInstancia(), t.estado);

        t.newTemperature(20.2f);
    }

}