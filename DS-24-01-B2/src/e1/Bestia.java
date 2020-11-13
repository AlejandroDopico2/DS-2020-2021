package e1;

 abstract class Bestia extends Personaje {
    Bestia(String name, int HP, int armor) { super(name, HP, armor); }

     public void Ataque (Dado Dado, Personaje rival){
        int dmg = Dado.Tirada(90);

        rival.Damage(dmg);
    }
 }