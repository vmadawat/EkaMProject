import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import { LoginUser } from './loginuser';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  constructor(private router: Router) { }

  loginUser: LoginUser = new LoginUser();
  ngOnInit() {
  }

  login(loginUser: LoginUser): void {
    if  (loginUser.username === 'admin' && loginUser.password === 'admin') {
      localStorage.setItem('username', 'admin');
     this.router.navigate(['/users']);
    } else {
      alert('Invalid credentials');
    }
  }

  processForm() {
  this.login(this.loginUser);
  }
  }
