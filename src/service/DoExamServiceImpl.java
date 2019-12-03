package service;

import dao.exam.ExamDao;

import model.LessonInfoModel;
import model.Paper;
import model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("doExamService")
public class DoExamServiceImpl implements DoExamService {
    @Autowired
    @Qualifier("ExamDao")
    private ExamDao examDao;


    public List<AbstractMap.SimpleEntry<Integer,String>> findAvailablePaper(String userId){
        ArrayList<AbstractMap.SimpleEntry<Integer,String>>paperList= new ArrayList<>();
        AbstractMap.SimpleEntry<Integer,String> a=new AbstractMap.SimpleEntry<>(1,"第一次测试卷");
        paperList.add(a);
        return paperList;
        //TODO implement
        //输入userId，从student表找到classno，查paper表找到所有paper，将paperid和名字组合为simpleentry，放入arraylist返回

    }

    @Override
    public Paper getPaperCotent(int paperId) {
        //TODO implement
        //输入paperId,从question表返回题目，要把题目分为单选多选，生成paper返回。
        Paper paper=new Paper();
        paper.setJoinDate(new Date());
        paper.setPaperName("第一次测试卷假");
        ArrayList<Question> singleQuestion=new ArrayList<>();
        Question a=new Question(1,"题目内容",1,new Date(),"AA","BB","CC","DD","A");
        singleQuestion.add(a);
        paper.setMultiQuestionList(singleQuestion);
        paper.setSingleQuestionList(singleQuestion);
        return paper;
    }
    public void saveLessonInfo(LessonInfoModel lessonInfoModel){
        return;
        //TODO implement
    }
    public ArrayList<Integer> calcuResult(Paper paper,Map<Integer,String > currentAnswer){
        ArrayList<Integer>tmp=new ArrayList<>();
        tmp.add(40);
        tmp.add(50);
        return tmp;
        //TODO implement
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
