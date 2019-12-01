package model;

import service.LessonInfoService;

public class StudentModel extends UserModel {
    private String major;
    private String classNo;
    private LessonInfoModel lessonInfo;
    public StudentModel(String id, String name){
        super(id,name);
    }



    public StudentModel(String userId,String name,String sex,String password,String major,String classNo,LessonInfoModel lessonInfo){
        super(userId,name,sex,password);
        this.major=major;
        this.classNo=classNo;
        this.lessonInfo=lessonInfo;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getClassNo() {
        return classNo;
    }

    public void setClassNo(String classNo) {
        this.classNo = classNo;
    }

    public LessonInfoModel getLessonInfo() {
        return lessonInfo;
    }

    public void setLessonInfo(LessonInfoModel lessonInfo) {
        this.lessonInfo = lessonInfo;
    }
}
