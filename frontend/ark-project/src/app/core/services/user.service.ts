import {Injectable} from '@angular/core';
import {UserSignUpDto} from '../../models/dto/UserSignUpDto';
import {UserSignInDto} from '../../models/dto/UserSignInDto';
import {Service} from './service';
import {User} from '../../models/entity/User';

@Injectable({
  providedIn: 'root'
})
export class UserService extends Service {

  /**
   * Get all users
   */
  getUsers() {
    return this.serviceHttp.get(`${this.ENV_URL}/user/all`, this.getOptions());
  }

  /**
   * Get single user by username
   */
  getUser(login: string) {
    return this.serviceHttp.get(`${this.ENV_URL}/user/login/${login}`, this.getOptions());
  }

  signUpUser(userSignUpDto: UserSignUpDto) {
    return this.serviceHttp.post(`${this.ENV_URL}/user/signUp`, userSignUpDto);
  }

  signInUser(userSignInDto: UserSignInDto) {
    return this.serviceHttp.post(`${this.ENV_URL}/user/signIn`, userSignInDto);
  }

  updateUser(user: User) {
    return this.serviceHttp.put(`${this.ENV_URL}/user/update`, user, this.getOptionsWithJsonContent());
  }

}
