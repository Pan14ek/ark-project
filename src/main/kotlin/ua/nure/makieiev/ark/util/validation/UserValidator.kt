package ua.nure.makieiev.ark.util.validation

import org.springframework.stereotype.Component
import ua.nure.makieiev.ark.model.dto.UserDto

@Component
class UserValidator {

    val loginPattern: String = "\\w{6,45}"
    val userNamePattern: String = "\\w{3,40}"
    val emailPattern: String = "(.+@(\\w+\\W+\\w.*))"
    val passwordPattern: String = "\\w{8,45}"

    fun signUpValidate(userDto: UserDto): MutableList<String> {
        val errors: MutableList<String> = mutableListOf()
        validateLogin(userDto.login, errors)
        validateFirstName(userDto.firstName, errors)
        validateLastName(userDto.lastName, errors)
        validateEmail(userDto.email, errors)
        validatePassword(userDto.password, errors)
        validateRepeatPassword(userDto.password, userDto.repeatPassword, errors)
        return errors
    }

    private fun validateLogin(login: String, errors: MutableList<String>) {
        if (isNotValidateString(login, loginPattern)) {
            errors.add("login")
        }
    }

    private fun validateFirstName(firstName: String, errors: MutableList<String>) {
        if (isNotValidateString(firstName, userNamePattern)) {
            errors.add("firstName")
        }
    }

    private fun validateLastName(lastName: String, errors: MutableList<String>) {
        if (isNotValidateString(lastName, userNamePattern)) {
            errors.add("lastName")
        }
    }

    private fun validateEmail(email: String, errors: MutableList<String>) {
        if (isNotValidateString(email, emailPattern)) {
            errors.add("email")
        }
    }

    private fun validatePassword(password: String, errors: MutableList<String>) {
        if (isNotValidateString(password, passwordPattern)) {
            errors.add("password")
        }
    }

    private fun validateRepeatPassword(password: String, repeatPassword: String, errors: MutableList<String>) {
        if (isNotValidateString(repeatPassword, passwordPattern) || password != repeatPassword) {
            errors.add("repeatPassword")
        }
    }

    private fun isNotValidateString(field: String, pattern: String): Boolean = !field.matches(pattern.toRegex())

}