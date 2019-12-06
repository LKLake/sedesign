package dao.question;

import bean.QuestionBean;
import dao.BaseDao;
import dao.PostgreSQL;
import model.Question;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Repository("questionDao")
public class QuestionDaoImp extends BaseDao implements  QuestionDao, PostgreSQL {
    public ArrayList<Question> getMultiQuestionListByPaperId(String paperId)
    {
        ArrayList<Question> result= new ArrayList<Question>();
        String sql ="select * from t_question where id=? and type='2'";
        List<QuestionBean> qb=new ArrayList<QuestionBean>();
        try {
            qb=esql.list(QuestionBean.class,sql,paperId);
        }catch (Exception e){e.printStackTrace();}
        for (int i=0;i<qb.size();i++)
        {
            QuestionBean tmpB=new QuestionBean();
            tmpB=qb.get(i);
            result.add(QuestionBean2Question(tmpB));
        }
        return result;
    }
    public ArrayList<Question> getSingleQuestionListByPaperId(String paperId)
    {

        ArrayList<Question> result= new ArrayList<Question>();
        String sql="select * from t_question where id=? and type='1'";
        List<QuestionBean> qb=new ArrayList<QuestionBean>();
        try {
            qb=esql.list(QuestionBean.class,sql,paperId);
        }catch (Exception e){e.printStackTrace();}
        for(int i=0;i<qb.size();i++)
        {
            QuestionBean tmpB=new QuestionBean();
            tmpB=qb.get(i);
            result.add(QuestionBean2Question(tmpB));
        }
        return  result;
    }
    protected Question QuestionBean2Question(QuestionBean input)
    {
        Question result=new Question();
        result.setAnswer(input.getAnswer());
        result.setId(input.getId());
        result.setOptionA(input.getOptionA());
        result.setOptionB(input.getOptionB());
        result.setOptionC(input.getOptionC());
        result.setOptionD(input.getOptionD());
        result.setContent(input.getContent());
        result.setType(Integer.parseInt(input.getType()));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date=sdf.parse(input.getAddedTime());
            result.setJoinTime(date);
        }catch (Exception e){e.printStackTrace();}

        return  result;
    }
}
