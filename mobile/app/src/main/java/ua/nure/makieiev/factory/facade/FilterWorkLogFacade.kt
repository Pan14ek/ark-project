package ua.nure.makieiev.factory.facade

import retrofit2.http.GET
import retrofit2.http.Header
import ua.nure.makieiev.factory.model.entity.FilterWorkLog

interface FilterWorkLogFacade {

    @GET("/filter/worklog/all")
    fun getAllFilterWorkLogs(
        @Header("authorization") auth: String
    ): retrofit2.Call<List<FilterWorkLog>>

}