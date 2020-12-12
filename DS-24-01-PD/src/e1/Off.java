package e1;

public class Off implements EstadoTermostato {

    private static final Off instancia = new Off();
    private Off() {}
    public static Off getInstancia (){
        return instancia;
    }

    @Override
    public void apagarTermostato (Termostato t){
        if(t.on) {
            t.on = false;
            t.setEstado(Off.getInstancia());
        } else
            throw new UnsupportedOperationException();
    }


}
