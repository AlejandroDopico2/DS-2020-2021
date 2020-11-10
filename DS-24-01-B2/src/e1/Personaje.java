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

    public abstract int calcularDmg();
}
