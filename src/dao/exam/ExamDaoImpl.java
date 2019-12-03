package dao.exam;

import bean.LessonInfoBean;
import dao.BaseDao;
import dao.PostgreSQL;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("ExamDao")
public class ExamDaoImpl extends BaseDao implements ExamDao, PostgreSQL {
    public List<LessonInfoBean> getExamByUserId(String UserId){
        return null;
        //TODO implement
    }
}
