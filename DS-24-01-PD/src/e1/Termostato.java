package e1;

public class Termostato {
    boolean on;
    float temperature;
    float tempConsigna;
    int time;
    EstadoTermostato estado = Off.getInstancia(); // Al inicio esta apagada

    public void offMode (){
        estado.offMode(this);
    }

    public void manualMode (){
        estado.manualMode(this);
    }

    public void programMode (int temp){
        estado.programMode(this, temp);
    }

    public void timerMode (int timer){
        estado.timerMode(this, timer);
    }

    public void infoEstado() {
        estado.infoEstado(this);
    }

    public void screenInfo(){
        this.infoEstado();
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

            this.on = !(this.temperature >= tempConsigna);
        }

        screenInfo();
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
        t.manualMode();
        t.newTemperature(20.1f);
        t.newTemperature(21.5f);
        t.newTemperature(21.1f);
        t.timerMode(19);
        t.newTemperature(21.0f);
        t.newTemperature(21.9f);
        t.newTemperature(22.8f);
        t.newTemperature(22.5f);
        t.newTemperature(21.4f);
        t.programMode(20);
        t.newTemperature(21.2f);
        t.newTemperature(20.8f);
        t.newTemperature(20.1f);
        t.newTemperature(19.2f);
        t.newTemperature(19.9f);
        t.newTemperature(20.7f);
        t.newTemperature(22.8f);
        t.offMode();
        t.newTemperature(20.2f);
    }
}
