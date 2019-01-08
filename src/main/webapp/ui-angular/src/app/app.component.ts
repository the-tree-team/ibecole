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
  title = 'ui-angular';
  currentUser: User;
  loggedin: Boolean;
  constructor(
    private router: Router,
    private authenticationService: AuthenticationService
  ) {
    // if (this.authenticationService.currentUserValue) {
    //   this.loggedin=  true;
    // }else {
    //   this.loggedin=false;
    // }
    this.authenticationService.currentUser.subscribe(x => this.currentUser = x);
  }

  logout() {
    this.authenticationService.logout();
    this.router.navigate(['/login']);
  }

}
