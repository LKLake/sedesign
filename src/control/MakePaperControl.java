package control;

import model.Paper;
import model.TeacherModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.annotation.SessionScope;

import service.MakePaperService;

import javax.servlet.http.HttpSession;

@Controller
@SessionScope
@RequestMapping("/makeExam")
public class MakePaperControl {
    @Autowired
    @Qualifier("makePaperService")
    private MakePaperService makePaperService;

    @RequestMapping(params = "action=saveNewPaper")
    public String onGetStudentScore(HttpSession session, Model model, Paper paper){
//        TeacherModel currentUser=(TeacherModel)session.getAttribute("currentUser");
        if(0==makePaperService.savePaper(paper)){
            model.addAttribute("state","add_success");
        }
        else{
            model.addAttribute("state","add_failed");
        }
        return "state";

    }
}
