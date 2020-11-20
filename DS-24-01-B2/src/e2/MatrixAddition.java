package e2;

import java.util.Iterator;

public class MatrixAddition {
    public Matrix Addition(Matrix m1, Matrix m2, boolean who){
     if(m1.getColumn()!=m2.getColumn()){
         throw new ArithmeticException("columnas distintas");
     }else if(m1.getRow()!=m2.getRow()){
         throw new ArithmeticException("filas distintas");
     }else{
         int[][] data=new int[m1.getRow()][m1.getColumn()];
         Matrix suma=new Matrix(data);
         Iterator <Integer> i1= m1.iterator(who);
         Iterator <Integer> i2= m2.iterator(who);
         for(int f=0;f<m1.getRow();f++){
             for (int c=0;c<m1.getColumn();c++){
                 Integer valor1=i1.next();
                 Integer valor2=i2.next();
                 suma.matriz[f][c]=valor1+valor2;
             }
         }
         return suma;
     }
    }
    public static void main(String [] args){
        int[] fila1 = {0, 1, 2, 3};
        int[] fila2 = {4, 5, 6, 7};
        int[] fila3 = {8, 9, 10, 11};
        int[] fila4 = {12, 13, 14, 15};
        int[][] data = {fila1, fila2, fila3, fila4};
        Matrix m1= new Matrix(data);
        int[] f1 = {0, 1, 2, 3};
        int[] f2 = {4, 5, 6, 7};
        int[] f3 = {8, 9, 10, 11};
        int[] f4 = {12, 13, 14, 15};
        int[][] dato = {fila1, fila2, fila3, fila4};
        Matrix m2= new Matrix(dato);
        MatrixAddition stonks = new MatrixAddition();
        Matrix suma= stonks.Addition(m1,m2,true);
        System.out.println(suma.getString());
    }
}
