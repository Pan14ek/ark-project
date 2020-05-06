export class UserSignUpDto {

  private readonly firstName: string;
  private readonly lastName: string;
  private readonly login: string;
  private readonly email: string;
  private readonly password: string;
  private readonly repeatPassword: string;

  constructor(firstName: string, lastName: string, login: string, email: string, password: string, repeatPassword: string) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.login = login;
    this.email = email;
    this.password = password;
    this.repeatPassword = repeatPassword;
  }

  get getFirstName(): string {
    return this.firstName;
  }

  get getLastName(): string {
    return this.lastName;
  }

  get getLogin(): string {
    return this.login;
  }

  get getEmail(): string {
    return this.email;
  }

  get getPassword(): string {
    return this.password;
  }

  get getRepeatPassword(): string {
    return this.repeatPassword;
  }

}
