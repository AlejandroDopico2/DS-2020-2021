package e4;

public class Semaforo {
    private static Color color;
    private static Nombre nombre;

    Semaforo(Color color, Nombre nombre) {
        Semaforo.color = color;
        Semaforo.nombre = nombre;
    }

    public static Color getColor(){
        return color;
    }

    public Nombre getNombre(){
        return nombre;
    }


    public static void cambioColor(int i) {
        if (i <= Semaforo.color.getTiempo()) {
            if (Semaforo.getColor() == Color.GREEN) {
                Semaforo.color = Color.AMBER;
            } else if (Semaforo.getColor() == Color.AMBER) {
                Semaforo.color = Color.RED;
            } else {
                Semaforo.color = Color.GREEN;
            }
        }
    }

}
