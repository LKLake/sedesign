package model;

import java.util.ArrayList;

public class ClassInfoModel {
    private ArrayList<StudentModel> studentModelList;
    private int classNo;
    private ArrayList<Paper> paperList;
    public ClassInfoModel(){}
    public ClassInfoModel(ArrayList<StudentModel> studentModelList,ArrayList<Paper> paperList,int classNo){
        this.studentModelList=studentModelList;
        this.classNo=classNo;
        this.paperList=paperList;
    }

    public ArrayList<StudentModel> getStudentModelList() {
        return studentModelList;
    }

    public void setStudentModelList(ArrayList<StudentModel> studentModelList) {
        this.studentModelList = studentModelList;
    }

    public int getClassNo() {
        return classNo;
    }

    public void setClassNo(int classNo) {
        this.classNo = classNo;
    }

    public ArrayList<Paper> getPaperList() {
        return paperList;
    }

    public void setPaperList(ArrayList<Paper> paperList) {
        this.paperList = paperList;
    }
}
