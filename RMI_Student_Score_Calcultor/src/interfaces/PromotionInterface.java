package interfaces;

import models.Student;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PromotionInterface extends Remote {
    void addStudent(Integer id, String name, Integer age) throws RemoteException;
    Student findStudent(Integer index) throws RemoteException;
    Integer getPromotionAverage() throws RemoteException;

}
