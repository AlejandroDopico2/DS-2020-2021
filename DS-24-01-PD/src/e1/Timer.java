package e1;

public class Timer implements EstadoTermostato{
    private static final Timer instancia = new Timer();
    private Timer() {}
    public static Timer getInstancia (){
        return instancia;
    }

    @Override
    public  void offMode(Termostato t) {
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
        throw new UnsupportedOperationException("Debe pasar primero por el modo Off o Manual");
    }

    @Override
    public void timerMode(Termostato t, int time) {
       throw new UnsupportedOperationException("Termostato ya está en timer, debe respetar el tiempo actual");
    }


    @Override
    public void infoEstado(Termostato t) {
        System.out.println(t.temperature + " Modo Timer (faltan " + t.time + " minutos ) - calefacción encendida");
    }
}
