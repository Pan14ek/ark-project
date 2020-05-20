package ua.nure.makieiev.factory.intermediate.iot.service.impl;

import com.google.gson.Gson;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ua.nure.makieiev.factory.intermediate.iot.model.FilterUnit;
import ua.nure.makieiev.factory.intermediate.iot.model.FilterWorkLogInfo;
import ua.nure.makieiev.factory.intermediate.iot.service.FilterWorkLogService;

import java.util.Objects;

@Service
public class FilterWorkLogServiceImpl implements FilterWorkLogService {

    @Override
    public boolean save(FilterWorkLogInfo filterWorkLogInfo, String token) {
        Gson gson = new Gson();
        String jsonInfo = gson.toJson(filterWorkLogInfo);
        RestTemplate rest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Accept", "*/*");
        headers.add("Authorization", "Bearer " + token);
        HttpEntity<String> requestEntity = new HttpEntity<>(jsonInfo, headers);
        ResponseEntity<String> responseEntity = rest.exchange("https://arkproject.herokuapp.com/filter/worklog/add", HttpMethod.POST, requestEntity, String.class);
        return Objects.nonNull(responseEntity.getBody());
    }

    @Override
    public FilterUnit findFilterUnitByUnitId(long unitId, String token) {
        Gson gson = new Gson();
        RestTemplate rest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Accept", "*/*");
        headers.add("Authorization", "Bearer " + token);
        HttpEntity<String> requestEntity = new HttpEntity<>("", headers);
        ResponseEntity<String> responseEntity = rest.exchange("https://arkproject.herokuapp.com/filter/unit/id/" + unitId, HttpMethod.GET, requestEntity, String.class);
        return gson.fromJson(requestEntity.getBody(), FilterUnit.class);
    }

}