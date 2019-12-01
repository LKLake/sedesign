package model;

public class UserModel {
    private String name;
    private String userId;
    private String sex;
    private String password;
    public UserModel(){}
    public UserModel(String userId,String name){
        this.name=name;
        this.userId=userId;
    }
    public UserModel(String userId,String name,String sex,String password){
        this.userId=userId;
        this.name=name;
        this.sex=sex;
        this.password=password;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
