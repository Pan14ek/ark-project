package ua.nure.makieiev.factory.intermediate.iot.service.impl;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ua.nure.makieiev.factory.intermediate.iot.config.RestClient;
import ua.nure.makieiev.factory.intermediate.iot.model.LoginUser;
import ua.nure.makieiev.factory.intermediate.iot.model.UserPlace;
import ua.nure.makieiev.factory.intermediate.iot.model.UserToken;
import ua.nure.makieiev.factory.intermediate.iot.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final RestClient restClient;

    @Autowired
    public UserServiceImpl(RestClient restClient) {
        this.restClient = restClient;
    }

    @Override
    public UserToken signIn(LoginUser loginUser) {
        Gson gson = new Gson();
        String jsonInfo = gson.toJson(loginUser);
        return gson.fromJson(restClient.post("user/signIn", jsonInfo), UserToken.class);
    }

    @Override
    public UserPlace findUserPlaceByUserId(long userId, String token) {
        Gson gson = new Gson();
        RestTemplate rest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Accept", "*/*");
        headers.add("Authorization", "Bearer " + token);
        HttpEntity<String> requestEntity = new HttpEntity<>("", headers);
        ResponseEntity<String> responseEntity = rest.exchange("https://arkproject.herokuapp.com/place/user/" + userId, HttpMethod.GET, requestEntity, String.class);
        return gson.fromJson(responseEntity.getBody(), UserPlace.class);
    }

}