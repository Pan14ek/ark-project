import {Role} from './Role';

export class User {

  readonly id: number;
  readonly firstName: string;
  readonly lastName: string;
  readonly login: string;
  readonly email: string;
  readonly password: string;
  readonly role: Role;

  constructor(id: number, firstName: string, lastName: string, login: string, email: string, password: string, role: Role) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.login = login;
    this.email = email;
    this.password = password;
    this.role = role;
  }

}
