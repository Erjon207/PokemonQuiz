package org.example;

public class Question {

    String question;

    int result;

    public Question(String question, int result) {
        this.question = question;
        this.result = result;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
