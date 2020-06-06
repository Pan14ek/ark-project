import {Component, OnInit} from '@angular/core';
import dayGridPlugin from '@fullcalendar/daygrid';
import interactionPlugin from '@fullcalendar/interaction';
import {PersonalScheduleService} from '../../services/personal-schedule.service';
import {UserPersonalSchedule} from '../../../models/entity/UserPersonalSchedule';
import {Router} from '@angular/router';

@Component({
  selector: 'app-user-schedule',
  templateUrl: './user-schedule.component.html',
  styleUrls: ['./user-schedule.component.css']
})
export class UserScheduleComponent implements OnInit {

  constructor(private personalScheduleService: PersonalScheduleService, private router: Router) {
  }

  scheduleDays: UserPersonalSchedule[];

  calendarOptions = {
    plugins: [dayGridPlugin, interactionPlugin],
    initialView: 'dayGridMonth',
    lazyFetching: false,
    dateClick: this.handleDateClick.bind(this),
    events: []
  };

  ngOnInit(): void {
    this.personalScheduleService.getAllSchedulesByUserId(Number(localStorage.getItem('userId')))
      .subscribe((userPersonalSchedules: UserPersonalSchedule[]) => {
        this.scheduleDays = userPersonalSchedules;
        for (const userPersonalSchedule of userPersonalSchedules) {
          this.calendarOptions.events.push(
            {
              title: userPersonalSchedule.confirm ? 'Confirmed day' : 'Not confirmed day',
              date: userPersonalSchedule.workDate,
              color: userPersonalSchedule.confirm ? '#99ff99' : '#ff9999',
              url: `/schedule/confirm?personalScheduleId=${userPersonalSchedule.id}&scheduleDayId=${userPersonalSchedule.personalSchedule.id}`
            });
        }
      });
  }

  handleDateClick(arg) {
    localStorage.setItem('workDate', arg.dateStr);
    this.router.navigate(['confirm/work/day']);
  }

}
