package dao.user;


import bean.UserBean;

public interface UserDao {
    public UserBean getUserByUserIdAndPassword(String userId, String password) throws Exception;
}
