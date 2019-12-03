package dao.exam;

import bean.LessonInfoBean;

import java.util.List;

public interface ExamDao {
    List<LessonInfoBean> getExamByUserId(String userId);
    //此dao接口为瞎写的，按需要设计
}
