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
        String sql ="select * from t_question where paper_id=? and type=1";
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

    @Override
    public int addMultiQuestion(ArrayList<Question> multiQuestionList,String paperId) {
        int result=0;
        int num=0;
        Question question;
        QuestionBean questionBean;

        for(int i=0;i<multiQuestionList.size();i++)
        {
            question=multiQuestionList.get(i);
            questionBean=Question2QuestionBean(question);
            questionBean.setPaperId(Integer.valueOf(paperId));
            try {
                result=esql.insert(questionBean,"t_question","","id");
            }catch (Exception e){e.printStackTrace();}
            if(result==1)
                num+=1;
            else
                continue;;

        }
        if(num!=multiQuestionList.size())
            return 1;//插入问题失败
        else
            return 0;
    }

    public ArrayList<Question> getSingleQuestionListByPaperId(String paperId)
    {

        ArrayList<Question> result= new ArrayList<Question>();
        String sql="select * from t_question where paper_id=? and type=0";
        List<QuestionBean> qb=null;
        try {
            qb=esql.list(QuestionBean.class,sql,paperId);
        }catch (Exception e){e.printStackTrace();}
        for(int i=0;i<qb.size();i++)
        {
            QuestionBean tmpB;
            tmpB=qb.get(i);
            result.add(QuestionBean2Question(tmpB));
        }
        return  result;
    }

    public int addSingleQuestion(ArrayList<Question> singleQuestionList,String paperId) {
        int result=0;
        int num=0;
        Question question;
        QuestionBean questionBean;

        for(int i=0;i<singleQuestionList.size();i++)
        {
            question=singleQuestionList.get(i);
            questionBean=Question2QuestionBean(question);
            questionBean.setPaperId(Integer.valueOf(paperId));
            try {
                result=esql.insert(questionBean,"t_question","","");
            }catch (Exception e){e.printStackTrace();}
            if(result==1)
                num+=1;
            else
                continue;;

        }
        if(num!=singleQuestionList.size())
            return 1;//插入问题失败
        else
            return 0;
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
    protected QuestionBean Question2QuestionBean(Question input)
    {
        QuestionBean result=new QuestionBean();
        result.setAnswer(input.getAnswer());
        result.setContent(input.getContent());
        result.setId(input.getId());
        result.setOptionA(input.getOptionA());
        result.setOptionB(input.getOptionB());
        result.setOptionC(input.getOptionC());
        result.setOptionD(input.getOptionD());
        result.setType(String.valueOf(input.getType()));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            String date=sdf.format(input.getJoinTime());
            result.setAddedTime(date);
        }catch (Exception e){e.printStackTrace();}

        return result;
    }
}
