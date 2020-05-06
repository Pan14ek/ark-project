import {Component, OnInit} from '@angular/core';
import {PersonalScheduleService} from '../../services/personal-schedule.service';

@Component({
  selector: 'app-user-schedule',
  templateUrl: './user-schedule.component.html',
  styleUrls: ['./user-schedule.component.css']
})
export class UserScheduleComponent implements OnInit {

  scheduleDays;

  constructor(private personalScheduleService: PersonalScheduleService) {
  }

  ngOnInit(): void {
    this.scheduleDays = this.personalScheduleService.getAllSchedulesByUserId(Number(localStorage.getItem('userId')));
  }

}
