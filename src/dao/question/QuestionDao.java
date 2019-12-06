package dao.question;

import model.Question;

import java.util.ArrayList;

public interface QuestionDao {
    ArrayList<Question> getSingleQuestionListByPaperId(String paperId);
    ArrayList<Question> getMultiQuestionListByPaperId(String paperId);

}
