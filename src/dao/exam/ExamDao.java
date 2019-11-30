package dao.exam;

import bean.ExamBean;

import java.util.List;

public interface ExamDao {
    List<ExamBean> getExamByUserId(String userId);
}
