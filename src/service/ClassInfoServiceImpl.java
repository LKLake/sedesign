package service;


import model.StudentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;

@Service("classInfoService")
public class ClassInfoServiceImpl implements ClassInfoService {
    /*@Autowired
    @Qualifier("studentDao")*/
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
    public int changeStudentInfo(StudentModel studentModel){
        return 0;//表示修改成功
        //TODO implement
    }
}
