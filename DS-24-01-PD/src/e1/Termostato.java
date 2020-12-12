package e1;

public class Termostato {
    protected boolean on;
    protected float temperature;
    protected int time;
    EstadoTermostato estado = Off.getInstancia();

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

    public EstadoTermostato getEstado(){
        return estado;
    }
    public void setEstado(EstadoTermostato estado){
        this.estado = estado;
    }

}
