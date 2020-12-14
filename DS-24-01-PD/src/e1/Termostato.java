package e1;

public class Termostato {
    boolean on;
    float temperature;
    float tempConsigna;
    int time;
    EstadoTermostato estado = Off.getInstancia();

    private void newTemperature (float currentTemperature) {
        time -= 5;

        this.temperature = currentTemperature;

    }

    public EstadoTermostato getEstado(){
        return estado;
    }
    public void setEstado(EstadoTermostato estado){
        this.estado = estado;
    }

}
