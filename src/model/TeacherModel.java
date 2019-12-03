package model;


public class TeacherModel extends UserModel {
    private ClassInfoModel classInfo;
    public TeacherModel(){}
    public TeacherModel(String userId, String name,String sex,String password,ClassInfoModel classInfoModel){
        super(userId,name,sex,password);
        this.classInfo=classInfoModel;
    }

    public ClassInfoModel getClassInfo() {
        return classInfo;
    }

    public void setClassInfo(ClassInfoModel classInfo) {
        this.classInfo = classInfo;
    }
}
