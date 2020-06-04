import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {HomeComponent} from './core/components/home/home.component';
import {ContactComponent} from './core/components/contact/contact.component';
import {SignupComponent} from './core/components/signup/signup.component';
import {ProfileComponent} from './core/components/profile/profile.component';
import {AdminpanelComponent} from './core/components/adminpanel/adminpanel.component';
import {UserpanelComponent} from './core/components/userpanel/userpanel.component';
import {RolepanelComponent} from './core/components/rolepanel/rolepanel.component';
import {SchedulesComponent} from './core/components/schedules/schedules.component';
import {UserScheduleComponent} from './core/components/user-schedule/user-schedule.component';
import {ConfirmDayComponent} from './core/components/confirm-day/confirm-day.component';
import {FilterWorklogComponent} from './core/components/filter-worklog/filter-worklog.component';
import {FilterInfoComponent} from './core/components/filter-info/filter-info.component';
import {UnitInfoComponent} from './core/components/unit-info/unit-info.component';

const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
    pathMatch: 'full'
  },
  {
    path: 'contact',
    component: ContactComponent
  },
  {
    path: 'users',
    loadChildren: () => import('./modules/users/users.module').then(m => m.UsersModule)
  },
  {
    path: 'join',
    component: SignupComponent
  },
  {
    path: 'profile',
    component: ProfileComponent
  },
  {
    path: 'admin/panel',
    component: AdminpanelComponent
  },
  {
    path: 'admin/panel/users',
    component: UserpanelComponent
  },
  {
    path: 'admin/panel/roles',
    component: RolepanelComponent
  }, {
    path: 'admin/panel/schedule',
    component: SchedulesComponent
  },
  {
    path: 'user/schedule',
    component: UserScheduleComponent
  },
  {
    path: 'schedule/confirm',
    component: ConfirmDayComponent
  },
  {
    path: 'filter/work/log',
    component: FilterWorklogComponent
  },
  {
    path: 'filter/info',
    component: FilterInfoComponent
  },
  {
    path: 'unit/info',
    component: UnitInfoComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
