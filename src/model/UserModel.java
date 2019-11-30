package model;

public class UserModel {
    private String name;
    private String userId;
    public UserModel(){}
    public UserModel(String userId,String name){
        this.name=name;
        this.userId=userId;
    }
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
}
