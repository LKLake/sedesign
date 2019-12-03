package control;

import model.LessonInfoModel;
import model.StudentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.annotation.SessionScope;
import service.LessonInfoService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
@SessionScope
@RequestMapping("/lessonInfo")
public class LessonInfoControl {
    @Autowired
    @Qualifier("lessonInfoService")
    LessonInfoService lessonInfoService;
    @RequestMapping(params = "action=queryScore")
    public String onQueryScore(HttpSession session, Model model){
        StudentModel studentModel=(StudentModel) session.getAttribute("currentUser");
        ArrayList<LessonInfoModel>lessonInfoModelArrayList=lessonInfoService.getAllExam(studentModel.getUserId());
        model.addAttribute("examList",lessonInfoModelArrayList);
        return "myExam";
    }
}
