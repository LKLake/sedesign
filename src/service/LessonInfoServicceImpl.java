package service;


import model.LessonInfoModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service("lessonInfoService")
public class LessonInfoServicceImpl implements LessonInfoService {
    public ArrayList<LessonInfoModel> getAllExam(String userId){
        //TODO implement
        LessonInfoModel tmp=new LessonInfoModel();
        tmp.setId(1);
        tmp.setAddedTime(new Date());
        tmp.setScore(97);
        tmp.setSingleScore(40);
        tmp.setMultiScore(57);
        ArrayList<LessonInfoModel> tmp2=new ArrayList<>();
        tmp2.add(tmp);
        return tmp2;
    }
}
