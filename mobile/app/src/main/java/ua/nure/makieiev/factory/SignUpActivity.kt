package ua.nure.makieiev.factory

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import ua.nure.makieiev.factory.model.dto.SignUpUserDto
import ua.nure.makieiev.factory.service.UserService
import ua.nure.makieiev.factory.service.impl.UserServiceImpl
import ua.nure.makieiev.factory.util.InputValidator

class SignUpActivity : AppCompatActivity() {

    private lateinit var userService: UserService
    private lateinit var inputValidator: InputValidator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        initObjects()
        signUp()
    }

    private fun initObjects() {
        userService = UserServiceImpl()
        inputValidator = InputValidator(this)
    }

    private fun signUp() {
        val signUpUserDto = SignUpUserDto()
        val signUpButton = findViewById<Button>(R.id.signUpButton)
        signUpButton.setOnClickListener {
            val firstName = findViewById<EditText>(R.id.firstNameEditText)
            val lastName = findViewById<EditText>(R.id.lastNameEditText)
            val login = findViewById<EditText>(R.id.loginEditText)
            val email = findViewById<EditText>(R.id.emailEditText)
            val password = findViewById<EditText>(R.id.passwordEditText)
            val repeatPassword = findViewById<EditText>(R.id.repeatPasswordEditText)
            signUpUserDto.firstName = firstName.text.toString()
            signUpUserDto.lastName = lastName.text.toString()
            signUpUserDto.login = login.text.toString()
            signUpUserDto.email = email.text.toString()
            signUpUserDto.password = password.text.toString()
            signUpUserDto.repeatPassword = repeatPassword.text.toString()
            userService.signUp(signUpUserDto, this)
            onBackPressed()
        }
    }

}