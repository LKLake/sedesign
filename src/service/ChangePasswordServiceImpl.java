package service;


import dao.DaoManager;
import dao.user.StudentDao;
import dao.user.TeacherDao;
import dao.user.UserDao;
import org.springframework.stereotype.Service;

@Service("changePasswordService")
public class ChangePasswordServiceImpl implements ChangePasswordService {


    public int changePassword(String userId,String rawPassword,String newPassword,String identity)  {
        DaoManager dm=DaoManager.getInstance();
        StudentDao studentDao = dm.getDao(StudentDao.class);
        TeacherDao teacherDao= dm.getDao(TeacherDao.class);
        UserDao userDao;
        if("student".equals(identity))
            userDao =studentDao;
        else
            userDao =teacherDao;
        //匹配用户名与原密码，若一致，修改密码为新密码。正确返回0，出错返回-1;
        String newUserId = null;
        try {
            dm.begin();
            newUserId=(userDao.getUserByUserIdAndPassword(userId,rawPassword).getUserId());
            dm.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }finally
        {
            dm.end();
        }
        if(!userId.equals(newUserId))
            return -1;
        try
        {
            dm.begin();
            userDao.updatePasswordByUserId(userId,newPassword);
            dm.commit();
        }
        catch (Exception e)
        {
            return -1;
        }finally
        {
            dm.end();
        }
        return 0;
    }
}
