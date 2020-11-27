package e2;

import java.util.Arrays;
import java.util.Iterator;

public class Matrix implements Iterable<Integer>{
    private int [][] matriz;
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
            return this.columnRowIterator();
        }
    }

    public Iterator<Integer> rowColumnIterator(){
        return new IteratorRow(this.matriz);
    }

    public Iterator<Integer> columnRowIterator(){
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

    public int[][] getCopy() {
        int[][] mCopy = new int [this.matriz.length][this.matriz[0].length];
        for (int i = 0; i < this.getRow(); i++) {
            System.arraycopy(matriz[i], 0, mCopy[i], 0, this.matriz[0].length);
        }
        return mCopy;
    }

    public int[][] getMatriz() {
        return matriz;
    }

    public String getRowOrColumn (int n, boolean who){
        if(n >= matriz.length || n >= matriz[0].length || n < 0)
            throw new IllegalArgumentException("Nº de fila o de columna inválido");
        else {
            StringBuilder copia = new StringBuilder();
            copia.append("[");
            for (int i = 0; i < this.matriz.length; i++) {
                for (int j = 0; j < this.matriz[i].length; j++) {

                    if(who && i == n) { // Si es verdadero copia una fila
                        copia.append(this.matriz[i][j]);
                        copia.append("\t");
                    } else if (!who && j == n ) {
                        copia.append(this.matriz[i][j]);
                        copia.append("\t");
                    }
                }
            }
            copia.append("]");
            copia.append("\n");
            return copia.toString();
        }
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

    public void setWho(boolean who) {
        this.who = who;
    }
}
