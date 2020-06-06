import {User} from './User';
import {PersonalSchedule} from './PersonalSchedule';

export class UserPersonalSchedule {

  id: number;
  workDate: string;
  confirm: boolean;
  user: User;
  personalSchedule: PersonalSchedule;


  constructor(id: number, workDate: string, confirm: boolean, user: User, personalSchedule: PersonalSchedule) {
    this.id = id;
    this.workDate = workDate;
    this.confirm = confirm;
    this.user = user;
    this.personalSchedule = personalSchedule;
  }

}
