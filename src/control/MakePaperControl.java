package control;


import model.Paper;
import model.Question;
import model.TeacherModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.annotation.SessionScope;
import service.MakePaperService;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;

@Controller
@SessionScope
@RequestMapping("/makePaper")
public class MakePaperControl {
    @Autowired
    @Qualifier("makePaperService")
    private MakePaperService makePaperService;

    @RequestMapping(params = "action=saveNewPaper")
    public String onSaveNewPaper(HttpSession session, Model model,String[] content,String[] option_a,
                                 String[] option_b,String[] option_c,String[] option_d,String[] answer,
                                 String[] question_type,String paperName ){
        TeacherModel currentUser=(TeacherModel)session.getAttribute("currentUser");
        ArrayList<Question> singleQuestionList=new ArrayList<>();
        ArrayList<Question> multiQuestionList=new ArrayList<>();
        for (int i=0;i<content.length;i++){
            Question question=new Question(0,content[i],Integer.parseInt(question_type[i]),new Date(),
                    option_a[i],option_b[i],option_c[i],option_d[i],answer[i]);
            if("0".equals(question_type[i])){
                singleQuestionList.add(question);
            }
            else{
                multiQuestionList.add(question);
            }
        }

        Paper paper=new Paper(-1,paperName, new Date(),singleQuestionList,multiQuestionList);
        if(0==makePaperService.savePaper(paper,currentUser.getUserId())){
            model.addAttribute("state","add_success");
        }
        else{
            model.addAttribute("state","add_failed");
        }
        return "state/state";

    }
}
