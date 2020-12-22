package e1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TermostatoTest {

    Termostato t = new Termostato();

    @Test
    public void TemperatureTest() {
        t.newTemperature(20.1f);

        t.manualMode();
        t.newTemperature(20.1f);
        t.newTemperature(21.5f);
        t.newTemperature(21.1f);

        t.timerMode(19);        // MODO TIMER
        t.newTemperature(21.0f);
        assertEquals(14, t.time);
        t.newTemperature(21.9f); // 9
        t.newTemperature(22.8f); // 4
        t.newTemperature(22.5f); // Modo OFF
        assertEquals(0, t.time);
        assertEquals(Off.getInstancia(), t.estado);

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

        t.offMode();
        assertEquals(Off.getInstancia(), t.estado);
        t.newTemperature(20.2f);
    }

    @Test
    public void ManualTest(){
        t.manualMode();

        assertEquals(Manual.getInstancia(), t.estado);

        t.newTemperature(20.1f);

        t.offMode(); // Cambio a OFF
        assertEquals(Off.getInstancia(), t.estado);
        assertFalse(t.on);

        t.manualMode(); // Cambio a Manual
        assertEquals(Manual.getInstancia(), t.estado);
        assertTrue(t.on);

        t.manualMode(); // Cambio a Manual
        assertEquals(Manual.getInstancia(), t.estado);
        assertTrue(t.on);

        t.programMode(20.1f); // Cambio a Program
        assertEquals(Programar.getInstancia(), t.estado);
        assertEquals(20.1f, t.tempConsigna);

        t.manualMode();

        t.timerMode(10); // Cambio a timer
        assertEquals(Timer.getInstancia(), t.estado);
        assertEquals(10, t.time);
    }

    @Test
    public void OffTest (){
        t.offMode();
        assertFalse(t.on);
        assertEquals(Off.getInstancia(), t.estado);

        t.offMode();
        assertFalse(t.on);
        assertEquals(Off.getInstancia(), t.estado);

        t.programMode(21.f);
        assertTrue(t.on);
        assertEquals(Programar.getInstancia(), t.estado);
        assertEquals(t.tempConsigna, 21f);

        t.offMode();

        t.timerMode(10);
        assertTrue(t.on);
        assertEquals(Timer.getInstancia(), t.estado);
        assertEquals(10, t.time);

        t.offMode();

        t.manualMode();
        assertTrue(t.on);
        assertEquals(Manual.getInstancia(), t.estado);
    }

    @Test
    public void ProgramTest (){
        t.programMode(20.f);
        assertEquals(20.f, t.tempConsigna);


        t.programMode(21.f);
        assertEquals(21.f, t.tempConsigna);

        assertThrows(UnsupportedOperationException.class, ()-> t.timerMode(10));
    }

    @Test
    public void TimerTest(){
        t.timerMode(10);

        assertEquals(10, t.time);

        assertThrows(UnsupportedOperationException.class, ()-> t.timerMode(10));
        assertThrows(UnsupportedOperationException.class, ()-> t.programMode(20f));

        t.manualMode();
        assertEquals(Manual.getInstancia(), t.estado);
    }
}