import {Injectable} from '@angular/core';
import {Service} from './service';
import {FilterDto} from '../../models/dto/FilterDto';

@Injectable({
  providedIn: 'root'
})
export class FilterService extends Service {

  getFilterById(filterId: number) {
    return this.serviceHttp.get(`${this.ENV_URL}/filter/${filterId}`, this.getOptions());
  }

  getAllFilters() {
    return this.serviceHttp.get(`${this.ENV_URL}/filter/all`, this.getOptions());
  }

  addFilter(filterDto: FilterDto) {
    return this.serviceHttp.post(`${this.ENV_URL}/filter/add`, filterDto, this.getOptionsWithJsonContent());
  }

  getFilterByTitle(title) {
    return this.serviceHttp.get(`${this.ENV_URL}/filter/title/${title}`, this.getOptions());
  }

}
