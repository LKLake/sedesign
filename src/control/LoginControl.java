package control;

import model.StudentModel;
import model.TeacherModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import service.LoginService;

import javax.servlet.http.HttpSession;

@Controller
public class LoginControl {
    @Autowired
    @Qualifier("loginService")
    private LoginService loginService;

    @RequestMapping("/login")
    public String control(String userId, String password, HttpSession session,String identity) {
        if( ! loginService.userLogin(userId, password,identity))
            return "../login";
        else {
            if("student".equals(identity)){
                StudentModel student = new StudentModel(loginService.getUserName(),loginService.getUserId());
                session.setAttribute("currentUserName", student.getName());
                session.setAttribute("currentUserId",student.getUserId());
                session.setAttribute("currentUserIdentity","student");
                return "main";
            }
            else{
                TeacherModel teacher = new TeacherModel(loginService.getUserName(),loginService.getUserId());
                session.setAttribute("currentUser", teacher);
                session.setAttribute("currentUserName", teacher.getName());
                session.setAttribute("currentUserId",teacher.getUserId());
                session.setAttribute("currentUserIdentity","teacher");
                return "main";
            }
        }
    }
}

