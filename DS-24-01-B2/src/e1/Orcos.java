package e1;

public class Orcos extends Bestia{
    Orcos(String name, int HP, int armor){
        super(name, HP, armor);
    }

    @Override
    public void Ataque(Dado dado, Personaje rival){

        int dmg = dado.Tirada(90);

        rival.Damage(dmg);
    }


}
