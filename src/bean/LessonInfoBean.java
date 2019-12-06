package bean;


public class LessonInfoBean {
    private int id;
    private String examDate;
    private int multiScore;
    private int singleScore;
    private int paperId;
    private String studentId;

    public LessonInfoBean(){}
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExamDate() {
        return examDate;
    }

    public void setExamDate(String examDate) {
        this.examDate = examDate;
    }

    public int getMultiScore() {
        return multiScore;
    }

    public void setMultiScore(int multiScore) {
        this.multiScore = multiScore;
    }

    public int getSingleScore() {
        return singleScore;
    }

    public void setSingleScore(int singleScore) {
        this.singleScore = singleScore;
    }

    public int getPaperId() {
        return paperId;
    }

    public void setPaperId(int paperId) {
        this.paperId = paperId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
}
