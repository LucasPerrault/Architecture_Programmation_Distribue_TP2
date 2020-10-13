package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MatrixCalculator extends Remote {
    double[][] mul(double[][] firstMatrix, double[][] secondMatrix) throws RemoteException;
    String print(double[][] matrix) throws RemoteException;
} 