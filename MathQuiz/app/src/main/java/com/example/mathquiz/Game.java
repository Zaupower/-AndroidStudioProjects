package com.example.mathquiz;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Question> questionList = new ArrayList<>();
    private int numberCorrect;
    private int numberIncorrect;
    private int totalQuesntions;
    private int score;
    private Question currentQestion;

    public Game(){
        numberCorrect=0;
        numberIncorrect=0;
        totalQuesntions=0;
        currentQestion = new Question(10);
    }

    public void makeNewQuestion(){
        currentQestion = new Question(totalQuesntions* 2+5);
        totalQuesntions++;
        questionList.add(currentQestion);
    }

    public boolean checkAnswer(int submittedAnswer){
        boolean isCorrect;
        if (currentQestion.getAnswer() == submittedAnswer){
            numberCorrect++;
            isCorrect=true;
            score +=10;
        }else {
            numberIncorrect++;
            isCorrect=false;
            score-=10;
        }
        return isCorrect;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    public int getNumberCorrect() {
        return numberCorrect;
    }

    public void setNumberCorrect(int numberCorrect) {
        this.numberCorrect = numberCorrect;
    }

    public int getNumberIncorrect() {
        return numberIncorrect;
    }

    public void setNumberIncorrect(int numberIncorrect) {
        this.numberIncorrect = numberIncorrect;
    }

    public int getTotalQuesntions() {
        return totalQuesntions;
    }

    public void setTotalQuesntions(int totalQuesntions) {
        this.totalQuesntions = totalQuesntions;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Question getCurrentQestion() {
        return currentQestion;
    }

    public void setCurrentQestion(Question currentQestion) {
        this.currentQestion = currentQestion;
    }
}
