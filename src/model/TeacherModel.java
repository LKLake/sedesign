package model;

import service.ClassInfoService;

import java.util.ArrayList;

public class TeacherModel extends UserModel {
    private ArrayList<StudentModel> studentModelList=null;
    private ClassInfoModel cLassInfo;

    public TeacherModel(String userId, String name){
        super(userId,name);
    }

    public ArrayList<StudentModel> getStudentModelList() {
        return studentModelList;
    }

    public void setStudentModelList(ArrayList<StudentModel> studentModelList) {
        this.studentModelList = studentModelList;
    }

    public ClassInfoModel getcLassInfo() {
        return cLassInfo;
    }

    public void setcLassInfo(ClassInfoModel cLassInfo) {
        this.cLassInfo = cLassInfo;
    }
}
