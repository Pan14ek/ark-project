import {Component, OnInit} from '@angular/core';
import {FilterWorkLogService} from '../../services/filter-work-log.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-filter-worklog',
  templateUrl: './filter-worklog.component.html',
  styleUrls: ['./filter-worklog.component.css']
})
export class FilterWorklogComponent implements OnInit {

  filterWorkLogs;

  constructor(private filterWorkLogService: FilterWorkLogService, private router: Router) {
  }

  ngOnInit(): void {
    if (localStorage.getItem('token')) {
      this.filterWorkLogs = this.filterWorkLogService.getAllFilterWorkLog();
    } else {
      localStorage.setItem('needAuthorize', String(true));
      this.router.navigate(['']);
    }
  }

}
