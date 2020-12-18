package e1;

public class Termostato {
    protected boolean on;
    protected float temperature;
    protected float tempConsigna;
    protected int time;
    protected EstadoTermostato estado = Off.getInstancia(); // Al inicio esta apagada

    public void offMode (){
        estado.offMode(this);
    }

    public void manualMode (){
        estado.manualMode(this);
    }

    public void programMode (float temp){
        estado.programMode(this, temp);
    }

    public void timerMode (int timer){
        estado.timerMode(this, timer);
    }

    public void infoEstado() {
        estado.infoEstado(this);
    }

    private void screenInfo(){
        this.infoEstado();
    }

    public void newTemperature (float currentTemperature) {
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

}
