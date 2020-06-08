export class ChemicalSubstanceDto {

  title: string;
  formula: string;

  constructor(title: string, formula: string) {
    this.title = title;
    this.formula = formula;
  }

}
