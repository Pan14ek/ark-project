import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {TranslateService} from '@ngx-translate/core';

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

  constructor(public translate: TranslateService) {
    translate.addLangs(['en', 'ua']);
    if (localStorage.getItem('locale')) {
      const browserLang = localStorage.getItem('locale');
      translate.use(browserLang.match(/en|ua/) ? browserLang : 'en');
    } else {
      localStorage.setItem('locale', 'en');
      translate.setDefaultLang('en');
    }
  }

  changeLang(language: string) {
    localStorage.setItem('locale', language);
    this.translate.use(language);
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
    localStorage.removeItem('userId');
    localStorage.removeItem('login');
    localStorage.removeItem('role');
  }

  toggleNavbar() {
    this.navBurger.nativeElement.classList.toggle('is-active');
    this.navMenu.nativeElement.classList.toggle('is-active');
  }

}
