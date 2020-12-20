package e2;


public interface Componente {
    String printInfo(Proyecto proyecto);
    String getName();
    float getMoney(Proyecto proyecto);
    float getHours(Proyecto proyecto);
    void inicializarHash(Proyecto p);
    //public String mates (Proyecto p);
    boolean pertenece (Proyecto p);
}
