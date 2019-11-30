package bean;


public class ExamBean {
    private String id;
    private String exam_date;
    private int multi_score;
    private int single_score;
    private int score;
    private int paper_id;
    private String student_id;

    public ExamBean(){}
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getExam_date() {
        return exam_date;
    }

    public void setExam_date(String exam_date) {
        this.exam_date = exam_date;
    }

    public int getMulti_score() {
        return multi_score;
    }

    public void setMulti_score(int multi_score) {
        this.multi_score = multi_score;
    }

    public int getSingle_score() {
        return single_score;
    }

    public void setSingle_score(int single_score) {
        this.single_score = single_score;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getPaper_id() {
        return paper_id;
    }

    public void setPaper_id(int paper_id) {
        this.paper_id = paper_id;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }
}
