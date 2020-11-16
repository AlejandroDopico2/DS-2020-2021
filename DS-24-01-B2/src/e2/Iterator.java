//package e2;
//
//import java.util.NoSuchElementException;
//
//public interface Iterator<E> {
//
//    private int position = 0;
//
//    public boolean hasNext() {
//        if(i >= data.length )
//            return false;
//
//        if(j >= data[i].length && (i >= data.length || i == i.length -1))
//            return false;
//
//        return true;
//    }
//
//    public T next(){
//        if(!hasNext())
//            throw new NoSuchElementException();
//        if(i >= data[i].length){
//            i++;
//            j = 0;
//        }
//        return data[i][j++];
//    }
//
//
//
//
//    /**
//     * @return el siguiente elemento de la colección
//     * @throws NoSuchElementException si no hay ningún elemento que devolver
//     */
////
////    public E next(){
////
////    }
//
//    /*
//        Al ser una matriz, si el ultimo elemento de una fila !hasnext, entonces next = 1ª elemento siguiente columna
//     */
//}
