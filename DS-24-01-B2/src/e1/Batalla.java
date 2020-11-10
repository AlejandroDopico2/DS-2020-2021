package e1;

import java.util.Random;

public class Batalla {

    private final Random r = new Random();

    public int calculateDamage (){
        persona.damage(r.nextInt(101));
        persona.damage(r.nextInt(101));

    }
}
