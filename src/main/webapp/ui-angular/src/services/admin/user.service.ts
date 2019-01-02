/**
 * Created by TOSHIBA on 28/12/2018.
 */
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { SigneUpRequest } from '../../model/admin/signeUpRequest';

import { User } from '../../model/admin/user';
import {UtilStatic} from "../UtilStatic";


@Injectable({ providedIn: 'root' })
export class UserService {
  constructor(private http: HttpClient) { }

  getAll() {
    return this.http.get<User[]>(`/users`);
  }

  getById(id: number) {
    return this.http.get(`/users/` + id);
  }

  register(signeUpRequest :SigneUpRequest ) {
    return this.http.post<any>(UtilStatic.API_SOURCE+"api/auth/signup", signeUpRequest)
  }
  update(user: User) {
    return this.http.put(`/users/` + user.id, user);
  }

  delete(id: number) {
    return this.http.delete(`/users/` + id);
  }
}
