package e2;

import java.util.Iterator;

public class Matrix implements Iterable<Integer>{
    public int [][] matriz;
    boolean who;


    public Matrix(int row, int column){
        if(row < 1 || column < 1)
            throw new IllegalArgumentException("Nº de filas y/o columnas incorrecto");
        this.matriz=new int[row][column]; //Inicializamos la matriz
        for(int f=0;f<row;f++){
            for (int c=0;c<column;c++){
                matriz[f][c]=0;
            }
        }
    }

    public Matrix(int [][] data){
        if(!isMatrixValid(data)){
            throw new IllegalArgumentException("No es rectangular");
        }else{
            this.matriz=new int[data.length][data[0].length]; //Inicializamos la matriz
            for(int f=0;f<data.length;f++){
                System.arraycopy(data[f], 0, matriz[f], 0, data[0].length);
            }
        }
    }

    public boolean isMatrixValid (int [][] data){
        int i = 0;

        if(data == null)
            return false;

        while (i < data.length) {
            if ( data[i] == null || data[0].length != data[i].length)
                return false;
            i++;
        }
        return true;
    }

    @Override
    public Iterator<Integer> iterator(){
        if(this.who){
            return this.rowColumnIterator();
        }else{
            return this.ColumnRowIterator();
        }
    }

    public Iterator<Integer> rowColumnIterator(){
        return new IteratorRow(this.matriz);
    }

    public Iterator<Integer> ColumnRowIterator(){
       return new IteratorColumn(this.matriz);
    }

    public int getRow() {
        return this.matriz.length;
    }

    public int getColumn() {
        return this.matriz[0].length;
    }

    public int getValor (int row, int column){
        return matriz[row][column];
    }

    public void setValor(int row, int column, int valor){
        if(row >= this.matriz.length || row < 0 || column >= this.matriz[0].length || column < 0){
            throw new IllegalArgumentException("Nº de filas y/o columnas incorrecto");
        }else
            matriz[row][column]=valor;
    }

    public int[][] getMatriz() {
        return matriz;
    }

    public int[][] getCopy() {
        return matriz;
    }

    public String getString(){
        StringBuilder m = new StringBuilder();
        for (int[] ints : this.matriz) {
            m.append("[");
            for (int anInt : ints) {
                m.append(anInt);
                m.append("\t");
            }
            m.append("]\n");
        }
        return m.toString();
    }
    public static void main (String [] args){
        int[] fila1 = {0, 1, 2};
        int[] fila2 = {3, 4, 5};
        int[] fila3 = {6, 7, 8};
        int[][] data = {fila1, fila2, fila3};
        Matrix matriz=new Matrix(data);
        System.out.println(matriz.getString());
    }

}
