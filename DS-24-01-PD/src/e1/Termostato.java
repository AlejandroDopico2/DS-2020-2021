package e1;

import java.sql.SQLOutput;
import java.util.List;
import java.util.logging.SocketHandler;

public class Termostato {
    boolean on;
    float temperature;
    float tempConsigna;
    int time;
    EstadoTermostato estado = Off.getInstancia(); // Al inicio esta apagada

    public void cambiarModo(int time, float tempP, String modo){
        estado.cambiarModo(this, time, tempP, modo);
    }

    public void infoEstado() {
        estado.infoEstado(this);
    }

    private void newTemperature (float currentTemperature) {

        this.temperature = currentTemperature;
        if(this.getEstado() == Timer.getInstancia()){
            time -= 5;
            if(time <= 0){
                this.setEstado(Off.getInstancia());
                System.out.println("Se desactiva el modo Timer");
                time = 0;
            }
        } else if (this.getEstado() == Programar.getInstancia()){
            if(this.temperature >= tempConsigna)
                this.on = false;
            else
                this.on = true;

        }
        screenInfo();
    }

    public void screenInfo(){
        this.infoEstado();
    }


    public EstadoTermostato getEstado(){
        return estado;
    }
    public void setEstado(EstadoTermostato estado){
        this.estado = estado;
    }

    public static void main(String[] args) {

        Termostato t = new Termostato();
        t.newTemperature(20.1f);
        t.cambiarModo(0, 0, "Manual");
        t.newTemperature(20.1f);
        t.newTemperature(21.5f);
        t.newTemperature(21.1f);
        t.cambiarModo(19, 0, "Timer");
        t.newTemperature(21.0f);
        t.newTemperature(21.9f);
        t.newTemperature(22.8f);
        t.newTemperature(22.5f);
        t.newTemperature(21.4f);
        t.cambiarModo(0, 20f, "Program");
        t.newTemperature(21.2f);
        t.newTemperature(20.8f);
        t.newTemperature(20.1f);
        t.newTemperature(19.2f);
        t.newTemperature(19.9f);
        t.newTemperature(20.7f);
        t.newTemperature(22.8f);
        t.cambiarModo(0, 0, "Off");
        t.newTemperature(20.2f);
    }
}
