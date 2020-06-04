export class Filter {

  id: number;
  title: string;
  diameter: number;
  filterType: string;


  constructor(id: number, title: string, diameter: number, filterType: string) {
    this.id = id;
    this.title = title;
    this.diameter = diameter;
    this.filterType = filterType;
  }

}
