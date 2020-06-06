import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-confirm-workday',
  templateUrl: './confirm-workday.component.html',
  styleUrls: ['./confirm-workday.component.css']
})
export class ConfirmWorkdayComponent implements OnInit {

  workDate;

  constructor(private activatedRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.workDate = localStorage.getItem('workDate');
  }

}
