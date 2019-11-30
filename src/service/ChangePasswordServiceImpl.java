package service;

import org.springframework.stereotype.Service;

@Service("changePasswordService")
public class ChangePasswordServiceImpl implements ChangePasswordService {
    public int changePassword(String userId,String rawPassword,String newPassword){
        return 0;
    }
}
