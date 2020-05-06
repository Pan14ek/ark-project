import {Component, OnInit} from '@angular/core';
import {RoleService} from '../../services/role.service';
import {Role} from '../../../models/entity/Role';
import {RoleDto} from '../../../models/dto/RoleDto';

@Component({
  selector: 'app-rolepanel',
  templateUrl: './rolepanel.component.html',
  styleUrls: ['./rolepanel.component.css']
})
export class RolepanelComponent implements OnInit {

  role;
  roles;
  addForm;
  selectedRoleTitle;
  roleTitle;
  roleSymbol;
  description;
  addFormFlag;

  constructor(private roleService: RoleService) {
  }

  ngOnInit(): void {
    this.roles = this.roleService.getAllRoles();
  }

  showInfo() {
    if (this.selectedRoleTitle) {
      this.roleService.getRoleByTitle(this.selectedRoleTitle).subscribe((responseRole: Role) => {
          this.role = responseRole;
          this.roleSymbol = this.role.symbol;
          console.log(this.role);
        },
        error => console.log(error));
    }
  }

  updateInfo() {
    console.log(this.roleService.updateRole(this.role).subscribe((result: boolean) => console.log(result)));
  }

  showAddForm() {
    this.selectedRoleTitle = '';
    this.addFormFlag = !this.addFormFlag;
  }

  addRole() {
    const roleParameters = new RoleDto(this.roleTitle, this.roleSymbol, this.description);
    this.roleService.addRole(roleParameters).subscribe((responseRole: Role) => {
      this.role = responseRole;
    });
  }

}
