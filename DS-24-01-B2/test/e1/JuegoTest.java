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


        Heroe H11 = new Elfo("Legolas", 150, 10);
        Heroe H12 = new Humano("Gandalf", 50, 20);
        Heroe H13 = new Hobbit("Frodo", 20, 0);

        Bestia B11 = new Orco("Lurtz", 190, 20);
        Bestia B12 = new Trasgo("Mauhur", 290, 0);

        EjercitoHTest.add(H11);
        EjercitoHTest.add(H12);
        EjercitoHTest.add(H13);

        EjercitoBTest.add(B11);
        EjercitoBTest.add(B12);

        J.setEjercitoB(EjercitoBTest);
        J.setEjercitoH(EjercitoHTest);
        J.Batalla(Dado);

        ArrayList<Heroe> EjercitoHTest1 = new ArrayList<>();
        ArrayList<Bestia> EjercitoBTest1 = new ArrayList<>();

        Juego K = new Juego();
        DadoTrucado DadoT = new DadoTrucado();

        assertThrows(IllegalArgumentException.class, () -> new Elfo("Voldemort", -50, 50));
        Heroe H21 = new Elfo("Legolas", 150, 10);
        Heroe H22 = new Humano("Gandalf", 50, 20);
        Heroe H23 = new Hobbit("Frodo", 20, 0);

        Bestia B21 = new Orco("Lurtz", 190, 20);
        Bestia B22 = new Trasgo("Mauhur", 290, 0);

        EjercitoHTest1.add(H21);
        EjercitoHTest1.add(H22);
        EjercitoHTest1.add(H23);

        EjercitoBTest1.add(B21);
        EjercitoBTest1.add(B22);

        K.setEjercitoB(EjercitoBTest1);
        K.setEjercitoH(EjercitoHTest1);

        K.Batalla(DadoT);
        assertEquals("BESTIAS WIN!!!", K.Batalla(Dado).get(K.Batalla(Dado).size()-1));

        //Comprobar que funciona el ataque del orco que es especial
        Heroe H31 = new Elfo("Legolas", 150, 10);
        Bestia B31 = new Orco("Lurtz", 190, 20);
        B31.ataque(DadoT, H31);
        assertEquals(107, H31.getHP());

    }
}