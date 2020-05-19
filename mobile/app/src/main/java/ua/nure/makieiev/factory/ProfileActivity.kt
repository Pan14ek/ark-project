package ua.nure.makieiev.factory

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ua.nure.makieiev.factory.facade.RetrofitInstance
import ua.nure.makieiev.factory.facade.UserFacade
import ua.nure.makieiev.factory.model.entity.User
import ua.nure.makieiev.factory.service.UserService
import ua.nure.makieiev.factory.service.impl.UserServiceImpl

class ProfileActivity : AppCompatActivity() {

    private lateinit var userService: UserService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        initObjects()
        initBackButton()
        enrichFields()
    }

    private fun initObjects() {
        userService = UserServiceImpl()
    }

    private fun enrichFields() {
        val retrofitInstance = RetrofitInstance.getRetrofitInstance().create(UserFacade::class.java)
        val sharedPreference =
            this.getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
        val token = sharedPreference.getString("token", "")
        val login = sharedPreference.getString("login", "")
        var user: User
        println("Token : $token")
        retrofitInstance.getUserByLogin(login, token).enqueue(object : Callback<User> {
            override fun onFailure(call: Call<User>, t: Throwable) {
                Toast.makeText(
                    this@ProfileActivity,
                    t.message,
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.code() == 200) {
                    user = response.body()!!
                    findViewById<TextView>(R.id.firstNameTextView).text = user.firstName
                    findViewById<TextView>(R.id.lastNameTextView).text = user.lastName
                    findViewById<TextView>(R.id.loginTextView).text = user.login
                    findViewById<TextView>(R.id.emailTextView).text = user.email
                    Toast.makeText(this@ProfileActivity, "Success!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@ProfileActivity, "Failed!", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    private fun initBackButton() {
        val backButton = findViewById<Button>(R.id.backButton)
        backButton.setOnClickListener {
            onBackPressed()
        }
    }

}