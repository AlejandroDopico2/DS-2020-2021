package e2;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class IteratorColumnTest {
    @Test
    public void testGetData() {
        int[] columna1 = {0, 4, 8, 12};
        int[] columna2 = {1, 5, 9, 13};
        int[] columna3 = {2, 6, 10, 14};
        int[] columna4 = {3, 7, 11, 15};
        int[][] data = {columna1, columna2, columna3, columna4};
        IteratorColumn test = new IteratorColumn(data);
        int j = 0;
        while (test.hasNext()) {
            int dato = test.next();
            assertEquals(j++,dato);
        }
    }

    @Test
    public void testNoSuchElementException() {
        int[] columna1 = {0};
        int[] columna2 = {1};
        int[][] data = {columna1, columna2};
        IteratorColumn test = new IteratorColumn(data);
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
        IteratorColumn test = new IteratorColumn(data);
        assertFalse(test.hasNext());
    }

}