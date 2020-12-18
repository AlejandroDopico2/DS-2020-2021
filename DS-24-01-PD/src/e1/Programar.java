package e1;

public class Programar implements EstadoTermostato {
    private static final Programar instancia = new Programar();

    private Programar() {
    }

    public static Programar getInstancia() {
        return instancia;
    }

    @Override
    public  void offMode(Termostato t) {
        t.setEstado(Off.getInstancia());
        t.on = false;
        System.out.println("Se activa el modo Off");
    }

    @Override
    public void programMode(Termostato t, float tempP) {
        t.tempConsigna = tempP;
    }

    @Override
    public void timerMode(Termostato t, int time) {
        throw new UnsupportedOperationException("Debe pasar primero por el modo Off o Manual");
    }

    @Override
    public void manualMode(Termostato t) {
        t.setEstado(Manual.getInstancia());
        t.on = true;
        System.out.println("Se activa el modo manual");
    }


    @Override
    public void infoEstado(Termostato t) {
        System.out.print(t.temperature + " Modo Program (a " + t.tempConsigna + " grados) ");

        if(t.on)
            System.out.println("- calefacción encendida");
        else
            System.out.println("- calefacción apagada");

    }
}
