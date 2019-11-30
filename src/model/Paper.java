package model;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 作业测试卷表
 * @author Administrator
 *
 */
public class Paper {

    private int id;
    private String paperName;
    private Date joinDate;
    private Set<Question> squestionList=new HashSet<Question>();
    private Set<Question> mquestionList=new HashSet<Question>();

    public Set<Question> getSquestionList() {
        return squestionList;
    }

    public void setSquestionList(Set<Question> squestionList) {
        this.squestionList = squestionList;
    }

    public Set<Question> getMquestionList() {
        return mquestionList;
    }

    public void setMquestionList(Set<Question> mquestionList) {
        this.mquestionList = mquestionList;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
}
