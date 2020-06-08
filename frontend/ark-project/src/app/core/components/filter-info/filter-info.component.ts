import {Component, OnInit} from '@angular/core';
import {FilterService} from '../../services/filter.service';
import {ActivatedRoute} from '@angular/router';
import {FilterChemicalSubstancesService} from '../../services/test/filter-chemical-substances.service';

@Component({
  selector: 'app-filter-info',
  templateUrl: './filter-info.component.html',
  styleUrls: ['./filter-info.component.css']
})
export class FilterInfoComponent implements OnInit {

  filter;
  filterChemicalSubstances;

  constructor(private filterService: FilterService, private activatedRoute: ActivatedRoute,
              private filterChemicalSubstancesService: FilterChemicalSubstancesService) {
  }

  ngOnInit(): void {
    this.activatedRoute.queryParams.subscribe(
      (queryParam: any) => {
        this.filterService
          .getFilterById(queryParam['filterId'])
          .subscribe(filter => this.filter = filter);
        this.filterChemicalSubstancesService
          .findAllByFilterId(queryParam['filterId'])
          .subscribe(filterChemicalSubstances => this.filterChemicalSubstances = filterChemicalSubstances);
      }
    );

  }

}
