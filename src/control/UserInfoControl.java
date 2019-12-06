package control;

import model.StudentModel;
import model.TeacherModel;
import model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.context.annotation.SessionScope;
import service.ChangePasswordService;
import service.LoginService;

import javax.servlet.http.HttpSession;


@Controller
@SessionScope
@RequestMapping("/userCenter")
public class UserInfoControl {
    @Autowired
    @Qualifier("loginService")
    private LoginService loginService;

    @Autowired
    @Qualifier("changePasswordService")
    private ChangePasswordService changePasswordService;

    private String identity;
    private UserModel userModel;
    @RequestMapping(params = "action=login")
    public String onLogin(String userId, String password, HttpSession session, String identityFlag, Model model) {

        if("teacher".equals(identityFlag)){
            identity="teacher";
        }
        else{
            identity="student";
        }
        this.userModel=loginService.userLogin(userId, password,identity);
        if(userModel==null ){
            model.addAttribute("loginState","用户名或密码错误");
            return "userCenter/login";
        }

        else {
            if("teacher".equals(identity)){
                TeacherModel teacher = new TeacherModel(userModel.getUserId(),userModel.getName(),null,null,null);
                this.userModel=teacher;
                session.setAttribute("currentUser", teacher);
                session.setAttribute("currentUserIdentity","teacher");
                return "state/main";
            }
            else{
                StudentModel student = new StudentModel(userModel.getUserId(),userModel.getName(),null,userModel.getPassword(),null,-1,null);
                this.userModel=student;
                session.setAttribute("currentUser", student);
                session.setAttribute("currentUserIdentity","student");
                return "state/main";
            }
        }
    }
    @RequestMapping(params = "action=logout")
    public String logout(HttpSession session){
        this.userModel=null;
        this.loginService=null;
        session.invalidate();
        return "userCenter/login";
    }
    @RequestMapping(params = "action=changePassword")
    public String onChangePassword(String rawPassword,String newPassword){
        int ret=changePasswordService.changePassword(userModel.getUserId(),rawPassword,newPassword,identity);
        if(ret==0){
            return "state/updateSuccess";
        }
        else{
            return "userCenter/updatePassword";
        }
    }
}

