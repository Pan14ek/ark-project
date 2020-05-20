package ua.nure.makieiev.factory.intermediate.iot.service;

import ua.nure.makieiev.factory.intermediate.iot.model.LoginUser;
import ua.nure.makieiev.factory.intermediate.iot.model.UserPlace;
import ua.nure.makieiev.factory.intermediate.iot.model.UserToken;

public interface UserService {

    UserToken signIn(LoginUser loginUser);

    UserPlace findUserPlaceByUserId(long userId, String token);

}
