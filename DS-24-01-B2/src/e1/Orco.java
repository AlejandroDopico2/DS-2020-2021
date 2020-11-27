package e1;

public class Orco extends Bestia{
    Orco(String name, int HP, int armor){
        super(name, HP, armor);
    }

    @Override
    public void Ataque(Dado dado, Personaje rival){
        int dmg = dado.Tirada(90);
        int armorOriginal = rival.getArmor();
        int tmp = (int) (armorOriginal*0.9);
        rival.setArmor(tmp);
        rival.damage(dmg);
        rival.setArmor(armorOriginal);
    }
}
