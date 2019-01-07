import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {UtilStatic} from "../UtilStatic";
import {map} from "rxjs/internal/operators";

@Injectable({
  providedIn: 'root'
})
export class MatiereService {

  constructor(private http: HttpClient) { }


  getAll() {
    return this.http.get<any>( `${UtilStatic.API_SOURCE}matiere/v1/`,{observe: 'response'}) .pipe(
      map(data => {
        return data.body.content.map(item =>{
          return item;
        });
      }) // or any other operator
    );
  }
}
