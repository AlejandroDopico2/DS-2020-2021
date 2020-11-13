package e1;

public class Elfos extends Heroe{
    Elfos(String name, int HP, int armor){
        super(name, HP, armor);
    }

    @Override
    public void Ataque(DadoTrucado dado, Personaje rival){

        int dmg = Math.max(dado.Tirada(100), dado.Tirada(100));

        if(rival instanceof Orcos){
            dmg -= 10;
        }

        rival.Damage(dmg);
    }
}
