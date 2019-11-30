package dao.user;



import dao.BaseDao;
import dao.PostgreSQL;
import bean.StudentBean;
import org.springframework.stereotype.Repository;

@Repository("studentDao")
public class StudentDaoImpl extends BaseDao implements StudentDao, PostgreSQL {
    public StudentBean getUserByUserIdAndPassword(String user_id, String password) throws Exception
    {
        String sql = "select * from t_student where user_id = ? and password = ?";
        return esql.query(StudentBean.class, sql, user_id, password);
    }
}
