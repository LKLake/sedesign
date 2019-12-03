package control;

import model.StudentModel;
import model.TeacherModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.annotation.SessionScope;
import service.ClassInfoService;

import javax.servlet.http.HttpSession;

import org.json.*;

@Controller
@SessionScope
@RequestMapping("/classInfo")
public class ClassInfoControl {
    @Autowired
    @Qualifier("classInfoService")
    ClassInfoService classInfoService;
    TeacherModel teacher=null;
    @RequestMapping(params = "action=listStudentInfo")
    public String onFindStudent(HttpSession session, Model model){
        String userIdentity=(String) session.getAttribute("currentUserIdentity");
        if("teacher".equals(userIdentity)){
            this.teacher=(TeacherModel) session.getAttribute("currentUser");
            teacher.setStudentModelList(classInfoService.getStudent(teacher.getUserId()));
            model.addAttribute("studentList",teacher.getStudentModelList());
        }
        return "studentList";
    }
    @RequestMapping(params = "action=changeStudentInfo")
    @ResponseBody
    public String onChangeStudentInfo(@RequestBody String str){
        JSONObject a=new JSONObject(str);
        String userId=(String) a.get("userId");
        String name=(String) a.get("name");
        String password=(String) a.get("password");
        String sex=(String) a.get("sex");
        String major=(String) a.get("major");
        String classNo=(String) a.get("classNo");
        if(0==classInfoService.changeStudentInfo(userId,name,sex,password,major,classNo))
            return "modefied_success";
        else
            return "modefied_faliled";
    }
    @RequestMapping(params = "action=deleteStudentInfo")
    @ResponseBody
    public String onDeleteStudentInfo(@RequestBody String str){
        JSONObject a=new JSONObject(str);
        String userId=(String) a.get("userId");
        String name=(String) a.get("name");
        if(0==classInfoService.deleteStudentInfo(userId,name))
            return "delete_success";
        else
            return "delete_faliled";
    }
    @RequestMapping(params = "action=addStudent")
    public String onAddStudent(StudentModel studentModel, Model model){
        if(0==classInfoService.addStudentInfo(studentModel)){
            model.addAttribute("state","添加成功");
            return "studentSave";
        }
        else{
            model.addAttribute("state","添加失败");
            return "studentSave";
        }
    }
    @RequestMapping(params = "action=getStudentScore")
    public String onGetStudentScore(HttpSession session,Model model){
        TeacherModel currentUser=(TeacherModel)session.getAttribute("currentUser");
        model.addAttribute("paperList",classInfoService.getClassPaper(currentUser.getUserId()));
        model.addAttribute("studentList",classInfoService.getAllStudent(currentUser.getUserId()));
        return "studentScore";
    }
}
