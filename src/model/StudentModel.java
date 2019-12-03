package model;

import service.LessonInfoService;

import java.util.ArrayList;

public class StudentModel extends UserModel {
    private String major;
    private int classNo;
    private ArrayList<LessonInfoModel> lessonInfoList;
    public StudentModel(){}
    public StudentModel(String userId, String name,String sex,String password,String major,int classNo,ArrayList<LessonInfoModel> lessonInfoList){
        super(userId,name,sex,password);
        this.major=major;
        this.classNo=classNo;
        this.lessonInfoList=lessonInfoList;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getClassNo() {
        return classNo;
    }

    public void setClassNo(int classNo) {
        this.classNo = classNo;
    }

    public ArrayList<LessonInfoModel> getLessonInfoList() {
        return lessonInfoList;
    }

    public void setLessonInfoList(ArrayList<LessonInfoModel> lessonInfoList) {
        this.lessonInfoList = lessonInfoList;
    }
}
