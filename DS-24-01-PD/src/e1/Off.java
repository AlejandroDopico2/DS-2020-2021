package e1;

public class Off implements EstadoTermostato {

    private static final Off instancia = new Off();
    private Off() {}
    public static Off getInstancia (){
        return instancia;
    }

    @Override
    public void cambiarModo (Termostato t, int time, float tempP, String modo){
        if(!t.on){
            t.on = true;
            t.setEstado(Manual.getInstancia());
        } else{
            t.on = false;
            t.setEstado(Off.getInstancia());
        }
    }
}
