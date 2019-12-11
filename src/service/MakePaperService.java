package service;

import model.Paper;

public interface MakePaperService {
    public int savePaper(Paper paper, String userId);
}
