import { Component } from '@angular/core';
import {AuthenticationService} from "../services/admin/authentication.service";
import {Router} from "@angular/router";
import {User} from "../model/admin/user";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'IBECOlE';
  currentUser: User;
  loggedin: Boolean;
  constructor(
    private router: Router,
    private authenticationService: AuthenticationService
  ) {
    if (this.authenticationService.currentUserValue) {
      this.loggedin=  true;
    }else {
      this.loggedin=false;
    }

  }

  logout() {
    this.authenticationService.logout();
    this.router.navigate(['/login']);
  }

}
