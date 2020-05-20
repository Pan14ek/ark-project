package ua.nure.makieiev.ark.service.impl;

import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import ua.nure.makieiev.ark.model.dto.LoginUser;
import ua.nure.makieiev.ark.model.entity.UserInfo;
import ua.nure.makieiev.ark.service.UserService;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Objects;

public class UserServiceImpl implements UserService {

    private final Gson gson;

    public UserServiceImpl() {
        gson = new Gson();
    }

    @Override
    public UserInfo signIn(LoginUser loginUser) {
        UserInfo userInfo = null;
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost("https://intermediate-ark-project.herokuapp.com/user/login");
            StringEntity stringEntity = new StringEntity(gson.toJson(loginUser));
            httpPost.setEntity(stringEntity);
            httpPost.setHeader("Content-type", "Application/json");
            CloseableHttpResponse response = httpClient.execute(httpPost);
            HttpEntity httpEntity = response.getEntity();
            if (Objects.nonNull(httpEntity)) {
                String retSrc = EntityUtils.toString(httpEntity);
                userInfo = gson.fromJson(retSrc, UserInfo.class);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return userInfo;
    }

}
