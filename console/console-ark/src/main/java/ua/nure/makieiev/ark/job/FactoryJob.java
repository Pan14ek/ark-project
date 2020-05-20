package ua.nure.makieiev.ark.job;

import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import ua.nure.makieiev.ark.model.dto.FilterWorkLogDto;
import ua.nure.makieiev.ark.model.entity.UserInfo;
import ua.nure.makieiev.ark.util.serialization.ObjectReader;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class FactoryJob implements Job {

    public void execute(JobExecutionContext jobExecutionContext) {
        String temperature = generateTemperature();
        BigDecimal filterContamination = generateFilterContamination();
        UserInfo userInfo = getUserInfo();
        FilterWorkLogDto filterWorkLogDto = new FilterWorkLogDto(userInfo.getToken(), userInfo.getUnitId(), temperature, filterContamination);
        sendFilterInfo(filterWorkLogDto, userInfo);
        System.out.println(generateTemperature());
        System.out.println(filterContamination);
    }

    private void sendFilterInfo(FilterWorkLogDto filterWorkLogDto, UserInfo userInfo) {
        Gson gson = new Gson();
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost("https://intermediate-ark-project.herokuapp.com/filter/worklog/add");
            StringEntity stringEntity = new StringEntity(gson.toJson(filterWorkLogDto));
            httpPost.setEntity(stringEntity);
            httpPost.setHeader("Content-type", "Application/json");
            httpPost.setHeader("Authorization", "Bearer " + userInfo.getToken());
            CloseableHttpResponse response = httpClient.execute(httpPost);
            HttpEntity httpEntity = response.getEntity();
            if (Objects.nonNull(httpEntity)) {
                System.out.println("SUCCESS SEND");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private String generateTemperature() {
        return getRandomNumber(60, 90) + " C";
    }

    private BigDecimal generateFilterContamination() {
        return BigDecimal.valueOf(getRandomNumber(0, 1) - 0.5).abs();
    }

    private int getRandomNumber(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    private UserInfo getUserInfo() {
        return ObjectReader.readUserInformation();
    }

}
