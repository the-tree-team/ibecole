import { Injectable } from '@angular/core';
import {UtilStatic} from "../UtilStatic";
import {HttpClient} from '@angular/common/http';
import {map} from "rxjs/internal/operators";
import {Niveau} from "../../model/business/model.niveau";

@Injectable({
  providedIn: 'root'
})
export class NiveauService {

  constructor(private http: HttpClient) { }

  getNiveau() {
    return this.http.get<Niveau[]>( `${UtilStatic.API_SOURCE}niveau/v1`,{observe: 'response'});
  }
  getniveauList() {
    return this.http.get<any>( `${UtilStatic.API_SOURCE}niveau/v1`,{observe: 'response'})
      .pipe(
      map(data => {
        return data.body.content.map(item =>{
          return item;
        });
      }) // or any other operator
    );
  }
  deleteNiveau(id: number){
    return this.http.delete(    `${UtilStatic.API_SOURCE}niveau/v1/${id}`);
  }

  createNiveau(niveau: Niveau) {
    const url = `${UtilStatic.API_SOURCE}niveau/v1/add`;
    console.log(url);
    return this.http.post( url, niveau);
  }
  updateNiveau(niveau: Niveau){
    const url = `${UtilStatic.API_SOURCE}niveau/v1/edit`;
    console.log(url);
    return this.http.put( url, niveau);
  }
}
