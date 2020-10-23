package e4;

public enum Semaforo {
    NORTH(Nombre.NORTH, Color.GREEN, 0),
    SOUTH(Nombre.SOUTH, Color.RED, 0),
    EAST(Nombre.EAST, Color.RED, 0),
    WEST(Nombre.WEST, Color.RED, 0);

    private final Nombre nombre;
    private Color color;
    private int contador;

    Semaforo(Nombre nombre, Color color, int contador) {
        this.nombre = nombre;
        this.color = color;
        this.contador = contador;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Color getColor() {
        return color;
    }

    public int getContador() {
        return contador;
    }

    public static void cambioColor (Semaforo si, boolean active) {
        if (active) {
            si.color = Color.AMBERB;
        } else {
            if (si.getColor() == Color.AMBERNB) {
                if (si.contador == Color.AMBERNB.getTiempo()) {
                    si.color = Color.RED;
                    si.contador = 0;
                    if (si.nombre == Nombre.NORTH) {
                        Semaforo.SOUTH.color = Color.GREEN;
                        Semaforo.SOUTH.contador--;
                    } else if (si.nombre == Nombre.SOUTH) {
                        Semaforo.EAST.color = Color.GREEN;
                        Semaforo.EAST.contador--;
                    } else if (si.nombre == Nombre.EAST) {
                        Semaforo.WEST.color = Color.GREEN;
                        Semaforo.WEST.contador--;
                    } else {
                        Semaforo.NORTH.color = Color.GREEN;
                        Semaforo.NORTH.contador--;
                    }
                } else
                    aumentarContador(si);
            } else if(si.getColor() == Color.GREEN){
                if(si.contador == Color.GREEN.getTiempo()){
                    si.color = Color.AMBERNB;
                    si.contador = 0;
                } else
                    aumentarContador(si);
            }
        }
    }

    public static void aumentarContador(Semaforo si) {
        si.contador++;
    }

    public static void resetJunction() {
        for (Semaforo semaforo : values()) {
            if (semaforo.nombre == Nombre.NORTH) {
                semaforo.color = Color.GREEN;
            } else
                semaforo.color = Color.RED;
            semaforo.contador = 0;
        }
    }
}