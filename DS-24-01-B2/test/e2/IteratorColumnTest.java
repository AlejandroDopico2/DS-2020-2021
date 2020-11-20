package e2;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class IteratorColumnTest {
    public void testGetData() {
        int[] fila1 = {0, 1, 2, 3};
        int[] fila2 = {4, 5, 6, 7};
        int[] fila3 = {8, 9, 10, 11};
        int[] fila4 = {12, 13, 14, 15};
        int[][] data = {fila1, fila2, fila3, fila4};
        IteratorColumn test = new IteratorColumn(data);
        int i = 0;
        while (test.hasNext()) {
            int dato = test.next();
            assertEquals(i++,dato);
        }
    }

    @Test
    public void testNoSuchElementException() {
        int[] fila1 = {0};
        int[] fila2 = {1};
        int[][] data = {fila1, fila2};
        IteratorRow test = new IteratorRow(data);
        assertEquals(test.next(), 0);
        assertEquals(test.next(), 1);
        assertFalse(test.hasNext());
        try{
            test.next();
        } catch (NoSuchElementException ignored){}
    }

    @Test
    public void testReturnFalseForEmptyDataset() {
        int[][] data = new int[0][0];
        IteratorRow test = new IteratorRow(data);
        assertFalse(test.hasNext());
    }

}