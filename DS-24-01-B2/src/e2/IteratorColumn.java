package e2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorColumn implements Iterator<Integer> {
    private final int [][] data;
    private int i, j;

    public IteratorColumn(int[][] data){
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        if (i >= data.length)
            return false;
        return j < data[i].length || j != data.length - 1;
    }

    @Override
    public Integer next(){
        if(!hasNext())
            throw new NoSuchElementException();
        else if(i >= data.length) {
            j++;
            i=0;

        }
        return data[i++][j];
    }
}

