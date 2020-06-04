import {Filter} from './Filter';
import {Unit} from './Unit';

export class FilterUnit {

  id: number;
  filter: Filter;
  unit: Unit;
  dateInstall: string;
  status: string;
  dateRemoval: string;

  constructor(id: number, filter: Filter, unit: Unit, dateInstall: string, status: string, dateRemoval: string) {
    this.id = id;
    this.filter = filter;
    this.unit = unit;
    this.dateInstall = dateInstall;
    this.status = status;
    this.dateRemoval = dateRemoval;
  }

}
