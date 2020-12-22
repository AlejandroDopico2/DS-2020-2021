package e2;


public interface Componente {
    String infoString(Proyecto proyecto, int recursivo); //Devuelve en un String el nombre, sueldo, y horas del componente
    String getName(); //Devuelve el nombre del componente
    float getMoney(Proyecto proyecto); //Devuelve el sueldo del componente
    float getHours(Proyecto proyecto); //Devuelve las horas que dedicó el componente a un proyecto
    void inicializarHash(Proyecto proyecto);  //Inicializa a cero el hash de los trabajadores cuando estos se incluyen en un proyecto(Función más que nada auxiliar)
    String mates (Proyecto proyecto); //Devuelve los cotrabajadores del componente
    boolean pertenece (Proyecto proyecto); //Devuelve si un componente pertenece a un proyecto
}
