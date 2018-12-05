import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {HttpModule} from '@angular/http';
import {FormsModule} from '@angular/forms';
import { AppComponent } from './app.component';
import { ListuserComponent } from './components/listuser/listuser.component';
import { UserFormComponent } from './components/user-form/user-form.component';
import {UserService} from './shared-service/user.service';
import { LoginComponent } from './components/login/login.component';
import { AuthGuardService } from './components/authguard.service';
import { AuthService } from './components/auth.service';

const appRoutes: Routes = [
  {
    path: '',
    component: LoginComponent
  },
  {
    path: 'users',
    component: ListuserComponent,
    canActivate: [AuthGuardService]
  },
    {
      path: 'update',
       component: UserFormComponent,
       canActivate: [AuthGuardService]
    },
    {
      path: '**',
      redirectTo: 'users'
    }
];

@NgModule({
  declarations: [
    AppComponent,
    ListuserComponent,
    UserFormComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    FormsModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [UserService, AuthGuardService, AuthService],
  bootstrap: [AppComponent]
})
export class AppModule { }
