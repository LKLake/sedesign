package service;

import bean.UserBean;
import dao.DaoManager;
import dao.user.*;
import org.springframework.stereotype.Service;

@Service("loginService")
public class LoginServiceImpl implements LoginService
{
    private UserBean CurrentUser=null;
    public Boolean userLogin(String userId, String password,String identity)
    {
        DaoManager dm = DaoManager.getInstance();
        UserDao userDao;
        if("student".equals(identity)){
            userDao = dm.getDao(StudentDao.class);
        }
        else if("teacher".equals(identity)){
            userDao = dm.getDao(TeacherDao.class);
        }
        else{
            return false;
        }
        try
        {
            dm.begin();
            CurrentUser = userDao.getUserByUserIdAndPassword(userId,password);
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
        return CurrentUser!=null;
    }
    public String getUserName(){
        if(this.CurrentUser!=null){
            return CurrentUser.getName();
        }
        else return null;
    }
    public String getUserId(){
        if(this.CurrentUser!=null){
            return CurrentUser.getUserId();
        }
        else
            return null;
    }
}
