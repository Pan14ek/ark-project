export class UserPersonalScheduleDto {

  personalScheduleId: number;
  userLogin: string;
  workDate: string;

  constructor(personalScheduleId: number, userLogin: string, workDate: string) {
    this.personalScheduleId = personalScheduleId;
    this.userLogin = userLogin;
    this.workDate = workDate;
  }

}
