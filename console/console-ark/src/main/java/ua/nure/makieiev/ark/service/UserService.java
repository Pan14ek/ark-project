package ua.nure.makieiev.ark.service;

import ua.nure.makieiev.ark.model.dto.LoginUser;
import ua.nure.makieiev.ark.model.entity.UserInfo;

public interface UserService {

    UserInfo signIn(LoginUser loginUser);

}
