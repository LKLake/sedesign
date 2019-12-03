package service;


import model.LessonInfoModel;

import java.util.ArrayList;

public interface LessonInfoService {
    public ArrayList<LessonInfoModel> getAllExam(String userId);
}
