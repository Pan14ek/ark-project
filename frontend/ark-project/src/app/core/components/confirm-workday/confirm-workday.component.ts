import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {WorkLogService} from '../../services/work-log.service';
import {WorkLogDto} from '../../../models/dto/WorkLogDto';
import {WorkLog} from '../../../models/entity/WorkLog';

@Component({
  selector: 'app-confirm-workday',
  templateUrl: './confirm-workday.component.html',
  styleUrls: ['./confirm-workday.component.css']
})
export class ConfirmWorkdayComponent implements OnInit {

  workDate;
  login;
  flag: boolean;
  amountPoints;

  constructor(private workLogService: WorkLogService, private router: Router) {
  }

  ngOnInit(): void {
    this.workDate = localStorage.getItem('workDate');
    this.login = localStorage.getItem('login');
    const userId = localStorage.getItem('userId');
    this.workLogService.findWorkLogByUserIdAndDate(userId, this.workDate).subscribe((workLog: WorkLog) => {
        if (workLog.amountPoints != null) {
          this.flag = true;
          this.amountPoints = workLog.amountPoints;
        } else {
          this.flag = false;
        }
      }, error => console.log(error)
    );
  }

  markWorkDay() {
    const workLogDto = new WorkLogDto(this.workDate, this.login);
    this.workLogService.confirmWorkDay(workLogDto).subscribe((workLog: WorkLog) => {
        if (workLog.amountPoints != null) {
          alert(`You marked successfully day!You got points: ${workLog.amountPoints}.\n Good luck and work carefully`);
          this.router.navigate(['/user/schedule']);
        }
      },
      error => console.log(error));
  }

}
