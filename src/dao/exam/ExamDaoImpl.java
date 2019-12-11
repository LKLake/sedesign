package dao.exam;

import bean.AnswerBean;
import bean.LessonInfoBean;
import dao.BaseDao;
import dao.PostgreSQL;
import model.LessonInfoModel;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.*;

@Repository("examDao")
public class ExamDaoImpl extends BaseDao implements ExamDao, PostgreSQL {
    public List<LessonInfoBean> getExamByUserId(String userId){
        List<LessonInfoBean> examList=new ArrayList<>();
        String sql="select * from t_lesson_info where student_id=?";
        try {
            examList= esql.list(LessonInfoBean.class, sql,userId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return examList;
    }

    @Override
    public int  SaveExam(String userId,LessonInfoModel input) {
        int result=0;
        LessonInfoBean lessonInfoBean=new LessonInfoBean();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date=sdf.format(input.getAddedTime());
        lessonInfoBean.setExamDate(date);
        lessonInfoBean.setMultiScore(input.getMultiScore());
        lessonInfoBean.setPaperId(input.getPaper().getPaperId());
        lessonInfoBean.setSingleScore(input.getSingleScore());
        lessonInfoBean.setStudentId(userId);
        String table="t_lesson_info";
        String include="";
        String exclude="";
        try
        {
            result=esql.insert(lessonInfoBean,table,"","id");
        }catch (Exception e){
            e.printStackTrace();
        }
            return result;
    }

    @Override
    public int SaveAnwser(String LessonInfoId,Map<Integer,String> map) {
        int result=-1;
        String question_id;
        String anwser;
        String table="t_answer";
        AnswerBean answerBean=new AnswerBean();
        Set<Map.Entry<Integer, String>> entrys = map.entrySet();
        for (Map.Entry<Integer,String> entry:entrys)
        {
            answerBean.setAnswer(entry.getValue());
            answerBean.setQuestionId(entry.getKey());
            answerBean.setLessonInfoId(Integer.valueOf(LessonInfoId));
            try {
                result=esql.insert(answerBean,table,"","");
            }catch (Exception e)
            {
                e.printStackTrace();
            }
        }



        return result;
    }

    public String getLessonInfoIdByUserIdAndPaperId(String userId,String paperId)
    {
        LessonInfoBean lessonInfoBean=null;
        String result=null;
        String sql="select * from t_lesson_info where student_id=?";
        try {
            lessonInfoBean=esql.query(LessonInfoBean.class,sql,userId);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        result=String.valueOf(lessonInfoBean.getId());
        return result;
    }
}
