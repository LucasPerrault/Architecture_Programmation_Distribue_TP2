package models;

import java.io.Serializable;

public class Exam implements Serializable {
    private String name;
    private Integer score;
    private Integer coefficient;

    public Exam(String name, Integer score, Integer coefficient) {
        this.name = name;
        this.score = score;
        this.coefficient = coefficient;
    }

    public String getName() {
        return name;
    }

    public Integer getScore() {
        return score;
    }

    public Integer getCoefficient() {
        return coefficient;
    }

    @Override
    public String toString() {
        return "- Exam is " + name + " with the score of " + score + " and a coeff of " + coefficient + "\n";
    }
}
