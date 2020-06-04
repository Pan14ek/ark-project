import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {UnitService} from '../../services/unit.service';

@Component({
  selector: 'app-unit-info',
  templateUrl: './unit-info.component.html',
  styleUrls: ['./unit-info.component.css']
})
export class UnitInfoComponent implements OnInit {

  unit;

  constructor(private unitService: UnitService, private activatedRoute: ActivatedRoute, private router: Router) {
  }

  ngOnInit(): void {
    this.activatedRoute.queryParams.subscribe(
      (queryParam: any) => {
        this.unitService
          .getUnitById(queryParam['unitId'])
          .subscribe(unit => this.unit = unit);
      }
    );
  }

}
