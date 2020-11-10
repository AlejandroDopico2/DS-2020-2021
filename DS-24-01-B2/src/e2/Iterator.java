package e2;

import java.util.NoSuchElementException;

public interface Iterator<E> {

    /**
     * @return TRUE si la siguiente llamada a next() devolverá un elemento
     */

    public boolean hasNext(){
        return i< Matrix.length &&  j < Matrix.length;
    }


    /**
     * @return el siguiente elemento de la colección
     * @throws NoSuchElementException si no hay ningún elemento que devolver
     */

    public E next(){
        if(this.hasNext())
            return
    }

    /*
        Al ser una matriz, si el ultimo elemento de una fila !hasnext, entonces next = 1ª elemento siguiente columna
     */
}
