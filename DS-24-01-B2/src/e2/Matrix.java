package e2;

public class Matrix {
    private int [][] matriz;


    public Matrix(int row, int column){
        this.matriz=new int[row][column]; //Inicializamos la matriz
        // Recorrer todas las columnas poniendo su valor a 0 => Iterator
    }

    public Matrix(int [][] si){
        int i=0;
        if(si.length != si[i].length){
            throw new IllegalArgumentException("No es rectangular");
        }else{
            this.matriz=new int[si.length][si[0].length]; //Inicializamos la matriz
            //Aquí construimos a matriz usando iterators
            for(int f = 0; f<si.length; f++){
                for(int c = 0; c<si[f].length; c++){
                    this.matriz[f][c]=si[f][c];
                }
            }
        }
    }

    //public int getRow() {
      //  return row;
    //}

    //public int getColumn() {
       // return column;
   // }

}
