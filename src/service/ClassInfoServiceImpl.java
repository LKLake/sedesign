package service;


import dao.user.StudentDao;
import model.LessonInfoModel;
import model.Paper;
import model.StudentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Date;

@Service("classInfoService")
public class ClassInfoServiceImpl implements ClassInfoService {
    @Autowired
    @Qualifier("studentDao")
    private StudentDao studentDao;

    @Override
    public ArrayList<StudentModel> getStudent(String teacherId){
        //TODO implement
        //通过老师id，查找classinfo，获得classno，查找student表，获得student，整理成studentmodel，放进arraylist，没有的属性置null，没有的整型属性置-1。
        StudentModel tmp=new StudentModel("201714","张三",
                "男","password","计算机科学与技术",1,null);
        ArrayList<StudentModel> tmp2=new ArrayList<>();
        tmp2.add(tmp);
        tmp.setName("李四");
        tmp2.add(tmp);
        return tmp2;
    }
    @Override
    public int changeStudentInfo(String userId,String name,String sex,String password,String major,String classNo){
        return 0;//表示修改成功,1修改失败
        //TODO implement
        //通过userid可以确定这个学生，然后修改student表，目前先别cascade，出现冲突就返回1吧。
    }
    @Override
    public int deleteStudentInfo(String userId,String name){
        return 0;
        //TODO implement
        //通过userid可以确定这个学生，然后修改student表，目前先别cascade，出现冲突就返回1吧。
    }

    @Override
    public int addStudentInfo(StudentModel student) {
        return 0;
        //TODO implement
        //把studentmodel里能添的信息都添加进student表，注意检查外键，报错就返回1
    }
    public ArrayList<AbstractMap.SimpleEntry<Integer,String>> getClassPaper(String userId){
        ArrayList<AbstractMap.SimpleEntry<Integer,String>>tmp=new ArrayList<>();
        tmp.add(new AbstractMap.SimpleEntry<>(1,"第一次测试卷"));
        return tmp;
        //TODO implement
        //通过老师userid，以及多个表的查询，找到这个老师出过的所有试卷（userid->classno->paper），把试卷编号和试卷名放进simpleentry，再放入arraylist返回
    }
    public ArrayList<StudentModel> getAllStudent(String userId){
        //TODO implement
        //通过老师userid，返回这个老师的所有学生，学生信息要完整，主要是userid、name、lessoninfo（很重要）。
        LessonInfoModel tmp=new LessonInfoModel(new Date(),new Paper("第一次测试卷",new Date(),null,null),null,50,47);
        ArrayList<LessonInfoModel> tmp2=new ArrayList<LessonInfoModel>();
        tmp2.add(tmp);
        ArrayList<StudentModel> a=new ArrayList<>();
        StudentModel tmp3=new StudentModel("201714","lklake",null,null,null,1,tmp2);
        a.add(tmp3);
        return a;
    }
}
