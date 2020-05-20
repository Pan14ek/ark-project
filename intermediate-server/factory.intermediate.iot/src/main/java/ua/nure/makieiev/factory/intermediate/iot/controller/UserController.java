package ua.nure.makieiev.factory.intermediate.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.nure.makieiev.factory.intermediate.iot.model.LoginUser;
import ua.nure.makieiev.factory.intermediate.iot.model.UserInfo;
import ua.nure.makieiev.factory.intermediate.iot.model.UserPlace;
import ua.nure.makieiev.factory.intermediate.iot.model.UserToken;
import ua.nure.makieiev.factory.intermediate.iot.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> signIn(@RequestBody LoginUser loginUser) {
        UserToken userToken = userService.signIn(loginUser);
        UserPlace userPlace = userService.findUserPlaceByUserId(userToken.getUser().getId(), userToken.getToken());
        UserInfo userInfo = new UserInfo(userToken.getToken(), userToken.getUser().getLogin(), userPlace.getWorkPlace().getUnit().getId());
        return new ResponseEntity<>(userInfo, HttpStatus.OK);
    }

}