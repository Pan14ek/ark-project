package ua.nure.makieiev.factory.facade

import okhttp3.ResponseBody
import retrofit2.http.*
import ua.nure.makieiev.factory.model.dto.SignInUserDto
import ua.nure.makieiev.factory.model.dto.SignUpUserDto
import ua.nure.makieiev.factory.model.entity.User
import ua.nure.makieiev.factory.model.entity.UserToken

interface UserFacade {

    @Headers("Content-Type:application/json")
    @POST("user/signUp")
    fun signUp(@Body signUpUserDto: SignUpUserDto): retrofit2.Call<ResponseBody>

    @Headers("Content-Type:application/json")
    @POST("/user/signIn")
    fun signIn(@Body signInUserDto: SignInUserDto): retrofit2.Call<UserToken>

    @GET("/user/login/{login}")
    fun getUserByLogin(
        @Path("login") login: String,
        @Header("authorization") auth: String
    ): retrofit2.Call<User>

}