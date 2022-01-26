package stas;

public class Participant {
    private String id;
    private String name;
    private String surname;
    private int idGroup;
    private int pointsQuestion;
    private int pointsAnswer;
    private int pointsOther;

    public Participant(String id, String name,String surname, int idGroup) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.idGroup = idGroup;
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
    public int getPointsOther() {
        return pointsOther;
    }

    public void setPointsOther(int pointsOther) {
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

    public int getPointsQuestion() {
        return pointsQuestion;
    }

    public void setPointsQuestion(int pointsQuestion) {
        this.pointsQuestion = pointsQuestion;
    }

    public int getPointsAnswer() {
        return pointsAnswer;
    }

    public void setPointsAnswer(int pointsAnswer) {
        this.pointsAnswer = pointsAnswer;
    }
}
