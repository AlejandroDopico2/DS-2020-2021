package e1;

public class Hobbit extends Heroe {
    Hobbit(String name, int HP, int armor) {
        super(name, HP, armor);
    }

    @Override
    public void Ataque(Dado dado, Personaje rival){

        int dmg = Math.max(dado.Tirada(100), dado.Tirada(100));

        if(rival instanceof Trasgo){
            dmg -= 5;
        }

        rival.damage(dmg);
    }

}
