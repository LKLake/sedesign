package service;


import dao.user.StudentDao;
import model.LessonInfoModel;
import model.Paper;
import model.StudentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("classInfoService")
public class ClassInfoServiceImpl implements ClassInfoService {
    @Autowired
    @Qualifier("studentDao")
    private StudentDao studentDao;

    @Override
    public ArrayList<StudentModel> getStudent(String teacherId){
        //TODO implement
        StudentModel tmp=new StudentModel("201714","张三",
                "男","password","计算机科学与技术","行政四班",null);
        ArrayList<StudentModel> tmp2=new ArrayList<>();
        tmp2.add(tmp);
        tmp.setName("李四");
        tmp2.add(tmp);
        return tmp2;
    }
    @Override
    public int changeStudentInfo(String userId,String name,String sex,String password,String major,String classNo){
        return 0;//表示修改成功
        //TODO implement
    }
    @Override
    public int deleteStudentInfo(String userId,String name){
        return 0;
        //TODO implement
    }

    @Override
    public int addStudentInfo(StudentModel student) {
        System.out.println("添加的学生名："+student.getName());
        return 0;
        //TODO implement
    }
    public ArrayList<Paper> getClassPaper(String userId){
        //TODO implement 可以只填写paper.id和paper.name
        ArrayList<Paper >tmp=new ArrayList<>();
        tmp.add(new Paper(1,"第一次测试卷"));
        return tmp;
    }
    public ArrayList<StudentModel> getAllStudent(String userId){
        //TODO implement
        LessonInfoModel tmp=new LessonInfoModel(new Paper(1,"第一次测试卷"),null,97,50,47);
        ArrayList<LessonInfoModel> tmp2=new ArrayList<LessonInfoModel>();
        tmp2.add(tmp);
        ArrayList<StudentModel> a=new ArrayList<>();
        StudentModel tmp3=new StudentModel("201714","lklake",null,null,null,null,tmp2);
        a.add(tmp3);
        return a;
    }
}
