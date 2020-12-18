package e1;

public class Termostato {
    protected boolean on;
    protected float temperature;
    protected float tempConsigna;
    protected int time;
    protected EstadoTermostato estado = Off.getInstancia(); // Al inicio esta apagada

    protected void offMode (){
        estado.offMode(this);
    }

    protected void manualMode (){
        estado.manualMode(this);
    }

    protected void programMode (float temp){
        estado.programMode(this, temp);
    }

    protected void timerMode (int timer){
        estado.timerMode(this, timer);
    }

    protected void infoEstado() {
        estado.infoEstado(this);
    }

    private void screenInfo(){
        this.infoEstado();
    }

    protected void newTemperature (float currentTemperature) {
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

    private EstadoTermostato getEstado(){
        return estado;
    }

    // Private package
    void setEstado(EstadoTermostato estado){
        this.estado = estado;
    }
}
