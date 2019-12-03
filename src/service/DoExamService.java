package service;

import model.LessonInfoModel;
import model.Paper;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface DoExamService {
    public void saveLessonInfo(LessonInfoModel lessonInfoModel);
    public ArrayList<Integer> calcuResult(Paper paper, Map<Integer,String > currentAnswer) ;
    public List<AbstractMap.SimpleEntry<Integer,String>> findAvailablePaper(String userId);
    public Paper getPaperCotent(int paprId);
}
