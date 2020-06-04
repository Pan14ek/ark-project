import {FilterUnit} from './FilterUnit';

export class FilterWorkLog {

  id: number;
  filterUnit: FilterUnit;
  scanDateTime: string;
  temperature: string;
  filterContamination: number;


  constructor(id: number, filterUnit: FilterUnit, scanDateTime: string, temperature: string, filterContamination: number) {
    this.id = id;
    this.filterUnit = filterUnit;
    this.scanDateTime = scanDateTime;
    this.temperature = temperature;
    this.filterContamination = filterContamination;
  }

}
