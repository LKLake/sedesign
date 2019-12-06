package dao.exam;

import bean.LessonInfoBean;
import model.LessonInfoModel;

import java.util.List;
import java.util.Map;

public interface ExamDao {
    List<LessonInfoBean> getExamByUserId(String userId);
    int SaveExam(String userId, LessonInfoModel input);
    int SaveAnwser(String userId, Map<Integer,String> map);
}
