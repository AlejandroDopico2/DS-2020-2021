package e1;

public class Off implements EstadoTermostato {

    private static final Off instancia = new Off();
    private Off() {}
    public static Off getInstancia (){
        return instancia;
    }

    @Override
    public void cambiarModo (Termostato t, int time, float tempP, String modo){
        if ("Off".equals(modo)){
            t.setEstado(Off.getInstancia());
            t.on = false;
            System.out.println("Se activa el modo Off");
        }else{
            t.on = true;
            if ("Manual".equals(modo)){
                t.setEstado(Manual.getInstancia());
                System.out.println("Se activa el modo manual");
            } else if ("Timer".equals(modo)){
                t.time = time;
                t.setEstado(Timer.getInstancia());
                System.out.println("Se activa el modo Timer " + time + " minutos");
            } else if ("Program".equals(modo)){
                t.tempConsigna = tempP;
                t.setEstado(Programar.getInstancia());
                System.out.println("Se activa el modo Program a " + tempP + " grados");

            }
        }
    }

    @Override
    public void infoEstado(Termostato t) {
        System.out.println(t.temperature + " Modo Off - calefacción apagada");
    }
}
