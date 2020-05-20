package ua.nure.makieiev.factory.intermediate.iot.service;

import ua.nure.makieiev.factory.intermediate.iot.model.FilterUnit;
import ua.nure.makieiev.factory.intermediate.iot.model.FilterWorkLogInfo;

public interface FilterWorkLogService {

    boolean save(FilterWorkLogInfo filterWorkLogInfo, String token);

    FilterUnit findFilterUnitByUnitId(long unitId, String token);

}