package model;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 作业测试卷表
 * @author Administrator
 *
 */
public class Paper {
    private String paperName;
    private Date joinDate;
    private ArrayList<Question> singleQuestionList;
    private ArrayList<Question> multiQuestionList;

    public Paper(){}
    public Paper(String paperName,Date joinDate,ArrayList<Question> singleQuestionList,ArrayList<Question> multiQuestionList) {
        this.paperName=paperName;
        this.joinDate=joinDate;
        this.singleQuestionList=singleQuestionList;
        this.multiQuestionList=multiQuestionList;
    }

    public void addSingleQuestion(Question question){
        this.singleQuestionList.add(question);
    }
    public void addMultiQuestion(Question question){
        this.multiQuestionList.add(question);
    }

    public String getPaperName() {
        return paperName;
    }

    public void setPaperName(String paperName) {
        this.paperName = paperName;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public ArrayList<Question> getSingleQuestionList() {
        return singleQuestionList;
    }

    public void setSingleQuestionList(ArrayList<Question> singleQuestionList) {
        this.singleQuestionList = singleQuestionList;
    }

    public ArrayList<Question> getMultiQuestionList() {
        return multiQuestionList;
    }

    public void setMultiQuestionList(ArrayList<Question> multiQuestionList) {
        this.multiQuestionList = multiQuestionList;
    }
}
