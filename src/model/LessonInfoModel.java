package model;

import java.util.Date;
import java.util.Map;

public class LessonInfoModel {
    private Date addedTime;
    private Paper paper;
    private Map<Integer,String> myAnswer;
    private int singleScore;
    private int multiScore;

    public LessonInfoModel(){}
    public LessonInfoModel(Date addedTime,Paper paper,Map<Integer,String>myAnswer,int singleScore,int multiScore){
        this.addedTime=addedTime;
        this.paper=paper;
        this.myAnswer=myAnswer;
        this.addedTime=new Date();
        this.singleScore=singleScore;
        this.multiScore=multiScore;
    }
//    public LessonInfoModel(Paper paper,Map<Integer,String>myAnswer){
//        this.paper=paper;
//        this.myAnswer=myAnswer;
//        this.addedTime=new Date();
//    }

    public Date getAddedTime() {
        return addedTime;
    }

    public void setAddedTime(Date addedTime) {
        this.addedTime = addedTime;
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
