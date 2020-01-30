package com.example.quizzcombotaonomain;

import java.util.Random;

public class Question {
    private int firstnumber;
    private  int secondnumber;
    private int answer;

    //there are 4 pissible choices for the user to pick
    private int [] answerArray;
    //witch of the four positions is correct
    private int answerPosition;

    //the maximum value of the first number
    private int upperLimit;

    private String questionPhrase;

    public Question(int upperLimit){

        this.upperLimit=upperLimit;
        Random randomNumber = new Random();
        this.firstnumber = randomNumber.nextInt(upperLimit);
        this.secondnumber = randomNumber.nextInt(upperLimit);
        this.answer = firstnumber + secondnumber;
        this.questionPhrase = firstnumber + " + " + secondnumber + "=" ;

        this.answerPosition = randomNumber.nextInt(4);
        this.answerArray = new int[] {0,1,2,3};
        this.answerArray[0]= answer+1;
        this.answerArray[1]= answer-1;
        this.answerArray[2]= answer+3;
        this.answerArray[3]= answer-5;
        //shuffle answers
        this.answerArray = shuffleArray(this.answerArray);

        answerArray[answerPosition] = answer;

    }

    private int [] shuffleArray(int[] array){

        int index,tmp;

        Random randomNumber = new Random();

        for (int i = answerArray.length - 1; i > 1;i--){

            index = randomNumber.nextInt(i+1);
            tmp = array[index];
            array[index]= array[i];
            array[i]=tmp;
        }
        return array ;
    }

    public int getFirstnumber() {
        return firstnumber;
    }

    public void setFirstnumber(int firstnumber) {
        this.firstnumber = firstnumber;
    }

    public int getSecondnumber() {
        return secondnumber;
    }

    public void setSecondnumber(int secondnumber) {
        this.secondnumber = secondnumber;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public int[] getAnswerArray() {
        return answerArray;
    }

    public void setAnswerArray(int[] answerArray) {
        this.answerArray = answerArray;
    }

    public int getAnswerPosition() {
        return answerPosition;
    }

    public void setAnswerPosition(int answerPosition) {
        this.answerPosition = answerPosition;
    }

    public int getUpperLimit() {
        return upperLimit;
    }

    public void setUpperLimit(int upperLimit) {
        this.upperLimit = upperLimit;
    }

    public String getQuestionPhrase() {
        return questionPhrase;
    }

    public void setQuestionPhrase(String questionPhrase) {
        this.questionPhrase = questionPhrase;
    }
}

