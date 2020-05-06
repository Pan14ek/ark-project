import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {environment} from '../../../environments/environment.prod';
import {Role} from '../../models/entity/Role';
import {RoleDto} from '../../models/dto/RoleDto';

@Injectable({
  providedIn: 'root'
})
export class RoleService {

  constructor(private http: HttpClient) {
  }

  getAllRoles() {
    const httpOptions = {
      headers: new HttpHeaders({
        Authorization: 'Bearer ' + localStorage.getItem('token')
      })
    };
    return this.http.get(`${environment.apiHerokuBaseUrl}/role/all`, httpOptions);
  }

  getRoleByTitle(title: string) {
    const httpOptions = {
      headers: new HttpHeaders({
        Authorization: 'Bearer ' + localStorage.getItem('token')
      })
    };
    return this.http.get(`${environment.apiHerokuBaseUrl}/role/title/${title}`, httpOptions);
  }

  updateRole(role: Role) {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        Authorization: 'Bearer ' + localStorage.getItem('token')
      })
    };
    return this.http.post(`${environment.apiHerokuBaseUrl}/role/update`, role, httpOptions);
  }

  addRole(role: RoleDto) {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        Authorization: 'Bearer ' + localStorage.getItem('token')
      })
    };
    return this.http.post(`${environment.apiHerokuBaseUrl}/role/add`, role, httpOptions);
  }

}
