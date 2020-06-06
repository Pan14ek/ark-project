import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {Router} from '@angular/router';
import {UserSignInDto} from '../../../models/dto/UserSignInDto';
import {UserService} from '../../services/user.service';
import {UserToken} from '../../../models/entity/UserToken';

@Component({
  selector: 'app-signin',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent implements OnInit {

  @Output() closeForm: EventEmitter<any> = new EventEmitter();

  login;
  password;

  constructor(private router: Router, private userService: UserService) {
  }

  ngOnInit(): void {
  }

  close() {
    this.closeForm.emit(null);
  }

  redirectToSignUpPage() {
    this.router.navigate(['/join']);
    this.closeForm.emit(null);
  }

  submitForm() {
    const userSignInDto = new UserSignInDto(this.login, this.password);
    this.userService.signInUser(userSignInDto).subscribe((userToken: UserToken) => {
        console.log(userToken);
        localStorage.setItem('token', 'Bearer ' + userToken.token);
        localStorage.setItem('userId', String(userToken.user.id));
        localStorage.setItem('login', userToken.user.login);
        localStorage.setItem('role', userToken.user.role.symbol);
        this.redirectToHome();
        this.closeForm.emit(null);
        window.location.reload();
      },
      error => console.log(error)
    );
  }

  redirectToHome() {
    this.router.navigate(['']);
  }

}
