package e2;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {
    public static int[][] m1 = {{1}};

    public static int[][] m2
            = {{1, 2},
            {3, 4}};

    public static int[][] m3 =
            {{1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}};

    @Test
    void rowColumnConstructor(){
        Matrix m = new Matrix(1,1);
        assertEquals(1, m.getRow());
        assertEquals(1, m.getColumn());

        m = new Matrix(3,3);
        assertEquals(3, m.getRow());
        assertEquals(3, m.getColumn());

        for(int i = 0; i < m.getRow(); i ++){
            for(int j = 0; j < m.getColumn(); j++){
                assertEquals(0, m.getValor(i, j));
            }
        }

        m = new Matrix(4,1);
        assertEquals(4, m.getRow());
        assertEquals(1, m.getColumn());

        m = new Matrix(1,4);
        assertEquals(1, m.getRow());
        assertEquals(4, m.getColumn());
        
        assertThrows(IllegalArgumentException.class, () -> new Matrix(0, 0));
        assertThrows(IllegalArgumentException.class, () -> new Matrix(-1, -1));
        assertThrows(IllegalArgumentException.class, () -> new Matrix(2, -1));
        assertThrows(IllegalArgumentException.class, () -> new Matrix(-1, 2));

        int[][] mNoRectangular = {{0, 1, 2}, {3, 4}, {5, 6, 7}};
        assertThrows(IllegalArgumentException.class, () -> new Matrix(mNoRectangular));

        int[][] mNoRectangular2 =   {{0, 1}, {2, 3, 4}, {5, 6, 7}};
        assertThrows(IllegalArgumentException.class, () -> new Matrix(mNoRectangular2));

        int[][] mNoRectangular3 =   {{0, 1}, {2, 3}, {4}};
        assertThrows(IllegalArgumentException.class, () -> new Matrix(mNoRectangular3));

        int[][] mNoRectangular4 =   {{0}, {1,2}, {3,4,5}};
        assertThrows(IllegalArgumentException.class, () -> new Matrix(mNoRectangular4));

        assertThrows(IllegalArgumentException.class, ()-> new Matrix(null));

        int[][] wrongNull2 = {{1, 2, 3}, null, {7, 8, 9}};
        assertThrows(IllegalArgumentException.class, () -> new Matrix(wrongNull2));

        m = new Matrix(m1);

        int aux = 1;
        for (int i = 0; i < m.getRow(); i++) {
            for (int j = 0; j < m.getColumn(); j++) {
                assertEquals(aux++, m.getValor(i, j));
            }
        }

        m = new Matrix(m2);

        aux = 1;
        for (int i = 0; i < m.getRow(); i++) {
            for (int j = 0; j < m.getColumn(); j++) {
                assertEquals(aux++, m.getValor(i, j));
            }
        }

        m = new Matrix(m3);

        aux = 1;
        for (int i = 0; i < m.getRow(); i++) {
            for (int j = 0; j < m.getColumn(); j++) {
                assertEquals(aux++, m.getValor(i, j));
            }
        }
    }

    @Test
    void ModMatrix(){
        Matrix m = new Matrix(3, 3);

        int aux = 0;
        for(int i = 0; i < m.getRow(); i ++){
            for(int j = 0; j < m.getColumn(); j++){
                m.setValor(i, j, aux);
                assertEquals(aux++, m.getValor(i, j));
            }
        }

        assertThrows(IllegalArgumentException.class, () -> m.setValor(4, 1, 2));
        assertThrows(IllegalArgumentException.class, () -> m.setValor(1, 4, 2));
        assertThrows(IllegalArgumentException.class, () -> m.setValor(-2, 2, 2));
        assertThrows(IllegalArgumentException.class, () -> m.setValor(2, -2, 2));

    }

    @Test
    public void getData() {
        int[] columna1 = {0, 4, 8, 12};
        int[] columna2 = {1, 5, 9, 13};
        int[] columna3 = {2, 6, 10, 14};
        int[] columna4 = {3, 7, 11, 15};
        int[][] data1 = {columna1, columna2, columna3, columna4};
        IteratorColumn testC = new IteratorColumn(data1);
        int j = 0;
        while (testC.hasNext()) {
            int dato = testC.next();
            assertEquals(j++,dato);
        }

        int[] fila1 = {0, 1, 2, 3};
        int[] fila2 = {4, 5, 6, 7};
        int[] fila3 = {8, 9, 10, 11};
        int[] fila4 = {12, 13, 14, 15};
        int[][] data2 = {fila1, fila2, fila3, fila4};
        IteratorRow testR = new IteratorRow(data2);
        j = 0;
        while (testR.hasNext()) {
            int dato = testR.next();
            assertEquals(j++,dato);
        }
    }

    @Test
    public void testException() {
        int[] columna1 = {0};
        int[] columna2 = {1};
        int[][] data1 = {columna1, columna2};
        IteratorColumn testC = new IteratorColumn(data1);
        assertEquals(testC.next(), 0);
        assertEquals(testC.next(), 1);
        assertFalse(testC.hasNext());
        try{
            testC.next();
        } catch (NoSuchElementException ignored){}

        int[] fila1 = {0};
        int[] fila2 = {1};
        int[][] data2 = {fila1, fila2};
        IteratorRow testR = new IteratorRow(data2);
        assertEquals(testR.next(), 0);
        assertEquals(testR.next(), 1);
        assertFalse(testR.hasNext());
        try{
            testR.next();
        } catch (NoSuchElementException ignored){}
    }



    @Test
    public void emptyMatrix() {
        int[][] data1 = new int[0][0];
        IteratorColumn testC = new IteratorColumn(data1);
        assertFalse(testC.hasNext());

        int[][] data2 = new int[0][0];
        IteratorRow testR = new IteratorRow(data2);
        assertFalse(testR.hasNext());
    }

//    @Test
//    public void getStringTest(){
//        assertEquals("[0	1	][2 4	]", m2.getString() );
//    }
}