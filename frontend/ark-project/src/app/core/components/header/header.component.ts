import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  @ViewChild('navBurger') navBurger: ElementRef;
  @ViewChild('navMenu') navMenu: ElementRef;
  showSignInFormFlag = false;
  authorizeFlag = false;
  adminPanelFlag = false;

  constructor() {
  }

  ngOnInit(): void {
    const token = localStorage.getItem('token');
    this.authorizeFlag = !Object.is(token, null);
    const roleSymbol = localStorage.getItem('role');
    this.adminPanelFlag = Object.is(roleSymbol, 'A');
  }

  showSignInForm() {
    this.showSignInFormFlag = true;
  }

  signOut() {
    window.location.reload();
    this.authorizeFlag = false;
    localStorage.removeItem('token');
  }

  toggleNavbar() {
    this.navBurger.nativeElement.classList.toggle('is-active');
    this.navMenu.nativeElement.classList.toggle('is-active');
  }

}
