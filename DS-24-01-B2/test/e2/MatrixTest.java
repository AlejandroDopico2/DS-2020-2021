package e2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {

    @Test
    void rowColumnConstructor(){
        Matrix m = new Matrix(0,0);
        assertEquals(0, m.getRow());
        assertEquals(0, m.getColumn());


        m = new Matrix(2,2);
        assertEquals(2, m.getRow());
        assertEquals(2, m.getColumn());

        m = new Matrix(4,1);
        assertEquals(4, m.getRow());
        assertEquals(1, m.getColumn());

        m = new Matrix(5,5);
        assertEquals(5, m.getRow());
        assertEquals(5, m.getColumn());

        assertThrows(IllegalArgumentException.class, () -> new Matrix(-1, -1));
    }
}