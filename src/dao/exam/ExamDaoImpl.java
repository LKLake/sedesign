package dao.exam;

import dao.BaseDao;
import dao.PostgreSQL;
import bean.ExamBean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("ExamDao")
public class ExamDaoImpl extends BaseDao implements ExamDao, PostgreSQL {
    public List<ExamBean> getExamByUserId(String UserId){
        return null;
        //TODO implement
    }
}
