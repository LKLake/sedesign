package service;

public interface ChangePasswordService {
    public int changePassword(String userId, String rawPassword, String newPassword,String identity);
}
