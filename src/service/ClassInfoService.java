package service;


import model.Paper;
import model.StudentModel;

import java.util.AbstractMap;
import java.util.ArrayList;

public interface ClassInfoService {
    public ArrayList<StudentModel> getStudent(String teacherId);
    public int changeStudentInfo(String userId,String name,String sex,String password,String major,String classNo);
    public int deleteStudentInfo(String userId,String name);
    public int addStudentInfo(StudentModel student);
    public ArrayList<AbstractMap.SimpleEntry<Integer,String>> getClassPaper(String userId);
    public ArrayList<StudentModel> getAllStudent(String userId);
}
