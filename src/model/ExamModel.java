package model;

import java.util.Date;

public class ExamModel {
    private Date addedTime;
    private int id;
    private String name;
    public ExamModel(){}
    public ExamModel(String paperName){
        this.name=paperName;
        this.id=0;
        this.setAddedTime(new Date());
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
