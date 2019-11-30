package service;

import bean.UserBean;
import model.UserModel;

public interface LoginService {
    public UserModel userLogin(String userId, String password, String identity);
}
