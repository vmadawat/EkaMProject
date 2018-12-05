import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable()
export class AuthService {
  constructor(private router: Router) {}

  public isAuthenticated(): boolean {
    if(localStorage.getItem('username') === 'admin') {
      return true;
    }   else {
    return false;
  }
}


logout(): void {
  localStorage.removeItem('username');
  this.router.navigate(['']);
}
}
