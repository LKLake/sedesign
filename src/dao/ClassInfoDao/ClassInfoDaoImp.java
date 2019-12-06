package dao.ClassInfoDao;

import bean.ClassInfoBean;
import dao.BaseDao;
import dao.PostgreSQL;
import org.springframework.stereotype.Repository;


@Repository("classInfoDao")
public class ClassInfoDaoImp extends BaseDao implements ClassInfoDao, PostgreSQL {

    @Override
    public ClassInfoBean GetClassInfoBeanByTeacherId(String teacherId) {
        ClassInfoBean classInfoBean = null;
        String sql="select * from t_class_info where teacher_id=?";
        try {
          classInfoBean=esql.query(ClassInfoBean.class,sql,teacherId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return classInfoBean;
    }
}
