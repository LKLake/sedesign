package dao.ClassInfoDao;

import bean.ClassInfoBean;


public interface ClassInfoDao {
    ClassInfoBean GetClassInfoBeanByTeacherId(String teacherId);
}
