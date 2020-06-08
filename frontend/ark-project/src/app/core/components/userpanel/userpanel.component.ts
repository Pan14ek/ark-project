import {Component, OnInit} from '@angular/core';
import {UserService} from '../../services/user.service';
import {UserSignUpDto} from '../../../models/dto/UserSignUpDto';
import {User} from '../../../models/entity/User';

@Component({
  selector: 'app-userpanel',
  templateUrl: './userpanel.component.html',
  styleUrls: ['./userpanel.component.css']
})
export class UserpanelComponent implements OnInit {

  user;
  addFormFlag;
  updateFormFlag;
  showAllUsersFlag;
  users;
  selectedUserLogin;
  firstName: string;
  lastName: string;
  login: string;
  email: string;
  password: string;
  repeatPassword: string;

  constructor(private userService: UserService) {
  }

  ngOnInit(): void {
    this.userService.getUsers().subscribe(users => this.users = users);
  }

  showAddForm() {
    this.addFormFlag = !this.addFormFlag;
  }

  showUpdateForm() {
    this.updateFormFlag = !this.updateFormFlag;
    this.selectedUserLogin = '';
  }

  showAllUsers() {
    this.showAllUsersFlag = !this.showAllUsersFlag;
  }

  submitForm(): void {
    const userSignUpDto = new UserSignUpDto(this.firstName, this.lastName, this.login, this.email, this.password, this.repeatPassword);
    this.userService.signUpUser(userSignUpDto).subscribe(
      (user: User) => {
        alert('Added success');
      },
      error => {
        console.log(error);
      }
    );
  }

  showInfo() {
    this.userService.getUser(this.selectedUserLogin).subscribe((user: User) => {
        this.user = user;
      },
      error => console.log(error));
  }

  updateUser() {
    this.userService.updateUser(this.user).subscribe((result: boolean) => console.log(result));
  }

}
