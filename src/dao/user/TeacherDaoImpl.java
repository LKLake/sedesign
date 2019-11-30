package dao.user;


import dao.BaseDao;
import dao.PostgreSQL;
import bean.TeacherBean;

public class TeacherDaoImpl extends BaseDao implements TeacherDao, PostgreSQL {
    public TeacherBean getUserByUserIdAndPassword(String userId, String password) throws Exception
    {
        String sql = "select * from t_teacher where user_id = ? and password = ?";
        return esql.query(TeacherBean.class, sql, userId, password);
    }
}
