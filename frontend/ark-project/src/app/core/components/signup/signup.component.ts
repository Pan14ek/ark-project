import {Component, OnInit} from '@angular/core';
import {UserService} from '../../services/user.service';
import {UserSignUpDto} from '../../../models/dto/UserSignUpDto';
import {Router} from '@angular/router';
import {User} from '../../../models/entity/User';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  firstName: string;
  lastName: string;
  login: string;
  email: string;
  password: string;
  repeatPassword: string;

  constructor(private userService: UserService, private router: Router) {
  }

  ngOnInit(): void {
  }

  submitForm(): void {
    const userSignUpDto = new UserSignUpDto(this.firstName, this.lastName, this.login, this.email, this.password, this.repeatPassword);
    this.userService.signUpUser(userSignUpDto).subscribe(
      (user: User) => {
        this.redirect();
      },
      error => {
        console.log(error);
      }
    );
  }

  redirect() {
    this.router.navigate(['']);
  }

}
