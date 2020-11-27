package e1;

public class Elfo extends Heroe{
    Elfo(String name, int HP, int armor){
        super(name, HP, armor);
    }

    @Override
    public void Ataque(Dado dado, Personaje rival){

        int dmg = Math.max(dado.Tirada(100), dado.Tirada(100));

        if(rival instanceof Orco){
            dmg += 10;
        }

        rival.damage(dmg);
    }
}
