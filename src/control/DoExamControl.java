package control;

import bean.UserBean;
import model.ExamModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import service.DoExamService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/doExam")
public class DoExamControl {
    @Autowired
    @Qualifier("doExamService")
    private DoExamService doExamService;
    @RequestMapping("submit")
    public void controlExamSubmit(HttpServletRequest request){
        Map<String, String[]> keyMap = new HashMap<String, String[]>();
        keyMap = request.getParameterMap();
    }
    @RequestMapping(params = "method=getAvailablePaper",method = RequestMethod.GET)
    public String onGetAvailablePaper(HttpSession session, Model model){
        List<ExamModel> avaliablePaperList=doExamService.findAvailablePaper(
                (String) session.getAttribute("currentUserId"));
        model.addAttribute("availablePaperList",avaliablePaperList);
        return "selectPaper";
    }
}
