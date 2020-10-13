import interfaces.ServerInterface;
import models.Exam;
import models.Student;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class Server extends UnicastRemoteObject implements ServerInterface {
    public final static String SERVER_NAME = "server_student";
    private List<Student> promotion;

    protected Server(String message) throws RemoteException {
        System.out.println(message);
        promotion = new ArrayList<Student>();
    }

    public static void main(String args[])
    {
        try
        {
            Server server = new Server("Student Score Calcultor is ready !");

            java.rmi.registry.LocateRegistry.createRegistry(10000);
            Naming.rebind("rmi://localhost:10000/" + SERVER_NAME, server);
            System.out.println(SERVER_NAME + " bound in registry");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    /* Promotion */
    @Override
    public void addStudent(Integer id, String fullName, Integer age) {
        Student newStudent = new Student(id, fullName, age);
        promotion.add(newStudent);
        System.out.println("The student " + newStudent.getFullName() + " has been created.");
    }

    @Override
    public Student findStudent(Integer index) {
        if (promotion.size() == 0) {
            return null;
        }

        for (Student student: promotion) {
            if (student.getId().equals(index)) {
                return student;
            }
        }

        return null;
    }

    @Override
    public Integer getPromotionAverage() {
        if (promotion.size() == 0) {
            return null;
        }

        int studentNumber = 0;
        int totalStudentScore = 0;

        for (Student student: promotion) {
            if (student.getExams().size() != 0) {
                studentNumber += 1;
                totalStudentScore += getStudentAverage(student);
            }
        }

        int promotionAverage = totalStudentScore / studentNumber;
        return promotionAverage;
    }

    /* Student */
    @Override
    public void addExam(Student student, String name, Integer score, Integer coefficient) {
        Student studentFound = findStudent(student.getId());
        if (studentFound == null) {
            System.out.println("Impossible to find this student..");
            return;
        }

        studentFound.getExams().add(new Exam(name, score, coefficient));
        System.out.println("The exam has been added sucessfully !");
    }

    @Override
    public String printExams(Student student) {
        StringBuffer examsToString = new StringBuffer();

        for (Exam exam : student.getExams()) {
            examsToString.append(exam.toString());
        }

        return examsToString.toString();
    }

    @Override
    public Integer getStudentAverage(Student student) {
        int examNumber = 0;
        int sumOfScore = 0;

        for (Exam exam : student.getExams()) {
            sumOfScore += (exam.getScore() * exam.getCoefficient());
            examNumber += exam.getCoefficient();
        }

        int studentAverage = sumOfScore / examNumber;

        return studentAverage;
    }
}
