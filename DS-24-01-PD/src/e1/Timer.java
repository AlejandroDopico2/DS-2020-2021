package e1;

public class Timer extends EstadoTermostato{
    private static final Timer instancia = new Timer();
    private Timer() {}
    public static Off getInstancia (){
        return instancia;
    }

    @Override
    public void apagarTermostato (Termostato t){
        throw new UnsupportedOperationException(); // No se puede apagar un termostato en este modo
    }

    @Override
    public void timerTermostato(Termostato t, int time){
        if (time <= 0)
            throw new IllegalArgumentException("Tiempo no válido");
        else {
            t.setEstado(Timer.getInstancia());
            t.time = time;
        }

    }

}
