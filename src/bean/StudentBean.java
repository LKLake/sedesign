package bean;

public class StudentBean extends UserBean{
    private String major;
    private int classNo;
    public StudentBean(){}

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getClassNo() {
        return classNo;
    }

    public void setClassNo(int classNo) {
        this.classNo = classNo;
    }
}
