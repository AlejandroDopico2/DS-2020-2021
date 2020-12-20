package e1;

public interface EstadoTermostato {

     void offMode(Termostato t);
     void manualMode(Termostato t);
     void programMode(Termostato t, float tempP);
     void timerMode(Termostato t, int time);
     void infoEstado(Termostato t);
}
