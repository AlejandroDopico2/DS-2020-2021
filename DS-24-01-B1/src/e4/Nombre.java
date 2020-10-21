package e4;

public enum Nombre {
    NORTH(1),
    EAST(2),
    SOUTH(3),
    WEST(4);

    private final int indice;

    Nombre(int indice){
        this.indice=indice;
    }

    public int getIndice(){ return indice; }

    public boolean cambioNombre(int i){
        return i < this.indice;
    }
}
