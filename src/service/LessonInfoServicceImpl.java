package service;


import bean.LessonInfoBean;
import dao.DaoManager;
import dao.exam.ExamDao;
import dao.paper.PaperDao;

import model.LessonInfoModel;
import model.Paper;

import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("lessonInfoService")
public class LessonInfoServicceImpl implements LessonInfoService {

    public ArrayList<LessonInfoModel> getAllExam(String userId)throws  Exception{

        //查询到对应的LessinfoModel
        DaoManager dm=DaoManager.getInstance();
        ExamDao examDao = dm.getDao(ExamDao.class);
        ArrayList<LessonInfoModel> tmp2=new ArrayList<>();
        List<LessonInfoBean> tmp1=null;
        try {
            dm.begin();
            tmp1=examDao.getExamByUserId(userId);
            dm.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            dm.end();
        }

        for (int i=0;i<tmp1.size();i++)
        {
            LessonInfoBean in=tmp1.get(i);
            tmp2.add(LessonInfoBean2LessoninfoModel(in));
        }

        return tmp2;
    }
    protected LessonInfoModel LessonInfoBean2LessoninfoModel(LessonInfoBean input) throws Exception
    {
        DaoManager dm=DaoManager.getInstance();
        PaperDao paperDao = dm.getDao(PaperDao.class);
        LessonInfoModel result=new LessonInfoModel();
        result.setMultiScore(input.getMultiScore());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date=sdf.parse(input.getExamDate());
        result.setAddedTime(date);
        result.setSingleScore(input.getSingleScore());
        Paper paper=null;
        try {
            dm.begin();
            paper =paperDao.getPaperByPaperId(input.getPaperId());
            dm.end();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            dm.end();
        }
        result.setPaper(paper);
    return  result;
    }
}
