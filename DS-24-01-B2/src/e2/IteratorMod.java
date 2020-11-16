package e2;

import java.util.Iterator;

public class IteratorMod implements Iterator<Integer> {
    int [][] matriz;
    public IteratorMod(int [][] matriz){
        this.matriz = matriz;
    }
    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Integer next() {
        return null;
    }
}
