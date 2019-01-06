import { Injectable } from '@angular/core';
import {Personne} from "../../model/business/model.personne";
import {UtilStatic} from "../UtilStatic";
import {HttpClient, HttpHeaders} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class PersonneService {

  constructor(private http: HttpClient) { }


  createPersonne(personne: Personne) {
    const httpOptions = {
      headers: new HttpHeaders({
      })
    };
    let formData = new FormData();
    formData.append('file',personne.photo);

    personne.photo = null;
    formData.append('personne',
      new Blob(
        [JSON.stringify(personne)],
        {type: "application/json"}
      ));

    const url = `${UtilStatic.API_SOURCE}personne/v1/add`;
    console.log(url);
    /*   console.log(personne.photo);*/
    return this.http.post( url, formData, httpOptions);
  }
}
