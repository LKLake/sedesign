package bean;

public class StudentBean extends UserBean{
    private String major;

    public StudentBean(){}

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
