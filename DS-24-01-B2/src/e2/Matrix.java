package e2;

import java.util.Iterator;

public class Matrix {
    public int [][] matriz;


    public Matrix(int row, int column){
        this.matriz=new int[row][column]; //Inicializamos la matriz
        for(int f=0;f<row;f++){
            for (int c=0;c<column;c++){
                matriz[f][c]=0;
            }
        }

    }

    public Matrix(int [][] data){
        int i=0;
        if(data.length != data[i].length){
            throw new IllegalArgumentException("No es rectangular");
        }else{
            this.matriz=new int[data.length][data[0].length]; //Inicializamos la matriz
            //Aquí construimos a matriz usando iterators
            for(int f=0;f<data.length;f++){
                System.arraycopy(data[f], 0, matriz[f], 0, data[0].length);
            }
        }
    }

    public Iterator<Integer> iterator(boolean who){
        if(who){
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

    public void setValor(int row, int column, int valor){
    if(row<this.matriz.length){
        throw new IllegalArgumentException("SI soy");
    }else if(column <this.matriz[0].length){
        throw new IllegalArgumentException("SI soy");
    }else{
        for(int f=0;f<row;f++){
            for (int c=0;c<column;c++){
                matriz[f][c]=valor;
            }
        }
    }
    }

    public int[][] getMatriz() {
        return matriz;
    }

    public int[][] getCopy() {
        return matriz;
    }

    public String getString(){
        StringBuilder m = new StringBuilder();
            for(int f=0;f<this.matriz.length;f++){
                m.append("[");
                for (int c=0;c<this.matriz[f].length;c++){
                    m.append(this.matriz[f][c]);
                    m.append("\t");
                }
                m.append("]\n");
            }
        return m.toString();
    }
    public static void main (String [] args){
        int[] fila1 = {0, 1, 2, 3};
        int[] fila2 = {4, 5, 6, 7};
        int[] fila3 = {8, 9, 10, 11};
        int[] fila4 = {12, 13, 14, 15};
        int[][] data = {fila1, fila2, fila3, fila4};
        Matrix matriz=new Matrix(data);
        System.out.println(matriz.getString());
    }

}
