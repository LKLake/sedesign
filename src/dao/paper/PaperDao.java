package dao.paper;

import bean.PaperBean;
import model.Paper;

import java.util.ArrayList;

public interface PaperDao {
    ArrayList<Paper> getPaperListByClassId(String class_no) throws Exception;
    Paper getPaperByPaperId(int paperId) throws Exception;
    int AddPaper(PaperBean input);
    String getPaperIdByPaperName(String paperName);
}
