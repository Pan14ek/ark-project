export class ChemicalSubstance {

  id: number;
  title: string;
  formula: string;

  constructor(id: number, title: string, formula: string) {
    this.id = id;
    this.title = title;
    this.formula = formula;
  }

}
