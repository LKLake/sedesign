package dao.user;


import bean.StudentBean;
import dao.BaseDao;
import dao.PostgreSQL;
import model.StudentModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("studentDao")
public class StudentDaoImpl extends BaseDao implements StudentDao, PostgreSQL {
    public StudentBean getUserByUserIdAndPassword(String user_id, String password) throws Exception
    {
        String sql = "select * from t_student where user_id = ? and password = ?";
        return esql.query(StudentBean.class, sql, user_id, password);
    }

    @Override
    public int updatePasswordByUserId(String userId, String newPassword) {
        int result=-1;
        String sql="update t_student set password=?"+"where user_id=?";
        try {
            result=esql.update(sql,newPassword,userId);
        }catch (Exception e){
            e.printStackTrace();
        }
        if(result==1)
        return 0;
        else
            return -1;
    }

    public List<StudentBean> getStudentBeanListByClass_no(String classid)
    {
        List<StudentBean> result=null;
        String sql="select * from t_student where class_no=?";
        try {
            result=esql.list(StudentBean.class,sql,classid);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int DeleteStudentByIdAndName(String userId, String name) {
        int result=-1;
        String table="t_student";
        String where="user_id="+"'"+userId+"'"+" and "+"name="+"'"+name+"'";
        try {
            result=esql.delete(StudentBean.class,table,where);

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        if(result!=-1)
        return 0;
        else
            return 1;
    }

    @Override
    public int AddStudentByStudentModel(StudentModel input) {
        int result=-1;
        String table="t_student";
        String class_no=String.valueOf(input.getClassNo());
        String user_id=input.getUserId();
        String password=input.getPassword();
        String major=input.getMajor();
        String name=input.getName();

        StudentBean inputPut=new StudentBean();
        inputPut.setClassNo(Integer.valueOf(class_no));
        inputPut.setMajor(major);
        inputPut.setName(name);
        inputPut.setPassword(password);
        inputPut.setUserId(user_id);
//        String exclude="class_no"+"[ \t]*,[ \t]*"
//                      +"user_id"+"[ \t]*,[ \t]*"
//                      +"password"+"[ \t]*,[ \t]*"
//                      +"major"+"[ \t]*,[ \t]*"
//                      +"name"+"[ \t]*,[ \t]*";
        try {
            result=esql.insert(input,table,"","");
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        if(result!=-1)
         return 0;
         else
             return 1;
    }

    @Override
    public int ChaneStudentInfoById(String userId, String name,
                                    String sex, String password, String major, String classNo) {
        StudentBean input=new StudentBean();
        int result=-1;
        String sql="update t_student set name=? , sex=? , password=? , " +
                "major=? , class_no=? "+"where user_id=?";
        try {

            result=esql.update(sql,name,sex,password,major,classNo,userId);
        }catch (Exception e){
            e.printStackTrace();
        }
        if(result==1)
            return 0;
        else
            return 1;
    }

    @Override
    public StudentBean getStudentBeanByUserId(String userId) {
        StudentBean resultBean = null;
        String sql="select * from t_student where user_id=?";
        try {
            resultBean=esql.query(StudentBean.class,sql,userId);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return resultBean;
    }


}
