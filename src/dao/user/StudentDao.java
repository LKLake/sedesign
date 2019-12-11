package dao.user;


import bean.StudentBean;
import model.StudentModel;

import java.util.List;

public interface StudentDao extends UserDao {
    public List<StudentBean> getStudentBeanListByClass_no(String classid);
    public int DeleteStudentByIdAndName(String userId, String name);
    public int AddStudentByStudentModel(StudentModel input);
    public int ChaneStudentInfoById(String userId, String name, String sex, String password, String major, String classNo);
    public StudentBean getStudentBeanByUserId(String userId);
}