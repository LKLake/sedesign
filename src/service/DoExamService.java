package service;

import model.ExamModel;
import model.Paper;
import model.Question;

import java.util.List;
import java.util.Map;

public interface DoExamService {
    public void saveExam(ExamModel examModel,Map<Integer,String> currentAnswer);
    public int calcuResult(Paper paper,Map<Integer,String > currentAnswer) ;
    public List<ExamModel> findAvailablePaper(String userId);
    public Paper getPaperCotent(int paprId);
}
