package e1;

public class Manual implements EstadoTermostato{

    private static final Manual instancia = new Manual();
    private Manual(){}
    public static Manual getInstancia (){
        return instancia;
    }

    @Override
    public void offMode(Termostato t) {
        t.setEstado(Off.getInstancia());
        t.on = false;
        System.out.println("Se activa el modo Off");
    }

    @Override
    public void manualMode(Termostato t) {
        t.setEstado(Manual.getInstancia());
        t.on = true;
        System.out.println("Se activa el modo manual");
    }

    @Override
    public void programMode(Termostato t, float tempP) {
        t.setEstado(Programar.getInstancia());
        t.tempConsigna = tempP;
        System.out.println("Se activa el modo Program a " + tempP + " grados");
    }

    @Override
    public void timerMode(Termostato t, int time) {
        t.setEstado(Timer.getInstancia());
        t.time = time;
        System.out.println("Se activa el modo Timer " + time + " minutos");
    }

    @Override
    public void infoEstado(Termostato t) {
        System.out.println(t.temperature + " Modo Manual - calefacción encendida");
    }
}
