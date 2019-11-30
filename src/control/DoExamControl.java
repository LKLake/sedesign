package control;

import bean.UserBean;
import model.ExamModel;
import model.Paper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.servlet.ModelAndView;
import service.DoExamService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@SessionScope
@RequestMapping("/doExam")
public class DoExamControl {
    private Paper currentPaper=null;
    private Map<Integer,String> currentAnswer=null;
    @Autowired
    @Qualifier("doExamService")
    private DoExamService doExamService;
    @RequestMapping(params = "action=submit")
    public String onSubmit(HttpServletRequest request,Model model){
        doExamService.saveExam(new ExamModel(currentPaper.getPaperName()),currentAnswer);
        int score=doExamService.calcuResult(currentPaper,currentAnswer);
//        Map<String, String[]> keyMap = new HashMap<String, String[]>();
//        keyMap = request.getParameterMap();
        //TODO implement
        model.addAttribute("score",score);
        return "examResult";
    }
    @RequestMapping(params = "action=getAvailablePaper",method = RequestMethod.GET)
    public String onGetAvailablePaper(HttpSession session, Model model){
        List<ExamModel> avaliablePaperList=doExamService.findAvailablePaper(
                (String) session.getAttribute("currentUserId"));
        model.addAttribute("availablePaperList",avaliablePaperList);
        return "selectPaper";
    }
    @RequestMapping(params = "action=getPaperContent",method = RequestMethod.POST)
    public String onGetPaperContent(int paperId,Model model){
        if(this.currentPaper==null){
            this.currentPaper=doExamService.getPaperCotent(paperId);
        }
        model.addAttribute("paper",this.currentPaper);
        return "doExam";
    }
}
