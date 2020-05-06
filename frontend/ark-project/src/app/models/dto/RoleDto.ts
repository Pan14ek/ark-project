export class RoleDto {

  title: string;
  symbol: string;
  description: string;

  constructor(title: string, symbol: string, description: string) {
    this.title = title;
    this.symbol = symbol;
    this.description = description;
  }

}
