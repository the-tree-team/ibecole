import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';

import {    AuthenticationService } from '../../../../services/admin/authentication.service';
import {  UserService  } from '../../../../services/admin/user.service';
import { SigneUpRequest } from '../../../../model/admin/signeUpRequest';
import {User} from "../../../../model/admin/user";
import {Role} from "../../../../model/admin/role";
@Component({
  templateUrl: 'register.component.html',
  styleUrls: ['register.component.css']
})
export class RegisterComponent implements OnInit {
  registerForm: FormGroup;
  loading = false;
  submitted = false;
  error ='';

  rolesList: Role[]=[{id:null,name:"ROLE_USER"},{id:null,name:"ROLE_ADMIN"}];

  // rolesList: Role[]=[new Role('ROLE_USER'), new Role('ROLE_ADMIN')];


  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private authenticationService: AuthenticationService,
    private userService: UserService,

    private signeUpRequest : SigneUpRequest,

  ) {
    // redirect to home if already logged in
    /*if (this.authenticationService.currentUserValue) {
      this.router.navigate(['/']);
    }*/
  }

  ngOnInit() {
    this.registerForm = this.formBuilder.group({
      name: ['', Validators.required],
      username: ['', Validators.required],
      email: ['', Validators.required],
      password: ['', [Validators.required, Validators.minLength(6)]],
      roles: ['', [Validators.required]]
    });
  }

  // convenience getter for easy access to form fields
  get f() { return this.registerForm.controls; }

  onSubmit() {
    this.submitted = true;

    // stop here if form is invalid
    // if (this.registerForm.invalid) {
    //   console.log("invalid" + this.username.value);
    //   console.log("invalid" + this.password.value);
    //   console.log("invalid" + this.email.value);
    //   console.log("invalid" + this.name.value);
    //
    //   return;
    // }

    this.loading = true;

    this.signeUpRequest = new SigneUpRequest;
    this.signeUpRequest.username= this.f.username.value;
    this.signeUpRequest.password= this.f.password.value;
    this.signeUpRequest.name= this.f.name.value;
    this.signeUpRequest.email= this.f.email.value;
    this.signeUpRequest.roles= this.f.roles.value;
    console.log(this.f.roles.value)
    this.userService.register(this.signeUpRequest)
      .pipe(first())
      .subscribe(
        data => {
          // this.alertService.success('Registration successful', true);
          this.router.navigate(['/login']);
        },
        error => {
          // this.alertService.error(error);
          this.loading = false;
        });
  }


}
