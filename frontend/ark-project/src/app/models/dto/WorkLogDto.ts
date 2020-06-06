export class WorkLogDto {

  workDate: string;
  userLogin: string;

  constructor(workDate: string, userLogin: string) {
    this.workDate = workDate;
    this.userLogin = userLogin;
  }

}
