package e1;

public class Off implements EstadoTermostato {

    private static final Off instancia = new Off();
    private Off() {}
    public static Off getInstancia (){
        return instancia;
    }

    @Override
    public void offMode(Termostato t) {

    }

    @Override
    public void programMode(Termostato t, float tempP) {
        t.setEstado(Programar.getInstancia());
        t.tempConsigna = tempP;
        t.on = true;
        System.out.println("Se activa el modo Program a " + tempP + " grados");

    }

    @Override
    public void timerMode(Termostato t, int time) {
        t.setEstado(Timer.getInstancia());
        t.time = time;
        t.on = true;
        System.out.println("Se activa el modo Timer " + time + " minutos");
    }

    @Override
    public void manualMode(Termostato t) {
        t.setEstado(Manual.getInstancia());
        t.on = true;
        System.out.println("Se activa el modo manual");

    }

    @Override
    public void infoEstado(Termostato t) {
        System.out.println(t.temperature + " Modo Off - calefacción apagada");
    }
}
