package ua.nure.makieiev.factory.intermediate.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.nure.makieiev.factory.intermediate.iot.model.FilterWorkLogDto;
import ua.nure.makieiev.factory.intermediate.iot.model.FilterWorkLogInfo;
import ua.nure.makieiev.factory.intermediate.iot.service.FilterWorkLogService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/filter/worklog")
public class FilterWorkLogController {

    private final FilterWorkLogService filterWorkLogService;

    @Autowired
    public FilterWorkLogController(FilterWorkLogService filterWorkLogService) {
        this.filterWorkLogService = filterWorkLogService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addFilterWorkLog(@RequestBody FilterWorkLogDto filterWorkLogDto) {
        //FilterUnit filterUnit = filterWorkLogService.findFilterUnitByUnitId(filterWorkLogDto.getUnitId(), filterWorkLogDto.getToken());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime now = LocalDateTime.now();
        FilterWorkLogInfo filterWorkLogInfo = new FilterWorkLogInfo();
        filterWorkLogInfo.setFilterUnitId(2);
        filterWorkLogInfo.setTemperature(filterWorkLogDto.getTemperature());
        filterWorkLogInfo.setFilterContamination(filterWorkLogDto.getFilterContamination());
        filterWorkLogInfo.setScanDateTime(now.format(formatter));
        return new ResponseEntity<>(filterWorkLogService.save(filterWorkLogInfo, filterWorkLogDto.getToken()), HttpStatus.OK);
    }

}