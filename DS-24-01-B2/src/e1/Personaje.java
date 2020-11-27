package e1;

public abstract class Personaje {

    private final String Name;
    private int HP;
    private final int Armor;

    Personaje(String name, int HP, int armor) {
        this.Name = name;
        this.HP = HP;
        this.Armor = armor;

        if(this.HP <= 0 || this.Armor < 0)
            throw new IllegalArgumentException("Atributos no válidos");
    }

    public void damage(int damage){
        if(damage>getArmor()){
            this.HP=HP - (damage - getArmor());
        }
    }

    public String getName() {
        return Name;
    }

    public int getHP() {
        return HP;
    }

    public int getArmor() {
        return Armor;
    }
}
