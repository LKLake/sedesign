package dao.paper;

import bean.PaperBean;
import dao.BaseDao;
import dao.PostgreSQL;
import model.Paper;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository("paperDao")
public class PaperDaoImp extends BaseDao implements PaperDao, PostgreSQL {
    public ArrayList<Paper> getPaperListByClassId(String class_no) throws Exception {

        ArrayList<Paper> result = new ArrayList<>();
        List<PaperBean> paperList;
        String sql="select * from t_paper where class_no=?";
        paperList=esql.list(PaperBean.class,sql,class_no);
        for(int i=0;i<paperList.size();i++)
        {
            //从List获取对象，可能有问题？
            PaperBean tmpB=new PaperBean();
            tmpB=paperList.get(i);
            result.add(PaperBean2Paper(tmpB));
            //可能需要释放空间？
        }
        return result;
    }

    public Paper getPaperByPaperId(int paperId)throws Exception
    {
        String sql="select * from t_paper where id=?";
        return PaperBean2Paper(esql.query(PaperBean.class,sql,paperId));
    }

    @Override
    public int AddPaper(PaperBean input) {
        int result=0;
        String class_no=String.valueOf(input.getClassNo());
        String join_date=input.getJoinDate();
        String paper_name=input.getPaperName();

        PaperBean paperBean =new PaperBean();
        paperBean.setPaperName(paper_name);
        paperBean.setJoinDate(join_date);
        paperBean.setClassNo(Integer.parseInt(class_no));
        try {
            result=esql.insert(paperBean,"t_paper","","id");
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String getPaperIdByPaperName(String paperName) {
        String paperId;
        PaperBean paperBean=new PaperBean();
        String sql="select * from t_paper where paper_name=?";
        try {
            paperBean=esql.query(PaperBean.class,sql,paperName);
        }catch (Exception e){e.printStackTrace();}
        paperId=String.valueOf(paperBean.getId());
        return paperId;
    }

    protected Paper PaperBean2Paper(PaperBean tmpB)
{
    Paper tmpP=new Paper();
    tmpP.setPaperName(tmpB.getPaperName());
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    try {
        Date date=sdf.parse(tmpB.getJoinDate());
        tmpP.setJoinDate(date);
        tmpP.setPaperName(tmpB.getPaperName());
        tmpP.setPaperId(tmpB.getId());

    }catch (Exception e){e.printStackTrace();}

    return tmpP;
}
}
