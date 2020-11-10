package e1;
import java.util.Random;

public class Programa {

    public static void main(String arg[ ]) {
        Random rnd = new Random();

        System.out.println("Primera secuencia."+"\n");
        System.out.println(rnd.nextDouble());
        System.out.println(rnd.nextDouble());

        System.out.println("Segunda secuencia."+"\n");
        System.out.println(+rnd.nextDouble());
        System.out.println(rnd.nextDouble());
    }
}
