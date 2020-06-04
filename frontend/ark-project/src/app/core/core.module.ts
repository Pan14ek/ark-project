import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HeaderComponent} from './components/header/header.component';
import {FooterComponent} from './components/footer/footer.component';
import {UserService} from './services/user.service';
import {RouterModule} from '@angular/router';
import {ContactComponent} from './components/contact/contact.component';
import {UserListComponent} from './components/users/user-list/user-list.component';
import {UserSingleComponent} from './components/users/user-single/user-single.component';
import {SignInComponent} from './components/signin/sign-in.component';
import {MatButtonModule} from '@angular/material/button';
import {SignupComponent} from './components/signup/signup.component';
import {ProfileComponent} from './components/profile/profile.component';
import {AdminpanelComponent} from './components/adminpanel/adminpanel.component';
import {UserpanelComponent} from './components/userpanel/userpanel.component';
import {RolepanelComponent} from './components/rolepanel/rolepanel.component';
import {RoleService} from './services/role.service';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatSelectModule} from '@angular/material/select';
import {MatInputModule} from '@angular/material/input';
import {SchedulesComponent} from './components/schedules/schedules.component';
import {PersonalScheduleService} from './services/personal-schedule.service';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {UserScheduleComponent} from './components/user-schedule/user-schedule.component';
import {ConfirmDayComponent} from './components/confirm-day/confirm-day.component';
import {HomeComponent} from './components/home/home.component';
import {TranslateModule} from '@ngx-translate/core';
import {FilterWorklogComponent} from './components/filter-worklog/filter-worklog.component';
import {FilterInfoComponent} from './components/filter-info/filter-info.component';
import {UnitInfoComponent} from './components/unit-info/unit-info.component';

@NgModule({
  declarations: [
    HeaderComponent,
    FooterComponent,
    ContactComponent,
    UserListComponent,
    UserSingleComponent,
    SignInComponent,
    SignupComponent,
    ProfileComponent,
    AdminpanelComponent,
    UserpanelComponent,
    RolepanelComponent,
    SchedulesComponent,
    UserScheduleComponent,
    ConfirmDayComponent,
    HomeComponent,
    FilterWorklogComponent,
    FilterInfoComponent,
    UnitInfoComponent
  ],
  imports: [
    CommonModule,
    RouterModule,
    FormsModule,
    MatButtonModule,
    MatFormFieldModule,
    MatSelectModule,
    MatInputModule,
    MatDatepickerModule,
    ReactiveFormsModule,
    TranslateModule
  ],
  exports: [
    HeaderComponent,
    FooterComponent,
    ContactComponent,
    UserListComponent,
    UserSingleComponent,
    SignInComponent,
    SignupComponent,
    ProfileComponent,
    SchedulesComponent,
    UserScheduleComponent,
    ConfirmDayComponent,
    FilterWorklogComponent,
    HomeComponent,
    FilterInfoComponent,
    UnitInfoComponent
  ],
  providers: [
    UserService,
    RoleService,
    PersonalScheduleService
  ]
})
export class CoreModule {
}
