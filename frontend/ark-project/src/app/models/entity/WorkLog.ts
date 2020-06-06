export class WorkLog {

  id: number;
  workDate: string;
  amountPoints: number;

  constructor(id: number, workDate: string, amountPoints: number) {
    this.id = id;
    this.workDate = workDate;
    this.amountPoints = amountPoints;
  }

}
