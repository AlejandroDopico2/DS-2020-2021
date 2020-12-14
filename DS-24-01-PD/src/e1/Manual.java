package e1;

public class Manual implements EstadoTermostato{

    private static final Manual instancia = new Manual();
    private Manual(){}
    public static Manual getInstancia (){
        return instancia;
    }

    @Override
    public void cambiarModo (Termostato t, int time, float tempP, String modo){
        if (!t.on){
            t.on = true;
            t.setEstado(Manual.getInstancia());
        } else if ("Timer".equals(modo)){
            t.time = time;
            t.setEstado(Timer.getInstancia());
        } else if ("Program".equals(modo)){
            t.tempConsigna = tempP;
            t.setEstado(Programar.getInstancia());
        }
    }
}
