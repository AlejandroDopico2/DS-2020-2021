package e2;

import java.util.Iterator;

public class Matrix implements Iterable<Integer> {
    public int [][] matriz;


    public Matrix(int row, int column){
        this.matriz=new int[row][column]; //Inicializamos la matriz
        // Recorrer todas las columnas poniendo su valor a 0 => Iterator
        while(){

        }
    }

    public Matrix(int [][] data){
        int i=0;
        if(data.length != data[i].length){
            throw new IllegalArgumentException("No es rectangular");
        }else{
            this.matriz=new int[data.length][data[0].length]; //Inicializamos la matriz
            //Aquí construimos a matriz usando iterators
        }
    }

    public Iterator<Integer> iteratorRowColumn (){
        return new IteratorRow(matriz);
    }

    public Iterator<Integer> iteratorColumnRow(){
        return new IteratorColumn(matriz);
    }

//    public int getRow() {
//        return row;
//    }
//
//    public int getColumn() {
//        return column;
//    }

    public int getValor(int row, int column){

    }

}
