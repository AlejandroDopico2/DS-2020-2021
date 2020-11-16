package e2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorMod implements Iterator {
    private final int [][] data;
    private int i, j;
    private int position = 0;

    public IteratorMod(int[][] data){
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        if (i >= data.length)
            return false;
        if (i >= data[i].length && (i >= data.length || i == data.length - 1))
            return false;
        return true;
    }

    @Override
    public Integer next(){
        if(!hasNext())
            throw new NoSuchElementException();
        if(i >= data[i].length){
            i++;
            j = 0;
        }
        return data[i][j++];
    }
}
