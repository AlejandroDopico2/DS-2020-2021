package e1;

public class Timer implements EstadoTermostato{
    private static final Timer instancia = new Timer();
    private Timer() {}
    public static Timer getInstancia (){
        return instancia;
    }

    @Override
    public void cambiarModo (Termostato t, int time, float tempP, String modo){
        if("Program".equals(modo))
            throw new UnsupportedOperationException("Termostato en modo program/timer, primero pasar a off o manual");
        else{
            if ("Manual".equals(modo)){
                t.setEstado(Manual.getInstancia());
                System.out.println("Se activa el modo manual");
                t.time = 0;
            } else if ("Off".equals(modo)){
                t.setEstado(Off.getInstancia());
                t.on = false;
                System.out.println("Se activa el modo Off");
            }
        }
    }
    @Override
    public void infoEstado(Termostato t) {
        System.out.println(t.temperature + " Modo Timer (faltan " + t.time + " minutos ) - calefacción encendida");
    }
}
