package service;

import dao.DaoManager;
import dao.exam.ExamDao;
import dao.paper.PaperDao;
import dao.question.QuestionDao;

import model.LessonInfoModel;
import model.Paper;
import model.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("doExamService")
public class DoExamServiceImpl implements DoExamService {


    public List<AbstractMap.SimpleEntry<Integer,String>> findAvailablePaper(String userId){
        DaoManager dm=DaoManager.getInstance();
        PaperDao paperDao = dm.getDao(PaperDao.class);
        ArrayList<AbstractMap.SimpleEntry<Integer,String>>paperList= new ArrayList<>();
        List<Paper> paperListTemp = null;

        try
        {
            dm.begin();
            paperListTemp = paperDao.getPaperListByUserId(userId);
            dm.commit();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            dm.end();
        }
        int paper_id;
        String paper_name;
        for (int i=0;i<paperListTemp.size();i++)
        {
            Paper paper=paperListTemp.get(i);
            paper_name=paper.getPaperName();
            paper_id=paper.getPaperId();
            AbstractMap.SimpleEntry<Integer,String> a=new AbstractMap.SimpleEntry<>(paper_id,paper_name);
            paperList.add(a);
        }
        return paperList;

        //输入userId，从student表找到classno，查paper表找到所有paper，将paperid和名字组合为simpleentry，放入arraylist返回

    }

    @Override
    public Paper getPaperCotent(int paperId) {

        DaoManager dm=DaoManager.getInstance();
        PaperDao paperDao = dm.getDao(PaperDao.class);
        QuestionDao questionDao=dm.getDao(QuestionDao.class);
        //输入paperId,从question表返回题目，要把题目分为单选多选，生成paper返回。
        Paper paper=null;
        try {
            dm.begin();
            paper=paperDao.getPaperByPaperId(paperId);
            dm.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dm.end();
        }
        ArrayList<Question> singleQuestion=new ArrayList<>();
        try{
            dm.begin();
            singleQuestion=questionDao.getSingleQuestionListByPaperId(String.valueOf(paperId));
            dm.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dm.end();
        }
        paper.setMultiQuestionList(singleQuestion);
        ArrayList<Question> multiQuestion=new ArrayList<>();
        try {
            dm.begin();
            multiQuestion=questionDao.getMultiQuestionListByPaperId(String.valueOf(paperId));
            dm.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dm.end();
        }

        paper.setSingleQuestionList(singleQuestion);
        paper.setMultiQuestionList(multiQuestion);
        return paper;
    }

    public int saveLessonInfo(String userId,LessonInfoModel lessonInfoModel){
        DaoManager dm=DaoManager.getInstance();
        ExamDao examDao = dm.getDao(ExamDao.class);
        int saveExam=-1;
        int saveAnswer=-1;
        try {
            dm.begin();
            saveExam=examDao.SaveExam(userId, lessonInfoModel);
            saveAnswer=examDao.SaveAnwser(userId,lessonInfoModel.getMyAnswer());
            dm.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            dm.end();
        }

        if(saveExam==0&&saveAnswer==0)
        return  0;
        else
            return 1;
        //将lessonInfoModel保存，应将信息存入lesson_info 和answer表，成功返回0,失败1

    }

    public ArrayList<Integer> calcuResult(Paper paper,Map<Integer,String > currentAnswer){
        ArrayList<Integer>tmp=new ArrayList<>();
        int SingleScore=0;
        int MultiScore=0;
        int Anwer_id=0;
        String Answer=null;
        String StandardAnswer=null;
        //获取paper的singlequestionlist循环获取列表题目，比较答案
        Question question=null;
        for (int i=0;i<paper.getSingleQuestionList().size();i++)
        {  //计算单选成绩
            question=paper.getSingleQuestionList().get(i);
            Answer=currentAnswer.get(Anwer_id);
            StandardAnswer=question.getAnswer();
            Anwer_id++;
            if(StandardAnswer.equals(Answer))
                SingleScore++;
        }
        tmp.add(SingleScore);
        //计算多选成绩
        for (int i=0;i<paper.getMultiQuestionList().size();i++)
        {  //计算单选成绩
            question=paper.getMultiQuestionList().get(i);
            Answer=currentAnswer.get(Anwer_id);
            StandardAnswer=question.getAnswer();
            Anwer_id++;
            if(StandardAnswer.equals(Answer))
                MultiScore++;
        }
        tmp.add(MultiScore);
        return tmp;

        //currentAnswer为题号和答案的map，计算paper里单选和多选的成绩，依次存入arraylist返回。
    };


    /*@Override
    public int calcuResult(Map<String, String[]> keyMap) throws Exception {
        Iterator<Map.Entry<String, String[]>> it2 = keyMap.entrySet().iterator();
        int totalScore = 0;
        int singleScore = 0;
        int moreScore = 0;
        while (it2.hasNext()) {
            Map.Entry<String, String[]> entry = it2.next();
            String keyStr = entry.getKey();
            String values[] = entry.getValue();
            String key;
            String value = "";
            if (keyStr.equals("exam.student.id") || keyStr.equals("exam.paper.id")) {
                continue;
            }
            if (keyStr.split("-")[1].equals("r")) {  // 单选
                key = keyStr.split("-")[2];
                value = values[0];
                singleScore += this.calScore(key, value, "1");
            } else {  // 多选
                key = keyStr.split("-")[2];
                for (String s : values) {
                    value += s + ",";
                }
                value = value.substring(0, value.length() - 1);
                moreScore += this.calScore(key, value, "2");
            }
        }
        totalScore = singleScore + moreScore;
        exam.setSingleScore(singleScore);
        exam.setMoreScore(moreScore);
        exam.setScore(totalScore);
        exam.setExamDate(new Date());
        examDao.saveExam(exam);
    }
    private int calScore(String questionId,String userAnswer,String type)throws Exception{
        Question question=questionDao.getQuestion(questionId);
        if(userAnswer.equals(question.getAnswer())){
            if("1".equals(type)){
                return 20;
            }else{
                return 30;
            }
        }else{
            return 0;
        }
    }*/
}
