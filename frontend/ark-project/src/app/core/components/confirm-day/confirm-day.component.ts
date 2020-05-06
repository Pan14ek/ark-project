import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {PersonalScheduleService} from '../../services/personal-schedule.service';
import {ConfirmDto} from '../../../models/dto/ConfirmDto';

@Component({
  selector: 'app-confirm-day',
  templateUrl: './confirm-day.component.html',
  styleUrls: ['./confirm-day.component.css']
})
export class ConfirmDayComponent implements OnInit {

  scheduleDayId;
  personalScheduleId;

  constructor(private personalScheduleService: PersonalScheduleService, private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.route.queryParams.subscribe(
      (queryParam: any) => {
        this.scheduleDayId = queryParam['scheduleDayId'];
        this.personalScheduleId = queryParam['personalScheduleId'];
        const confirmDto = new ConfirmDto(this.scheduleDayId, this.personalScheduleId, true);
        this.personalScheduleService.confirmWorkDay(confirmDto).toPromise().then(value => console.log(value));
      }
    );
  }

  confirm() {
    console.log(this.scheduleDayId);
    console.log(this.personalScheduleId);
  }

}
