package service;

import bean.ExamBean;
import dao.exam.ExamDao;

import model.ExamModel;
import model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("doExamService")
public class DoExamServiceImpl implements DoExamService {
    public List<ExamModel> findAvailablePaper(String userId){
        ArrayList<ExamModel>examModelList=new ArrayList<ExamModel>();
        ExamModel tmp=new ExamModel();
        tmp.setName("第一次测试卷");
        tmp.setId(1);
        tmp.setAddedTime("2019-10-10 10-10-10");
        examModelList.add(tmp);
        return examModelList;
        //TODO implement
    }
    /*@Autowired
    @Qualifier("ExamDao")
    private ExamDao examDao;
    public List<Question> getPaper(String userId) throws Exception {
        List<ExamBean> examEntityList= examDao.getExamByUserId(userId);
    }
    public void onSubmit_exam(){

    }

    @Override
    public int getResult(Map<String, String[]> keyMap) throws Exception {
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
    }
    public Map<String,String> findAvailablePaper(String userId){

    }*/
}
