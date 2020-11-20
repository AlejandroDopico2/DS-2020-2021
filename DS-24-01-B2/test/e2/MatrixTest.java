package e2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {
    public static int[][] m1 = {{0,0,0},
                                {0,0,0},
                                {0,0,0}};

    public static int[][] m2 = {{1}};

    public static int[][] m3
            = {{1, 2},
            {3, 4}};

    public static int[][] m4
            = {{1, 2, 3},
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
//        for(int i = 0; i < 3; i ++){
//            for(int j = 0; j < 3; j++){
//                assertEquals(0, m.getValor(i, j));
//            }
//        }

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

        m = new Matrix(m2);
//        for(int i = 0; i < m.getRow(); i ++){
//            for(int j = 0; j < m.getColumn(); j++){
//                assertEquals(m2[i][j], m.geti, j););
//            }
//        }

        int[][] mNoRectangular = {{0, 1, 2},
                                  {3, 4},
                                  {5, 6, 7}};
        assertThrows(IllegalArgumentException.class, () -> new Matrix(mNoRectangular));

        int[][] mNoRectangular2 =   {{0, 1},
                                    {2, 3, 4},
                                    {5, 6, 7}};
        assertThrows(IllegalArgumentException.class, () -> new Matrix(mNoRectangular2));

        int[][] mNoRectangular3 =   {{0, 1},
                                    {2, 3},
                                    {4}};
        assertThrows(IllegalArgumentException.class, () -> new Matrix(mNoRectangular3));

        

    }
}