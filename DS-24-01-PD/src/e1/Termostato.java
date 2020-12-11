package e1;

public class Termostato {
    private boolean on;
    private float temperature;
    private int time;

    private void newTemperature (float currentTemperature){
        time += 5;

        //if( modo == timer && time >= timer ){
            //  modo = off
            // on = false;
        if (!on)
            throw new IllegalArgumentException("El termostato está apagado");
        else
            this.temperature = currentTemperature;

    }

}
