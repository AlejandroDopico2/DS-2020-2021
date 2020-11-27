package e1;

 abstract class Bestia extends Personaje {
    Bestia(String name, int HP, int armor) { super(name, HP, armor); }

     public void ataque (Dado Dado, Personaje rival){
        int dmg = Dado.tirada(90);
        rival.damage(dmg);
    }
 }