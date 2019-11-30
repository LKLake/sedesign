package service;

import model.ExamModel;
import model.Paper;
import model.Question;

import java.util.List;
import java.util.Map;

public interface DoExamService {
    /*public List<Question> getPaper(String userId) throws Exception;
    public void onSubmit_exam();
    public int getResult(Map<String, String[]> keyMap) throws Exception;*/
    public List<ExamModel> findAvailablePaper(String userId);
}
