package e4;

public enum Semaforo {
    NORTH(Nombre.NORTH, Color.GREEN, 0),
    SOUTH(Nombre.SOUTH, Color.RED, 0),
    EAST(Nombre.EAST, Color.RED, 0),
    WEST(Nombre.WEST, Color.RED, 0);

    private final Nombre nombre;
    private Color color;
    private int contador;

    Semaforo(Nombre nombre, Color color, int contador){
        this.nombre=nombre;
        this.color=color;
        this.contador=contador;
    }

    public Nombre getNombre(){
        return nombre;
    }

    public Color getColor() {
        return color;
    }

    public int getContador(){
        return contador;
    }

    public void setColor(Color color){
        color=this.color;
    }

    public static boolean cambioColor(Semaforo si) {
        if (si.getColor() == Color.GREEN) {
            if (si.contador == Color.GREEN.getTiempo()) {
                si.color = Color.AMBERNB;
                si.contador = 0;
            }else{
                aumentarContador(si);
            }
        } else if (si.getColor() == Color.AMBERNB) {
            if (si.contador == Color.AMBERNB.getTiempo()){
                si.color = Color.RED;
                si.contador = 0;
                return false;
            }else{
                aumentarContador(si);
            }
        }
        return true;
    }



    public static int aumentarContador(Semaforo si){
        return si.contador++;
    }

    public static void blink(){
        //if(active){
        //}
    }

}
