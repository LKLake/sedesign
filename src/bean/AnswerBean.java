package bean;


public class AnswerBean {
    private int lessonInfoId;
    private int questionId;
    private String answer;
    public AnswerBean(){}

    public int getLessonInfoId() {
        return lessonInfoId;
    }

    public void setLessonInfoId(int lessonInfoId) {
        this.lessonInfoId = lessonInfoId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
