package e1;

public class Manual implements EstadoTermostato{

    private static final Manual instancia = new Manual();
    private Manual(){}
    public static Manual getInstancia (){
        return instancia;
    }

    @Override
    public void encenderTermostato (Termostato t){
        t.on = true;
        t.setEstado(Manual.getInstancia());
    }

    @Override
    public void apagarTermostato (Termostato t){
        t.on = false;
        t.setEstado(Off.getInstancia());
    }

    @Override
    public void programarTermostato(){

    }

}
