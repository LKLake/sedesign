package model;

import java.util.Date;
import java.util.Map;

public class LessonInfoModel {
    private Date addedTime;
    private int id;
    private Paper paper;
    private Map<Integer,String> myAnswer;
    private int score;
    private int singleScore;
    private int multiScore;
    public LessonInfoModel(){}
    public LessonInfoModel(Paper paper,Map<Integer,String>myAnswer,int score,int singleScore,int multiScore){
        this.paper=paper;
        this.id=0;
        this.myAnswer=myAnswer;
        this.addedTime=new Date();
        this.score=score;
        this.singleScore=singleScore;
        this.multiScore=multiScore;
    }
    public LessonInfoModel(Paper paper,Map<Integer,String>myAnswer){
        this.paper=paper;
        this.id=0;
        this.myAnswer=myAnswer;
        this.addedTime=new Date();
    }

    public Date getAddedTime() {
        return addedTime;
    }

    public void setAddedTime(Date addedTime) {
        this.addedTime = addedTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Paper getPaper() {
        return paper;
    }

    public void setPaper(Paper paper) {
        this.paper = paper;
    }

    public Map<Integer, String> getMyAnswer() {
        return myAnswer;
    }

    public void setMyAnswer(Map<Integer, String> myAnswer) {
        this.myAnswer = myAnswer;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getSingleScore() {
        return singleScore;
    }

    public void setSingleScore(int singleScore) {
        this.singleScore = singleScore;
    }

    public int getMultiScore() {
        return multiScore;
    }

    public void setMultiScore(int multiScore) {
        this.multiScore = multiScore;
    }
}
