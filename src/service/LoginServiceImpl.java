package service;

import bean.UserBean;
import dao.DaoManager;
import dao.user.*;
import model.UserModel;
import org.springframework.stereotype.Service;

@Service("loginService")
public class LoginServiceImpl implements LoginService
{
    public UserModel userLogin(String userId, String password, String identity)
    {
        UserBean currentUser=null;
        DaoManager dm = DaoManager.getInstance();
        UserDao userDao;
        if("student".equals(identity)){
            userDao = dm.getDao(StudentDao.class);
        }
        else if("teacher".equals(identity)){
            userDao = dm.getDao(TeacherDao.class);
        }
        else{
            return null;
        }
        try
        {
            dm.begin();
            currentUser = userDao.getUserByUserIdAndPassword(userId,password);
            dm.commit();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            dm.end();
        }
        UserModel userModel=new UserModel(currentUser.getUserId(),currentUser.getName());
        return userModel;
    }

}
