package stas.entity;

public class Participant {
    private String id;
    private String name;
    private String surname;
    private int idGroup;
    private double pointsQuestion = 0;
    private double pointsAnswer = 0;
    private double pointsOther = 0;

    public Participant(String id, String name, String surname, int idGroup) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.idGroup = idGroup;
    }

    public String getFullName() {
        return this.surname + " " + this.name;
    }

    public Participant() {
    }

    @Override
    public String toString() {
        return "Participant{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", idGroup=" + idGroup +
                ", pointsQuestion=" + pointsQuestion +
                ", pointsAnswer=" + pointsAnswer +
                ", pointsOther=" + pointsOther +
                '}';
    }

    public double getPointsOther() {
        return pointsOther;
    }

    public void setPointsOther(double pointsOther) {
        this.pointsOther = pointsOther;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(int idGroup) {
        this.idGroup = idGroup;
    }

    public double getPointsQuestion() {
        return pointsQuestion;
    }

    public void setPointsQuestion(double pointsQuestion) {
        this.pointsQuestion = pointsQuestion;
    }

    public double getPointsAnswer() {
        return pointsAnswer;
    }

    public void setPointsAnswer(double pointsAnswer) {
        this.pointsAnswer = pointsAnswer;
    }
}
