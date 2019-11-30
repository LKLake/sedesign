package dao.user;


import bean.TeacherBean;

public interface TeacherDao extends UserDao{
    public TeacherBean getUserByUserIdAndPassword(String userId, String password) throws Exception;
}