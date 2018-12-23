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
    return this.http.get<TypeSanction[]>( `${UtilStatic.API_SOURCE}type_sanction/v1`,{observe: 'response'});
  }

  deleteTypeSanction(id: number){
    return this.http.delete(    `${UtilStatic.API_SOURCE}type_sanction/v1/${id}`);
  }

  createTypeSanction(typeSanction: TypeSanction) {
    const url = `${UtilStatic.API_SOURCE}type_sanction/v1/add`;
    console.log(url);
    return this.http.post( url, typeSanction);
  }
}
