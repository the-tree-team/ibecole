import { Component } from '@angular/core';
import {AuthenticationService} from "../services/admin/authentication.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'ui-angular';
  loggedin: Boolean;
  constructor(
    private authenticationService: AuthenticationService
  ) {
    // redirect to home if already logged in
    if (this.authenticationService.currentUserValue) {
    this.loggedin=  true;
    }else {
      this.loggedin=false;
    }
  }
}
