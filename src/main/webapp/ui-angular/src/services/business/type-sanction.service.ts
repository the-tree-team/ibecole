import { Injectable } from '@angular/core';
import {UtilStatic} from "./UtilStatic";
import {HttpClient} from '@angular/common/http';
import {TypeSanction} from '../../model/business/model.typesanction';

@Injectable({
  providedIn: 'root'
})
export class TypeSanctionService {

  constructor(private http: HttpClient) { }

  getTypesSanction() {
    return this.http.get<>( `${UtilStatic.API_SOURCE}type_sanction/v1`);
  }
}
