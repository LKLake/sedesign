package service;


import dao.DaoManager;
import dao.user.StudentDao;
import dao.user.TeacherDao;
import dao.user.UserDao;
import org.springframework.stereotype.Service;

@Service("changePasswordService")
public class ChangePasswordServiceImpl implements ChangePasswordService {


    public int changePassword(String userId,String rawPassword,String newPassword,String ackPassword,String identity)  {
//        int result=-1;
//        DaoManager dm=DaoManager.getInstance();
//        StudentDao studentDao = dm.getDao(StudentDao.class);
//        TeacherDao teacherDao= dm.getDao(TeacherDao.class);
//        UserDao userDao;
//        if("student".equals(identity))
//            userDao =studentDao;
//        else
//            userDao =teacherDao;
//        //匹配用户名与原密码，若一致，修改密码为新密码。正确返回0，出错返回-1;
//        if(rawPassword.equals(newPassword))
//            return 1;
//
//        try
//        {
//            dm.begin();
//            result=userDao.updatePasswordByUserId(userId,newPassword);
//            dm.commit();
//        }
//        catch (Exception e)
//        {
//            return 1;
//        }finally
//        {
//            dm.end();
//        }
//        return result;
//    }
        int result;
        DaoManager dm = DaoManager.getInstance();
        StudentDao studentDao = dm.getDao(StudentDao.class);
        TeacherDao teacherDao = dm.getDao(TeacherDao.class);
        UserDao userDao;
        if ("student".equals(identity))
            userDao = studentDao;
        else
            userDao = teacherDao;
        if (newPassword.equals(ackPassword)) {//3
            if (newPassword.matches("^(.){6,16}$")) {//5
                if (newPassword.matches("[A-Za-z0-9_-]+$")) {
                    if (rawPassword.equals(newPassword)) {
                        return 0;
                    }
                    else{
                        try {
                            dm.begin();
                            result = userDao.updatePasswordByUserId(userId, newPassword);
                            dm.commit();
                        } catch (Exception e) {
                            return 1;
                        } finally {
                            dm.end();
                        }
                        return result;
                    }
                }
                else {
                    return 1;
                }
            }
            else
                return 1;
        }
        else
            return 1;
    }
}
