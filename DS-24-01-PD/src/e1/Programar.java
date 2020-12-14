package e1;

public class Programar implements EstadoTermostato {
    private static final Programar instancia = new Programar();
    private Programar(){ }

    public static Programar getInstancia(){
        return instancia;
    }

    @Override
    public void cambiarModo (Termostato t, int time, float tempP, String modo){
        if(t.estado == Timer.getInstancia())
            throw new UnsupportedOperationException("Termostato en modo program/timer, primero pasar a off o manual");
        else{
            t.temperature = tempP;
            t.on = true;
        }
    }
}
