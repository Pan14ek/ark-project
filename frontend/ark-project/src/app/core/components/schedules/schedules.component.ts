import {Component, OnInit} from '@angular/core';
import {PersonalScheduleService} from '../../services/personal-schedule.service';
import {PersonalScheduleDto} from '../../../models/dto/PersonalScheduleDto';
import {PersonalSchedule} from '../../../models/entity/PersonalSchedule';
import {FormControl} from '@angular/forms';
import {DateAdapter, MAT_DATE_FORMATS} from '@angular/material/core';
import {AppDateAdapter} from '../../services/date-adapter';
import {UserService} from '../../services/user.service';
import {UserPersonalScheduleDto} from '../../../models/dto/UserPersonalScheduleDto';

export const APP_DATE_FORMATS =
  {
    parse: {
      dateInput: {month: 'short', year: 'numeric', day: 'numeric'},
    },
    display: {
      dateInput: {month: 'short', year: 'numeric', day: 'numeric'},
      monthYearLabel: {year: 'numeric'}
    }
  };

@Component({
  selector: 'app-schedules',
  templateUrl: './schedules.component.html',
  styleUrls: ['./schedules.component.css'],
  providers: [
    {
      provide: DateAdapter, useClass: AppDateAdapter
    },
    {
      provide: MAT_DATE_FORMATS, useValue: APP_DATE_FORMATS
    }]
})
export class SchedulesComponent implements OnInit {

  users;
  selectedUserLogin;
  schedulesDays;
  selectedScheduleId;
  addUserScheduleDayFlag;
  addScheduleDayFlag;
  amountDays: number;
  date = new FormControl();
  workDate;

  constructor(private personalScheduleService: PersonalScheduleService, private userService: UserService) {
  }

  ngOnInit(): void {
  }

  showAddScheduleDayForm() {
    this.addScheduleDayFlag = !this.addScheduleDayFlag;
    this.addUserScheduleDayFlag = false;
  }

  showAddUserScheduleDayForm() {
    this.addUserScheduleDayFlag = !this.addUserScheduleDayFlag;
    this.addScheduleDayFlag = false;
    this.personalScheduleService.getAllSchedule().toPromise().then(value => this.schedulesDays = value);
    this.userService.getUsers().toPromise().then(value => this.users = value);
  }

  addScheduleDay() {
    const personalScheduleDto = new PersonalScheduleDto(this.amountDays);
    this.personalScheduleService.addPersonalSchedule(personalScheduleDto)
      .subscribe((personalSchedule: PersonalSchedule) => console.log(personalSchedule));
  }

  showWorkDate() {
    console.log(this.workDate);
  }

  addUserPersonalSchedule() {
    const userPersonalScheduleDto = new UserPersonalScheduleDto(this.selectedScheduleId, this.selectedUserLogin, this.workDate);
    console.log(userPersonalScheduleDto);
    this.personalScheduleService.addUserPersonalSchedule(userPersonalScheduleDto).toPromise().then(value => console.log(value));
  }

}
