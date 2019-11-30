package service;

import model.ExamModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service("lessonInfoService")
public class LessonInfoServicceImpl implements LessonInfoService {
    public ArrayList<ExamModel> getAllExam(String userId){
        //TODO implement
        ExamModel tmp=new ExamModel();
        tmp.setId(1);
        tmp.setAddedTime(new Date());
        tmp.setScore(97);
        tmp.setSingleScore(40);
        tmp.setMultiScore(57);
        ArrayList<ExamModel> tmp2=new ArrayList<>();
        tmp2.add(tmp);
        return tmp2;
    }
}
