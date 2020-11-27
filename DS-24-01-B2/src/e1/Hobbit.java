package e1;

public class Hobbit extends Heroe {
    Hobbit(String name, int HP, int armor) {
        super(name, HP, armor);
    }

    @Override
    public void ataque(Dado dado, Personaje rival){

        int dmg = Math.max(dado.tirada(100), dado.tirada(100));

        if(rival instanceof Trasgo){
            dmg -= 5;
        }

        rival.damage(dmg);
    }

}
