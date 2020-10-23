package e4;

public enum Semaforo {
    S1(Nombre.NORTH, Color.GREEN, 0),
    S2(Nombre.SOUTH, Color.RED, 0),
    S3(Nombre.EAST, Color.RED, 0),
    S4(Nombre.WEST, Color.RED, 0);

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

    public static void cambioColor (Semaforo sem, boolean active) {
        if (active) {
            sem.color = Color.AMBERB;
        } else {
            if (sem.getColor() == Color.AMBERNB) {
                if (sem.contador == Color.AMBERNB.getTiempo()) {
                    sem.color = Color.RED;
                    sem.contador = 0;
                    switch(sem.nombre){
                        case NORTH :
                            Semaforo.S2.color = Color.GREEN;
                            Semaforo.S2.contador--;
                            break;
                        case SOUTH :
                            Semaforo.S3.color = Color.GREEN;
                            Semaforo.S3.contador--;
                            break;
                        case EAST :
                            Semaforo.S4.color = Color.GREEN;
                            Semaforo.S4.contador--;
                            break;
                        case WEST:
                            Semaforo.S1.color = Color.GREEN;
                            Semaforo.S1.contador--;
                            break;
                        }
                } else {
                    aumentarContador(sem);
                }
            } else if(sem.getColor() == Color.GREEN){
                if(sem.contador == Color.GREEN.getTiempo()){
                    sem.color = Color.AMBERNB;
                    sem.contador = 0;
                } else
                    aumentarContador(sem);
            }
        }
    }

    public static void aumentarContador(Semaforo si) {
        si.contador++;
    }

    public static void resetJunction() {
        for (Semaforo semaforo : Semaforo.values()) {
            if (semaforo.nombre == Nombre.NORTH) {
                semaforo.color = Color.GREEN;
            } else
                semaforo.color = Color.RED;
            semaforo.contador = 0;
        }
    }
}