package service;

import org.springframework.stereotype.Service;

@Service("changePasswordService")
public class ChangePasswordServiceImpl implements ChangePasswordService {
    public int changePassword(String userId,String rawPassword,String newPassword){
        //匹配用户名与原密码，若一致，修改密码为新密码。正确返回0，出错返回1;
        //TODO implement
        return 0;
    }
}
