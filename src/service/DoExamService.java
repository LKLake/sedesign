package service;

import model.LessonInfoModel;
import model.Paper;

import java.util.List;
import java.util.Map;

public interface DoExamService {
    public void saveExam(LessonInfoModel lessonInfoModel);
    public int calcuResult(Paper paper,Map<Integer,String > currentAnswer) ;
    public List<Paper> findAvailablePaper(String userId);
    public Paper getPaperCotent(int paprId);
}
