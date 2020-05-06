export class UserSignInDto {

  private readonly login: string;
  private readonly password: string;

  constructor(login: string, password: string) {
    this.login = login;
    this.password = password;
  }

}
