package e2;

public class Matrix {
    private int [][] matriz;


    public Matrix(int row, int column){
        // Recorrer todas las columnas poniendo su valor a 0 => Iterator
    }

    public Matrix(int [][] si){
        int i=0;
        if(si.length != si[i].length){
            throw new IllegalArgumentException("No es rectangular");
        }else{
            //Aquí construimos a matriz usando iterators
            throw new IllegalArgumentException("Así es");
        }
    }

    //public int getRow() {
      //  return row;
    //}

    //public int getColumn() {
       // return column;
   // }

}
