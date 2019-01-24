import {Component} from '@angular/core';
import {BreakpointObserver, Breakpoints} from '@angular/cdk/layout';
import {Observable} from 'rxjs';
import {map} from 'rxjs/operators';
import {AuthenticationService} from "../../../services/admin/authentication.service";
import {OnInit} from "@angular/core";
import {User} from "../../../model/admin/user";

@Component({
  selector: 'app-main-nav',
  templateUrl: './main-nav.component.html',
  styleUrls: ['./main-nav.component.css']
})
export class MainNavComponent implements OnInit {
  currentUser: User;
  isHandset$:Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches)
    );

  constructor(private breakpointObserver:BreakpointObserver,
              private authenticationService:AuthenticationService) {
             this.authenticationService.currentUser.subscribe(x => this.currentUser = x);
  }




  ngOnInit() {


     }


}
