package e2;

import java.util.HashMap;

public class Trabajador implements Componente{
    private final String name;
    private final int moneyperhour;
    private int hours=0;
    //HAY QUE ALMACENAR PARES DE PROYECTO Y HORAS DE TRABAJO PARA CADA TRABAJADOR. SENDO PORRO SE ACABAN DE FUMAR
    HashMap<String, Integer> horasProyecto = new HashMap<>();


    public Trabajador(String name, int moneyperhour) {
        this.name = name;
        this.moneyperhour = moneyperhour;
    }

    public void updatehours(int hours, Proyecto porros){
        horasProyecto.put(porros.getName(), hours);
    }

    @Override
    public String printInfo(Proyecto proyecto) {
        StringBuilder info = new StringBuilder();
        info.append("Worker ").append(name).append(": ").append(getHours(proyecto)).append(" hours, ").append(getMoney(proyecto)).append(" €\n");
        return info.toString();
    }

    @Override
    public int getMoney(Proyecto proyecto) {
        return getHours(proyecto)*moneyperhour;
    }

    @Override
    public int getHours(Proyecto proyecto) {
        return horasProyecto.get(proyecto.getName());
    }
    /*Hay un proyecto.
    Cada proyecto tiene equipos; tine nombre finales Done
    Cada equipo tiene trabajadores Done
    Cada trabajador tiene  tine nombre y coste por hora finales Done
    Al finalizar la jornada se contabilizan las horas que ha invertido cada trabajador en cada proyecto
    Podemos obtener horas invertidas o coste total que ha supuesto un trabador para el proyecto
    Un equipo puede tener subequipos Done
    Cada trabajor o equipo puede trabajar en varios equipos a la vez Not
    String con la información del trabajador: nombre, horas invertidas, coste total del trabajador Done
    Un trabajador no puede pertenecer a dos equipos diferentes Not
    Los equipos tienen un nombre. De cada equipo interesan horas invertidas por todos los trabajadores y el coste total de todos ellos para un proyecto dado Done
    A mayores, se podran obtener los cotrabajadores de un equipo o de un trabajador (todos los que participan en el mismo proyecto)
     */
}
