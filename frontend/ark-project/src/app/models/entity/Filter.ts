export class Filter {

  id: number;
  title: string;
  diameter: string;
  filterType: string;


  constructor(id: number, title: string, diameter: string, filterType: string) {
    this.id = id;
    this.title = title;
    this.diameter = diameter;
    this.filterType = filterType;
  }

}
