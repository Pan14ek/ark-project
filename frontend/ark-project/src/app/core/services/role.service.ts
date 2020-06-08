import {Injectable} from '@angular/core';
import {Role} from '../../models/entity/Role';
import {RoleDto} from '../../models/dto/RoleDto';
import {Service} from './service';

@Injectable({
  providedIn: 'root'
})
export class RoleService extends Service {

  getAllRoles() {
    return this.serviceHttp.get(`${this.ENV_URL}/role/all`, this.getOptions());
  }

  getRoleByTitle(title: string) {
    return this.serviceHttp.get(`${this.ENV_URL}/role/title/${title}`, this.getOptions());
  }

  updateRole(role: Role) {
    return this.serviceHttp.put(`${this.ENV_URL}/role/update`, role, this.getOptionsWithJsonContent());
  }

  addRole(role: RoleDto) {
    return this.serviceHttp.post(`${this.ENV_URL}/role/add`, role, this.getOptionsWithJsonContent());
  }

}
