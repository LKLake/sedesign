package service;

import model.StudentModel;

import java.util.ArrayList;
import java.util.Map;

public interface ClassInfoService {
    public ArrayList<StudentModel> getStudent(String teacherId);
    public int changeStudentInfo(String userId,String name,String sex,String password,String major,String classNo);
    public int deleteStudentInfo(String userId,String name);
}
