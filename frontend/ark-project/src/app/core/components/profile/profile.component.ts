import {Component, OnInit} from '@angular/core';
import {UserService} from '../../services/user.service';
import {User} from '../../../models/entity/User';
import {Router} from '@angular/router';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  user: User;

  constructor(private userService: UserService, private router: Router) {
  }

  ngOnInit(): void {
    if (localStorage.getItem('token')) {
      const login = localStorage.getItem('login');
      this.userService.getUser(login).subscribe((responseUser: User) => this.user = responseUser);
    } else {
      localStorage.setItem('needAuthorize', String(true));
      this.router.navigate(['']);
    }
  }

}
