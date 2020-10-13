import interfaces.MatrixCalculator;

import java.rmi.Naming;

public class MatrixClient {
 
    public static void main(String[] args) {
        try { 
            MatrixCalculator matrixCalculator = (MatrixCalculator)Naming.lookup("rmi://localhost:10000/CalculatorService");

            double[][] matrix1 = {
                    new double[]{2d, 0d},
                    new double[]{7d, 1d},
                    new double[]{9d, 8d}
            };

            double[][] matrix2 = {
                    new double[]{0d, 4d, 6d, 9d},
                    new double[]{1d, 3d, 9d, 2d}
            };

            double[][] matrix = matrixCalculator.mul(matrix1, matrix2);
            System.out.println("Great the result is : " + matrixCalculator.print(matrix));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    } 
} 