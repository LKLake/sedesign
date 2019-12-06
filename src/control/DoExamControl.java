package control;

import model.LessonInfoModel;
import model.Paper;
import model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.annotation.SessionScope;
import service.DoExamService;


import javax.servlet.http.HttpSession;

import java.util.*;

@Controller
@SessionScope
@RequestMapping("/doExam")
public class DoExamControl {
    private Paper currentPaper=null;
    private Map<Integer,String> currentAnswer= new HashMap<>() {
    };
    @Autowired
    @Qualifier("doExamService")
    private DoExamService doExamService;
    @RequestMapping(params = "action=submit")
    public String onSubmit(HttpSession session,Model model,String[] singleAnswer,String[] multiAnswer,String[] questionId){
        UserModel currentUser=(UserModel) session.getAttribute("currentUser");
        for(int i=0;i<singleAnswer.length;i++){
            currentAnswer.put(Integer.parseInt(questionId[i]),singleAnswer[i]);
        }
        StringBuilder answer= new StringBuilder();
        int index=0;
        int ansNo=singleAnswer.length;
        while(index<multiAnswer.length){
            if("|".equals(multiAnswer[index])){
                currentAnswer.put(Integer.parseInt(questionId[ansNo]), answer.toString());
                answer = new StringBuilder();
                ansNo++;
            }
            else{
                answer.append(multiAnswer[index]);
            }
            index++;
        }
        ArrayList<Integer> scoreList=doExamService.calcuResult(currentPaper,currentAnswer);
        doExamService.saveLessonInfo(currentUser.getUserId(),new LessonInfoModel(new Date(),currentPaper,currentAnswer,scoreList.get(0),scoreList.get(1)));
        model.addAttribute("score",scoreList.get(0)+scoreList.get(1));
        return "lessonCenter/myExam";
    }
    @RequestMapping(params = "action=getAvailablePaper",method = RequestMethod.GET)
    public String onGetAvailablePaper(HttpSession session, Model model){
        List<AbstractMap.SimpleEntry<Integer,String>> avaliablePaperList=doExamService.findAvailablePaper(
                ((UserModel) session.getAttribute("currentUser")).getUserId());
        model.addAttribute("availablePaperList",avaliablePaperList);
        return "lessonCenter/selectPaper";
    }
    @RequestMapping(params = "action=getPaperContent",method = RequestMethod.POST)
    public String onGetPaperContent(int paperId,Model model){
        if(this.currentPaper==null){
            this.currentPaper=doExamService.getPaperCotent(paperId);
        }
        model.addAttribute("paper",this.currentPaper);
        return "lessonCenter/doExam";
    }
}