package service;

import bean.UserBean;

public interface LoginService {
    public Boolean userLogin(String userId, String password,String identity);
    public String getUserId();
    public String getUserName();
}
