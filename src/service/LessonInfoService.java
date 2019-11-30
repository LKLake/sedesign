package service;

import model.ExamModel;

import java.util.ArrayList;

public interface LessonInfoService {
    public ArrayList<ExamModel> getAllExam(String userId);
}
