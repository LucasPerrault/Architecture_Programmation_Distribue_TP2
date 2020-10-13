import interfaces.MatrixCalculator;

import java.rmi.Naming;

public class MatrixServer  {

    public static void main(String args[]) {
       try {
           MatrixCalculator c = new MatrixService();

           java.rmi.registry.LocateRegistry.createRegistry(10000);
           Naming.rebind("rmi://localhost:10000/CalculatorService", c);

           System.out.println("Matrix Calculator Server is ready ! \n");

       } catch (Exception e) {
           System.out.println("Oops we found a trouble : \n" + e);
       }
    }
}

