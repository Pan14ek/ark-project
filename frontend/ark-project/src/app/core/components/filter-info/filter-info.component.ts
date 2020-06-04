import {Component, OnInit} from '@angular/core';
import {FilterService} from '../../services/filter.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-filter-info',
  templateUrl: './filter-info.component.html',
  styleUrls: ['./filter-info.component.css']
})
export class FilterInfoComponent implements OnInit {

  filter;

  constructor(private filterService: FilterService, private activatedRoute: ActivatedRoute, private router: Router) {
  }

  ngOnInit(): void {
    this.activatedRoute.queryParams.subscribe(
      (queryParam: any) => {
        this.filterService
          .getFilterById(queryParam['filterId'])
          .subscribe(filter => this.filter = filter);
      }
    );
  }

}
