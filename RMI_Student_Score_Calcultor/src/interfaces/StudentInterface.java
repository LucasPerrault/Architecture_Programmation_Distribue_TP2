package interfaces;

import models.Student;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface StudentInterface extends Remote {
    /* Add an exam to a student and return it */
    void addExam(Student student, String name, Integer score, Integer coefficient) throws RemoteException;

    /* Display all student exams */
    String printExams(Student student) throws RemoteException;

    /* Calculte the average score */
    Integer getStudentAverage(Student student) throws RemoteException;
}
