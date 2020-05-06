export class ConfirmDto {

  id: number;
  userPersonalScheduleId: number;
  confirm: boolean;

  constructor(id: number, userPersonalScheduleId: number, confirm: boolean) {
    this.id = id;
    this.userPersonalScheduleId = userPersonalScheduleId;
    this.confirm = confirm;
  }

}
