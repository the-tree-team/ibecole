import { Injectable ,Inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { LoginRequest } from '../../model/admin/loginRequest';
import { User } from '../../model/admin/user';
import {UtilStatic} from "../UtilStatic";

@Injectable({ providedIn: 'root' })
export class AuthenticationService {
  private currentUserSubject: BehaviorSubject<User>;
  public currentUser: Observable<User>;

  constructor(private http: HttpClient  ) {
    this.currentUserSubject = new BehaviorSubject<User>(JSON.parse(localStorage.getItem('currentUser')));
    this.currentUser = this.currentUserSubject.asObservable();
  }

  public get currentUserValue(): User {
    return this.currentUserSubject.value;
  }
  public  afficherNavBar(): boolean {
    if (localStorage.getItem('currentUser')===null)
    {
      console.log("localStorage.getItem('currentUser')++++++++++ "+localStorage.getItem('currentUser'));
      return false;
    }
    else{ console.log("localStorage.getItem('currentUser ============ ') "+localStorage.getItem('currentUser'));
      return true};
  }




  login(loginRequest :LoginRequest ) {
    return this.http.post<any>(UtilStatic.API_SOURCE+"api/auth/signin", loginRequest)

      .pipe(map(user => {
        // login successful if there's a jwt token in the response
        // if (user && user.token) {
        if (JSON.stringify(user)) {
          // store user details and jwt token in local storage to keep user logged in between page refreshes
          localStorage.setItem('currentUser', JSON.stringify(user));
          console.log(" user"+user.accessToken+" == = = = = = "+JSON.stringify(user) );

          this.currentUserSubject.next(user);
        }

        return user;
      }));
  }





  logout() {
    // remove user from local storage to log user out
    localStorage.removeItem('currentUser');
    this.currentUserSubject.next(null);

  }
}
