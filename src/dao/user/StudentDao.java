package dao.user;


import bean.StudentBean;

public interface StudentDao extends UserDao {
    public StudentBean getUserByUserIdAndPassword(String userId, String password) throws Exception;
}