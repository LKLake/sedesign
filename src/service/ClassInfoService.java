package service;

import model.StudentModel;

import java.util.ArrayList;
import java.util.Map;

public interface ClassInfoService {
    public ArrayList<StudentModel> getStudent(String teacherId);
    public int changeStudentInfo(StudentModel studentModel);
}
