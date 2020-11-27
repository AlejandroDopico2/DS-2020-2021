package e2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorRow implements Iterator<Integer> {
    private final int [][] data;
    private int i, j;

    public IteratorRow(int[][] data){
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        return !((j==data[1].length) && (i==data.length));
    }

    @Override
    public Integer next(){
        if(!hasNext())
            throw new NoSuchElementException();
        else if(j >= data[i].length) {
            i++;
            j=0;
        }
        return data[i][j++];
    }

    @Override
    public void remove(){
        throw new UnsupportedOperationException("Metodo remove es ilegal");
    }
}

