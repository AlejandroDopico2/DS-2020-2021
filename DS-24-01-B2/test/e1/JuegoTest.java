package e1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class JuegoTest {
    DadoTrucado Dado1 = new DadoTrucado();
    Juego J = new Juego();

    Heroe H1 = new Elfos("Jose", 100, 30);
    Heroe H2 = new Humanos("Pedro", 180, 20);
    Heroe H3 = new Hobbits("Alfonso", 30, 20);

    Bestia B1 = new Orcos("Pancracio", 190, 20);
    Bestia B2 = new Trasgo("Mario", 130, 0);

    ArrayList<Heroe> EjercitoH = new ArrayList<>();
    ArrayList<Bestia> EjercitoB = new ArrayList<>();

//    EjercitoH.add(H1);
//    EjercitoH.add(H2);
//    EjercitoH.add(H3);
//
//    EjercitoB.add(B1);
//    EjercitoB.add(B2);
//
//    Batalla(Dado1);
// Da error y no entiendo



}