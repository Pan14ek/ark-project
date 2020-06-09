export class FilterWorkLogStatistic {

  avgTemperature: number;
  sumFilterContamination: number;
  scanDate: string;

  constructor(avgTemperature: number, sumFilterContamination: number, scanDate: string) {
    this.avgTemperature = avgTemperature;
    this.sumFilterContamination = sumFilterContamination;
    this.scanDate = scanDate;
  }

}
