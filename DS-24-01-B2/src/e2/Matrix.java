package e2;

public class Matrix {
    private final int row;
    private final int column;



    public Matrix(int row, int column){
        this.row = row;
        this.column = column;
        // Recorrer todas las columnas poniendo su valor a 0 => Iterator
    }

    public Matrix(int [][]matrix){

    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }


}
