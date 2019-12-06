package dao.user;


import bean.TeacherBean;
import dao.BaseDao;
import dao.PostgreSQL;
import org.springframework.stereotype.Repository;

@Repository("teacherDao")
public class TeacherDaoImpl extends BaseDao implements TeacherDao, PostgreSQL {

    public TeacherBean getUserByUserIdAndPassword(String userId, String password) throws Exception
    {
        String sql = "select * from t_teacher where user_id = ? and password = ?";
        return esql.query(TeacherBean.class, sql, userId, password);
    }

    @Override
    public int updatePasswordByUserId(String userId, String newPassword) {
        return 0;
        //TODO implement
    }

    @Override
    public int getClass_noByTeacherId(String userId) throws Exception {
        int result=-1;
        String sql="selct class_no from t_class_info where teacher_id=?";
        result=esql.query(Integer.class,sql,userId);
        return result;
    }
}
