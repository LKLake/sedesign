package model;

import java.util.Date;

/**
 * 题目表
 * @author Administrator
 *
 */
public class Question {

    private int id;  // 问题编号
    private String content; // 题目名称
    private String type; // 题目类型 1 是单选题 2 是多选题
    private Date joinTime; // 添加时间


    private String optionA; // 选项A
    private String optionB; // 选项B
    private String optionC; // 选项C
    private String optionD; // 选项D
    private String answer; // 答案

    public Question(){}
    public Question(int id,String content,String type,Date joinTime,String optionA,String optionB,String optionC,String optionD,String answer){
        this.id=id;
        this.content=content;
        this.type=type;
        this.joinTime=joinTime;
        this.optionA=optionA;
        this.optionB=optionB;
        this.optionC=optionC;
        this.optionD=optionD;
        this.answer=answer;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
