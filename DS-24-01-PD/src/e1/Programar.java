package e1;

public class Programar implements EstadoTermostato {
    private static final Programar instancia = new Programar();
    private Programar(){ }

    public static Programar getInstancia(){
        return instancia;
    }

    @Override
    public void programarTermostato(Termostato t, int temperature){
        if(t.temperature > temperature){
            t.on = false;
            t.estado = Off.getInstancia();
        }
    }
}
