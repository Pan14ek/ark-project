export class FilterDto {

  title: string;
  diameter: string;
  filterType: string;

  constructor(title: string, diameter: string, filterType: string) {
    this.title = title;
    this.diameter = diameter;
    this.filterType = filterType;
  }

}
