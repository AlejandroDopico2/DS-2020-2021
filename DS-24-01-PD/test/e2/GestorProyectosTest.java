package e2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GestorProyectosTest {

    @Test
    public void TrabajadorTest(){
        Proyecto Prueba = new Proyecto("Prueba");
        Equipo Prueba1 = new Equipo("Prueba1");

        Trabajador Antonio = new Trabajador("Antonio", 10);

        assertThrows(IllegalArgumentException.class, () -> new Trabajador("Paco", -5));
        assertEquals(0, Antonio.getHours(Prueba));
        Prueba1.addComponente(Antonio);

        assertThrows(IllegalArgumentException.class, ()->Prueba.addComponent(Antonio)); //Comprobamos que no podemos meter un trabajador que no esté en un equipo
        Prueba.addComponent(Prueba1);
        Antonio.updateHours(30f, Prueba);
        assertEquals(30, Antonio.getHours(Prueba));
        Antonio.updateHours(20f, Prueba);
        assertEquals(50, Antonio.getHours(Prueba));

        assertEquals(500, Antonio.getMoney(Prueba));

        Antonio.updateHours(10f, Prueba);
        assertEquals(60, Antonio.getHours(Prueba));
        assertEquals(600, Antonio.getMoney(Prueba));

        assertTrue(Antonio.pertenece(Prueba));
        assertEquals("Worker Antonio: 60.0 hours, 600.0 €\n", Antonio.infoString(Prueba, 0));
        assertEquals("Antonio", Antonio.getName());
    }

    @Test
    public void EquipoTest(){
        Proyecto Test= new Proyecto("Prueba");
        Equipo Prueba1 = new Equipo("Prueba 1");
        Test.addComponent(Prueba1);
        Trabajador Paco = new Trabajador("Paco", 15);
        Prueba1.addComponente(Paco);
        Paco.updateHours(10f, Test);
        Trabajador Jose = new Trabajador("Jose", 20);
        Prueba1.addComponente(Jose);
        Jose.updateHours(10f, Test);
        Trabajador Manuel = new Trabajador("Manuel", 12);
        Prueba1.addComponente(Manuel);
        Manuel.updateHours(10f, Test);

        Equipo Prueba2 = new Equipo("Prueba 2");
        Test.addComponent(Prueba2);
        Trabajador Rosa = new Trabajador("Rosa", 10);
        Prueba2.addComponente(Rosa);
        Rosa.updateHours(20f, Test);

        Prueba1.addComponente(Prueba2);

        assertEquals("Prueba 1", Prueba1.getName());
        assertEquals(50, Prueba1.getHours(Test));
        assertEquals(20, Prueba2.getHours(Test));
        assertEquals(670, Prueba1.getMoney(Test));

        assertTrue(Prueba1.contiene(Prueba2));
        assertFalse(Prueba2.contiene(Prueba1));
        assertTrue(Prueba1.pertenece(Test));
        assertTrue(Prueba1.pertenece(Test));
    }

    @Test
    public void ProyectoTest(){
        Proyecto DS = new Proyecto("DS");

        Equipo Teaching = new Equipo ("Teaching");
        Equipo Theory = new Equipo ("Theory");
        Equipo Practicum = new Equipo ("Practicum");

        Trabajador Edu = new Trabajador("Edu", 25);
        Teaching.addComponente(Edu);
        Edu.updateHours(20f, DS);
        Trabajador David = new Trabajador("David", 18);
        Theory.addComponente(David);
        David.updateHours(10f, DS);
        Teaching.addComponente(Theory);

        Trabajador Juan = new Trabajador("Juan", 15);
        Practicum.addComponente(Juan);
        Juan.updateHours(60f, DS);
        Trabajador Bea = new Trabajador("Bea", 20);
        Practicum.addComponente(Bea);
        Bea.updateHours(50f, DS);
        Trabajador Laura = new Trabajador("Laura", 12);
        Practicum.addComponente(Laura);
        Laura.updateHours(40f, DS);
        Teaching.addComponente(Practicum);

        DS.addComponent(Teaching);

        System.out.println(DS.StringProyecto());
        assertEquals("Los cotrabajadores de Juan en el proyecto DS son: Edu, David, Bea, Laura.", Juan.mates(DS));
        assertEquals("Los cotrabajadores del Team Practicum en el proyecto DS son: Edu, David.", Practicum.mates(DS));

        Equipo Aleatorio = new Equipo("Aleatorio");
        assertEquals("Aleatorio no pertenece al proyecto DS", Aleatorio.mates(DS));

        Trabajador fake = new Trabajador("fake", 20);
        assertEquals("fake no pertenece al proyecto DS", fake.mates(DS));

        assertThrows(UnsupportedOperationException.class, ()->DS.addComponent(Teaching));
    }

}
