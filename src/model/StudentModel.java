package model;

public class StudentModel {
    private String name;
    private String userId;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public StudentModel(String name, String id){
        this.name=name;
        this.userId=id;

    }
}
