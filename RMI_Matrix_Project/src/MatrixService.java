import interfaces.MatrixCalculator;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Arrays;

public class MatrixService extends UnicastRemoteObject implements MatrixCalculator {

    protected MatrixService() throws RemoteException {
        super();
    }

    /* Matrix Multiplication */
    @Override
    public double[][] mul(double[][] firstMatrix, double[][] secondMatrix) {
        double[][] result = new double[firstMatrix.length][secondMatrix[0].length];

        for (int row = 0; row < result.length; row++) {
            for (int col = 0; col < result[row].length; col++) {
                result[row][col] = matrixMultiplicationCell(firstMatrix, secondMatrix, row, col);
            }
        }

        System.out.print("Multilplication done ! \n");
        return result;
    }

    /* Matrix multiplication by cell */
    private double matrixMultiplicationCell(double[][] firstMatrix, double[][] secondMatrix, int row, int col) {
        double cell = 0;
        for (int i = 0; i < secondMatrix.length; i++) {
            cell += firstMatrix[row][i] * secondMatrix[i][col];
        }
        return cell;
    }

    /* Display of the matrix */
    @Override
    public String print(double[][] matrix) {
        StringBuffer matrixToString = new StringBuffer();

        for (double[] row : matrix)
            matrixToString.append(Arrays.toString(row));

        return matrixToString.toString();
    }
}
