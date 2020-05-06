import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
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

  constructor(private personalScheduleService: PersonalScheduleService, private activatedRoute: ActivatedRoute, private router: Router) {
  }

  ngOnInit(): void {
    this.activatedRoute.queryParams.subscribe(
      (queryParam: any) => {
        this.scheduleDayId = queryParam['scheduleDayId'];
        this.personalScheduleId = queryParam['personalScheduleId'];
      }
    );
  }

  confirm() {
    const confirmDto = new ConfirmDto(this.scheduleDayId, this.personalScheduleId, true);
    this.personalScheduleService.confirmWorkDay(confirmDto).toPromise().then(value => {
      this.router.navigate(['/user/schedule']);
    });
  }

}
