import {User} from './User';

export class UserToken {

  readonly token: string;
  readonly user: User;

  constructor(token: string, user: User) {
    this.token = token;
    this.user = user;
  }

}
