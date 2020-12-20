package e1;

public class Termostato {
    // Visibilidad en private package, solo puede acceder a los atributos las clases del paquete
    boolean on;
    float temperature;
    float tempConsigna;
    int time;
    EstadoTermostato estado = Off.getInstancia(); // Al inicio esta apagada

    void offMode (){
        estado.offMode(this);
    }

    void manualMode (){
        estado.manualMode(this);
    }

    void programMode (float temp){
        estado.programMode(this, temp);
    }

    void timerMode (int timer){
        estado.timerMode(this, timer);
    }

    void infoEstado() {
        estado.infoEstado(this);
    }

    private void screenInfo(){
        this.infoEstado();
    }

    void newTemperature (float currentTemperature) {
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
