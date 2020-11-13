package e1;

public class Elfos extends Heroe{
    Elfos(String name, int HP, int armor){
        super(name, HP, armor);
    }

    @Override
    public void Ataque(Dado dado, Personaje rival){

        int dmg = Math.max(Dado.Tirada(100), Dado.Tirada(100));

        if(rival instanceof Orcos){
            dmg -= 10;
        }

        rival.Damage(dmg);
    }
}
