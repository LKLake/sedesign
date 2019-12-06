package dao.paper;

import bean.PaperBean;
import model.Paper;

import java.util.ArrayList;

public interface PaperDao {
    ArrayList<Paper> getPaperListByUserId(String userId) throws Exception;
    Paper getPaperByPaperId(int paperId) throws Exception;
    int AddPaper(PaperBean input);
}
