package e2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

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
    void ConstructorTest(){
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
    public void copyMatrix() {
        Matrix m = new Matrix(m3);
        int [][]copia = m.getCopy();

        for (int i = 0; i < m.getRow(); i++) {
            for (int j = 0; j < m.getColumn(); j++) {
                assertEquals(m3[i][j], copia[i][j]);
            }
        }
    }

    @Test
    public void getRowColumn (){
        Matrix m = new Matrix(m3);
        assertEquals("[1\t2\t3\t]\n", m.getRowOrColumn(0, true));
        assertEquals("[1\t4\t7\t]\n", m.getRowOrColumn(0, false));
        assertThrows(IllegalArgumentException.class, () -> m.getRowOrColumn(-1, true));
        assertThrows(IllegalArgumentException.class, () -> m.getRowOrColumn(3, true));

    }

    @Test
    public void getStringTest(){
        Matrix m = new Matrix(m2);
        assertEquals("[1\t2\t]\n" + "[3\t4\t]\n", m.getString() );
    }

    @Test
    public void MatrixAddition(){
        int[][] data = {{0, 1},{2, 3}};
        Matrix m1= new Matrix(data);
        Matrix m2= new Matrix(data);
        MatrixAddition Addition = new MatrixAddition();

        Matrix suma = Addition.Addition(m1, m2, true);
        assertEquals("[0\t2\t]\n" + "[4\t6\t]\n", suma.getString());

        Matrix suma2 = Addition.Addition(m1, m2, false);
        assertEquals("[0\t2\t]\n" + "[4\t6\t]\n", suma2.getString());

        IteratorColumn iC = new IteratorColumn(data);
        IteratorRow iR = new IteratorRow(data);

        int[][] data2 = {{0,1}};
        Matrix m3 = new Matrix(data2);
        MatrixAddition Addition2 = new MatrixAddition();

        assertThrows(ArithmeticException.class,() -> Addition2.Addition(m1, m3, true));

        assertThrows(UnsupportedOperationException.class, iC::remove);
        assertThrows(UnsupportedOperationException.class, iR::remove);

    }
}