package service;


import bean.ClassInfoBean;
import bean.StudentBean;
import dao.ClassInfoDao.ClassInfoDao;
import dao.DaoManager;
import dao.paper.PaperDao;
import dao.user.StudentDao;
import model.Paper;
import model.StudentModel;
import org.springframework.stereotype.Service;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

@Service("classInfoService")
public class ClassInfoServiceImpl implements ClassInfoService {

    @Override
    public ArrayList<StudentModel> getStudent(String teacherId){
        DaoManager dm=DaoManager.getInstance();
        ClassInfoDao classInfoDao = dm.getDao(ClassInfoDao.class);
        StudentDao studentDao=dm.getDao(StudentDao.class);
        ArrayList<StudentModel> studentModelArrayList=new ArrayList<>();
        ClassInfoBean classInfoBean=null;
        try{
            dm.begin();
            classInfoBean= classInfoDao.GetClassInfoBeanByTeacherId(teacherId);
            dm.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            dm.end();
        }
        int class_no=classInfoBean.getClassNo();
        List<StudentBean> ts=null;
        try{
            dm.begin();
            ts=studentDao.getStudentBeanListByClass_no(String.valueOf(class_no));
            dm.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            dm.end();
        }


        for (int i=0;i<ts.size();i++)
        {
            StudentModel tmp=new StudentModel();
            tmp.setClassNo(ts.get(i).getClassNo());
            tmp.setMajor(ts.get(i).getMajor());
            tmp.setName(ts.get(i).getName());
            tmp.setPassword(ts.get(i).getPassword());
            tmp.setSex(ts.get(i).getSex());
            tmp.setUserId(ts.get(i).getUserId());
            tmp.setLessonInfoList(null);
            studentModelArrayList.add(tmp);
        }
        return  studentModelArrayList;

    }
    @Override

    public int changeStudentInfo(String userId,String name,String sex,String password,String major,String classNo){
        int result=-1;
        DaoManager dm=DaoManager.getInstance();
        StudentDao studentDao=dm.getDao(StudentDao.class);
        try {
            dm.begin();
            result=studentDao.ChaneStudentInfoById(userId,name,sex,password,
                    major,classNo);
            dm.commit();
        }catch (Exception e){
            e.printStackTrace();
            dm.end();
        }

        return result;//0表示修改成功,-1修改失败
        //通过userid可以确定这个学生，然后修改student表，目前先别cascade，出现冲突就返回1吧。
    }
    @Override
    public int deleteStudentInfo(String userId,String name){
        DaoManager dm=DaoManager.getInstance();
        StudentDao studentDao = dm.getDao(StudentDao.class);
        int flag=-1;
        try {
            dm.begin();
            flag=studentDao.DeleteStudentByIdAndName(userId,name);
            dm.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            dm.end();
        }
        return flag;

        //通过userid可以确定这个学生，然后修改student表，目前先别cascade(这不是我能控制的），出现冲突就返回-1吧。
    }

    @Override
    public int addStudentInfo(StudentModel student) {
        DaoManager dm=DaoManager.getInstance();
        StudentDao studentDao = dm.getDao(StudentDao.class);
        int flag=-1;
        try {
            dm.begin();
            flag=studentDao.AddStudentByStudentModel(student);
            dm.end();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;


        //把studentmodel里能添的信息都添加进student表，注意检查外键，报错就返回-1
    }

    public ArrayList<AbstractMap.SimpleEntry<Integer,String>> getClassPaper(String userId){
        ArrayList<AbstractMap.SimpleEntry<Integer,String>>tmp=new ArrayList<>();
        DaoManager dm=DaoManager.getInstance();
        ClassInfoDao classInfoDao=dm.getDao(ClassInfoDao.class);
        int num=0;
        int classNo=-1;
        String name="";
        ArrayList<Paper> paperList=new ArrayList<>();
        Paper paper;
        PaperDao paperDao=dm.getDao(PaperDao.class);
        try {
            dm.begin();
            classNo=classInfoDao.GetClassInfoBeanByTeacherId(userId).getClassNo();
            paperList=paperDao.getPaperListByClassId(String.valueOf(classNo));
            dm.commit();
        }catch (Exception e){e.printStackTrace();}
        finally {
            dm.end();
        }
        for(int i=0;i<paperList.size();i++)
        {
            paper=paperList.get(i);
            num=paper.getPaperId();
            name=paper.getPaperName();
            tmp.add(new AbstractMap.SimpleEntry<>(num,name));
        }

        return tmp;
        //通过老师userid，以及多个表的查询，找到这个老师出过的所有试卷（userid->classno->paper），把试卷编号和试卷名放进simpleentry，再放入arraylist返回
    }
//    public ArrayList<StudentModel> getAllStudent(String userId){
//
//        //通过老师userid，返回这个老师的所有学生，学生信息要完整，主要是userid、name、lessoninfo（很重要）。
//        LessonInfoModel tmp=new LessonInfoModel(new Date(),new Paper(1,"第一次测试卷",new Date(),null,null),null,50,47);
//        ArrayList<LessonInfoModel> tmp2=new ArrayList<LessonInfoModel>();
//        tmp2.add(tmp);
//        ArrayList<StudentModel> a=new ArrayList<>();
//        StudentModel tmp3=new StudentModel("201714","lklake",null,null,null,1,tmp2);
//        a.add(tmp3);
//        return a;
//    }
}
