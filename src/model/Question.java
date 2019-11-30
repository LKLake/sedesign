package model;

import java.util.Date;

/**
 * 题目表
 * @author Administrator
 *
 */
public class Question {

    private int id;  // 问题编号
    private String subject; // 题目名称
    private String type; // 题目类型 1 是单选题 2 是多选题
    private Date joinTime; // 添加时间

    private Paper paper; // 试卷

    private String optionA; // 选项A
    private String optionB; // 选项B
    private String optionC; // 选项C
    private String optionD; // 选项D
    private String answer; // 答案

    private String userAnswer; // 用户回答

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public Date getJoinTime() {
        return joinTime;
    }
    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
    }

    public Paper getPaper() {
        return paper;
    }
    public void setPaper(Paper paper) {
        this.paper = paper;
    }
    public String getOptionA() {
        return optionA;
    }
    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }
    public String getOptionB() {
        return optionB;
    }
    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }
    public String getOptionC() {
        return optionC;
    }
    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }
    public String getOptionD() {
        return optionD;
    }
    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }
    public String getAnswer() {
        return answer;
    }
    public void setAnswer(String answer) {
        this.answer = answer;
    }


    public String getUserAnswer() {
        return userAnswer;
    }
    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }



}
