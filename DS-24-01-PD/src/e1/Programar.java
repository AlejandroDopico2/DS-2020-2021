package e1;

public class Programar implements EstadoTermostato {
    private static final Programar instancia = new Programar();

    private Programar() {
    }

    public static Programar getInstancia() {
        return instancia;
    }

    @Override
    public void cambiarModo(Termostato t, int time, float tempP, String modo) {
        if ("Timer".equals(modo))
            throw new UnsupportedOperationException("Termostato en modo program/timer, primero pasar a off o manual");
        else {
            if ("Manual".equals(modo)) {
                t.setEstado(Manual.getInstancia());
                System.out.println("Se activa el modo manual");
                t.time = 0;
            } else if ("Off".equals(modo)) {
                t.setEstado(Off.getInstancia());
                t.on = false;
                System.out.println("Se activa el modo Off");
            }
        }
    }

    @Override
    public void infoEstado(Termostato t) {
        System.out.print(t.temperature + " Modo " + getInstancia() + "(a " + t.tempConsigna + " grados) ");

        if(t.on)
            System.out.println("- calefacción encendida");
        else
            System.out.println("- calefacción apagada");

    }
}
