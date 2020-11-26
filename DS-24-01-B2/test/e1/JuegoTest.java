package e1;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;


class JuegoTest {

    @Test
    public void BatallaTest() {
        ArrayList<Heroe> EjercitoHTest = new ArrayList<>();
        ArrayList<Bestia> EjercitoBTest = new ArrayList<>();

        Dado Dado = new Dado();
        Juego J = new Juego();

        J.setEjercitoB(EjercitoBTest);
        J.setEjercitoH(EjercitoHTest);
        assertThrows(IllegalArgumentException.class, () -> J.Batalla(Dado));

        Heroe H11 = new Elfos("Legolas", 150, 10);
        Heroe H12 = new Humanos("Gandalf", 50, 20);
        Heroe H13 = new Hobbits("Frodo", 20, 0);

        Bestia B11 = new Orcos("Lurtz", 190, 20);
        Bestia B12 = new Trasgo("Mauhur", 290, 0);

        EjercitoHTest.add(H11);
        EjercitoHTest.add(H12);
        EjercitoHTest.add(H13);

        EjercitoBTest.add(B11);
        EjercitoBTest.add(B12);

        J.setEjercitoB(EjercitoBTest);
        J.setEjercitoH(EjercitoHTest);

        assertEquals("Heroes Win", J.Winner());

        ArrayList<Heroe> EjercitoHTest1 = new ArrayList<>();
        ArrayList<Bestia> EjercitoBTest1 = new ArrayList<>();

        Juego K = new Juego();
        DadoTrucado DadoT = new DadoTrucado();

        Heroe H21 = new Elfos("Legolas", 150, 10);
        Heroe H22 = new Humanos("Gandalf", 50, 20);
        Heroe H23 = new Hobbits("Frodo", 20, 0);

        Bestia B21 = new Orcos("Lurtz", 190, 20);
        Bestia B22 = new Trasgo("Mauhur", 290, 0);

        EjercitoHTest1.add(H23);
        EjercitoHTest1.add(H22);
        EjercitoHTest1.add(H23);

        EjercitoBTest1.add(B21);
        EjercitoBTest1.add(B22);

        J.setEjercitoB(EjercitoBTest1);
        J.setEjercitoH(EjercitoHTest1);

        K.Batalla(DadoT);

    }
}