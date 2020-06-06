package ua.nure.makieiev.factory.facade

import retrofit2.http.*
import ua.nure.makieiev.factory.model.dto.WorkLogDto
import ua.nure.makieiev.factory.model.entity.WorkLog

interface WorkLogFacade {

    @GET("/worklog/user/{id}/workDate/{workDate}")
    fun getWorkLogByUserIdAndWorkDate(
        @Path("id") userId: Long,
        @Path("workDate") workDate: String,
        @Header("authorization") auth: String
    ): retrofit2.Call<WorkLog>

    @Headers("Content-Type:application/json")
    @POST("/worklog/add")
    fun addWorkLog(
        @Body workLogDto: WorkLogDto,
        @Header("authorization") auth: String
    ): retrofit2.Call<WorkLog>

}