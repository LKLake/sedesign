package control;

import model.StudentModel;
import model.TeacherModel;
import model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.annotation.SessionScope;
import service.LoginService;

import javax.servlet.http.HttpSession;

@Controller
@SessionScope
public class LoginControl {
    @Autowired
    @Qualifier("loginService")
    private LoginService loginService;
    private UserModel userModel;
    @RequestMapping("/login")
    public String onLogin(String userId, String password, HttpSession session,String identity) {
        this.userModel=loginService.userLogin(userId, password,identity);
        if(userModel==null )
            return "../login";
        else {
            if("student".equals(identity)){
                StudentModel student = new StudentModel(userModel.getUserId(),userModel.getName());
                this.userModel=student;
                session.setAttribute("currentUser", student);
                return "main";
            }
            else{
                TeacherModel teacher = new TeacherModel(userModel.getUserId(),userModel.getName());
                this.userModel=teacher;
                session.setAttribute("currentUser", teacher);
                session.setAttribute("currentUserName", teacher.getName());
                session.setAttribute("currentUserId",teacher.getUserId());
                session.setAttribute("currentUserIdentity","teacher");
                return "main";
            }
        }
    }
}

