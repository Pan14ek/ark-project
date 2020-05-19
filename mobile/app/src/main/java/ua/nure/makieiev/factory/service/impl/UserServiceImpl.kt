package ua.nure.makieiev.factory.service.impl

import android.content.Context
import android.widget.Toast
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ua.nure.makieiev.factory.facade.RetrofitInstance
import ua.nure.makieiev.factory.facade.UserFacade
import ua.nure.makieiev.factory.model.dto.SignInUserDto
import ua.nure.makieiev.factory.model.dto.SignUpUserDto
import ua.nure.makieiev.factory.model.entity.User
import ua.nure.makieiev.factory.model.entity.UserToken
import ua.nure.makieiev.factory.service.UserService

class UserServiceImpl : UserService {

    override fun signUp(signUpUserDto: SignUpUserDto, context: Context): Boolean {
        var signUpFlag = false
        val retrofitInstance = RetrofitInstance.getRetrofitInstance().create(UserFacade::class.java)
        retrofitInstance.signUp(signUpUserDto).enqueue(object :
            Callback<ResponseBody> {
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Toast.makeText(
                    context,
                    t.message,
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                signUpFlag = response.code() == 200
            }
        })
        return signUpFlag
    }

    override fun signIn(signInUserDto: SignInUserDto, context: Context) {
        val retrofitInstance = RetrofitInstance.getRetrofitInstance().create(UserFacade::class.java)
        retrofitInstance.signIn(signInUserDto).enqueue(object : Callback<UserToken> {
            override fun onFailure(call: Call<UserToken>, t: Throwable) {
                Toast.makeText(
                    context,
                    t.message,
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onResponse(call: Call<UserToken>, response: Response<UserToken>) {
                if (response.code() == 200) {
                    val userToken = response.body()
                    val sharedPreference =
                        context.getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
                    val editor = sharedPreference.edit()
                    editor.putString("token", "Bearer " + userToken!!.token)
                    editor.putLong("userId", userToken.user!!.id!!)
                    editor.putString("login", userToken.user!!.login)
                    editor.apply()
                    Toast.makeText(context, "Login success!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "Login failed!", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    override fun getUserByLogin(login: String, context: Context): User? {
        val retrofitInstance = RetrofitInstance.getRetrofitInstance().create(UserFacade::class.java)
        val sharedPreference =
            context.getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
        val token = sharedPreference.getString("token", "")
        var user = User()
        println("Token : $token")
        retrofitInstance.getUserByLogin(login, token).enqueue(object : Callback<User> {
            override fun onFailure(call: Call<User>, t: Throwable) {
                Toast.makeText(
                    context,
                    t.message,
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.code() == 200) {
                    user = response.body()!!
                    val sharedPreference =
                        context.getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
                    val edit = sharedPreference.edit()
                    Toast.makeText(context, "Success!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "Failed!", Toast.LENGTH_SHORT).show()
                }
            }
        })
        return user
    }

}