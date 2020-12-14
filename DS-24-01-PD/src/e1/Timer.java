package e1;

public class Timer implements EstadoTermostato{
    private static final Timer instancia = new Timer();
    private Timer() {}
    public static Timer getInstancia (){
        return instancia;
    }

    @Override
    public void cambiarModo (Termostato t, int time, float tempP, String modo){
        if(t.estado == Programar.getInstancia())
            throw new UnsupportedOperationException("Termostato en modo program/timer, primero pasar a off o manual");
        else{
            t.time= time;
            t.on = true;
        }
    }

}
