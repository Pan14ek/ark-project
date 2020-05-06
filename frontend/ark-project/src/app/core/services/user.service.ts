import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {environment} from '../../../environments/environment.prod';
import {UserSignUpDto} from '../../models/dto/UserSignUpDto';
import {UserSignInDto} from '../../models/dto/UserSignInDto';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) {
  }

  /**
   * Get all users
   */
  getUsers() {
    const httpOptions = {
      headers: new HttpHeaders({
        Authorization: 'Bearer ' + localStorage.getItem('token')
      })
    };
    return this.http.get(`${environment.apiHerokuBaseUrl}/user/all`, httpOptions);
  }

  /**
   * Get single user by username
   */
  getUser(login: string) {
    const httpOptions = {
      headers: new HttpHeaders({
        Authorization: 'Bearer ' + localStorage.getItem('token')
      })
    };
    return this.http.get(`${environment.apiHerokuBaseUrl}/user/login/${login}`, httpOptions);
  }

  signUpUser(userSignUpDto: UserSignUpDto) {
    return this.http.post(`${environment.apiHerokuBaseUrl}/user/signUp`, userSignUpDto);
  }

  signInUser(userSignInDto: UserSignInDto) {
    return this.http.post(`${environment.apiHerokuBaseUrl}/user/signIn`, userSignInDto);
  }

}
