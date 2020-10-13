import interfaces.ServerInterface;

import java.rmi.Naming;
import java.rmi.RemoteException;

public class Client {
    public final static String SERVER_NAME = "server_student";

    public static void main(String args[]) throws RemoteException
    {
        try
        {
            ServerInterface serverInterface = (ServerInterface)Naming.lookup("rmi://localhost:10000/" + SERVER_NAME);

            /* Add some students */
            initializeStudents(serverInterface);
            System.out.println("Init with some students.. \n");

            /*Add exam of each student */
            serverInterface.addExam(serverInterface.findStudent(0), "Mathématiques", 12, 2 );
            serverInterface.addExam(serverInterface.findStudent(0), "Français", 10, 3 );
            System.out.println("We added two exams of this student ! \n");

            /* Print exams */
            String allExamsToString = serverInterface.printExams(serverInterface.findStudent(0));
            System.out.println("All exams of this student are : \n" + allExamsToString + "\n");

            /* Student average */
            Integer studentAverage = serverInterface.getStudentAverage(serverInterface.findStudent(0));
            System.out.println("Student average is : " + studentAverage + "\n");


            /* ----------------- */
            serverInterface.addExam(serverInterface.findStudent(1), "Mathématiques", 14, 2 );
            serverInterface.addExam(serverInterface.findStudent(1), "Français", 20, 3 );
            System.out.println("We added two exams of an another student ! \n");

            /* Print exams */
            String allExamsToStringStudent1 = serverInterface.printExams(serverInterface.findStudent(1));
            System.out.println("All exams of this student are : \n" + allExamsToStringStudent1 + "\n");

            /* Student average */
            Integer studentAverage1 = serverInterface.getStudentAverage(serverInterface.findStudent(1));
            System.out.println("Student average is : " + studentAverage1 + "\n");

            /* Promotion average */
            Integer promotionAverage = serverInterface.getPromotionAverage();
            System.out.println("The promotion average is : " + promotionAverage + "\n");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void initializeStudents(ServerInterface serverInterface) throws RemoteException {
        serverInterface.addStudent(0, "Lucas Perrault", 21);
        serverInterface.addStudent(1, "Zinedine Zidane", 32);
        serverInterface.addStudent(2, "Bastien Poulie", 54);
        serverInterface.addStudent(3, "Jennifer Lopez", 18);
        serverInterface.addStudent(4, "Toto Tuti", 12);
        serverInterface.addStudent(5, "Camembert President", 23);
    }
}
