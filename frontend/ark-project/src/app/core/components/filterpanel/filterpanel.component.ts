import {Component, OnInit} from '@angular/core';
import {FilterService} from '../../services/filter.service';
import {FilterDto} from '../../../models/dto/FilterDto';
import {Filter} from '../../../models/entity/Filter';

@Component({
  selector: 'app-filterpanel',
  templateUrl: './filterpanel.component.html',
  styleUrls: ['./filterpanel.component.css']
})
export class FilterpanelComponent implements OnInit {

  filter;
  selectedFilterTitle;
  addFormFlag;
  updateFormFlag;
  showAllFiltersFlag;
  filters;
  filterTitle;
  filterDiameter;
  filterType;

  constructor(private filterService: FilterService) {
  }

  ngOnInit(): void {
    this.filterService.getAllFilters().subscribe((filters) => this.filters = filters);
  }

  showAddForm() {
    this.addFormFlag = !this.addFormFlag;
  }

  showUpdateForm() {
    this.updateFormFlag = !this.updateFormFlag;
    this.selectedFilterTitle = '';
  }

  showAllFilters() {
    this.showAllFiltersFlag = !this.showAllFiltersFlag;
  }

  addFilter() {
    const filterDto = new FilterDto(this.filterTitle, this.filterDiameter, this.filterType);
    this.filterService.addFilter(filterDto).subscribe((filter: Filter) => {
      if (filter.id > 0) {
        alert('Filter added success');
      }
    });
  }

  showInfo() {
    this.filterService.getFilterByTitle(this.selectedFilterTitle).subscribe((filter: Filter) => {
      this.filter = filter;
    });
  }

  updateFilter() {

  }

}
