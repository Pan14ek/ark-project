export class Role {

  id: number;
  title: string;
  symbol: string;
  description: string;

  constructor(id: number, title: string, symbol: string, description: string) {
    this.id = id;
    this.title = title;
    this.symbol = symbol;
    this.description = description;
  }

}
