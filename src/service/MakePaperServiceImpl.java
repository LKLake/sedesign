package service;

import bean.PaperBean;
import dao.DaoManager;
import dao.paper.PaperDao;

import dao.question.QuestionDao;
import dao.user.TeacherDao;
import model.Paper;

import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;

@Service("makePaperService")
public class MakePaperServiceImpl implements MakePaperService {


    public int savePaper(Paper paper,String userId){
        DaoManager dm=DaoManager.getInstance();
        TeacherDao teacherDao = dm.getDao(TeacherDao.class);
        PaperDao paperDao=dm.getDao(PaperDao.class);
        QuestionDao questionDao=dm.getDao(QuestionDao.class);
        int result=-1;
        int class_no = 0;
        String paper_name=paper.getPaperName();
        try {
            dm.begin();
            class_no=teacherDao.getClass_noByTeacherId(userId);
            dm.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dm.end();
        }
        if (class_no==-1)
            System.out.print("此处有问题MakePaperService");

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String join_date=sdf.format(paper.getJoinDate());

        PaperBean paperBean=new PaperBean();
        paperBean.setJoinDate(join_date);
        paperBean.setClassNo(class_no);
        paperBean.setPaperName(paper_name);
        try {
            dm.begin();
            result=paperDao.AddPaper(paperBean);
            dm.commit();
        }catch (Exception e)
        {
            e.printStackTrace();
        }finally {
            dm.end();
        }
        String paperId="-1";
        int single_res=-1;
        int multi_res=-1;
        if(result==1)
            try {
                dm.begin();
                paperId=paperDao.getPaperIdByPaperName(paper_name);
                single_res=questionDao.addSingleQuestion(paper.getSingleQuestionList(),paperId);
                multi_res=questionDao.addMultiQuestion(paper.getMultiQuestionList(),paperId);
                dm.commit();
            }catch (Exception e){e.printStackTrace();}
        finally {
                dm.end();
            }
        if(Integer.valueOf(paperId)==-1)
            System.out.println("paperId有问题");
        if (single_res==1)
            System.out.println("单选添加失败");
        if (multi_res==1)
            System.out.println("多选添加失败");
        if(multi_res==0&&single_res==0&&result==1)
        return 0;
        else
            return 1;

    }
}
