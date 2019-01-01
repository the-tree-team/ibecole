import { Injectable } from '@angular/core';
import {Personne} from "../../model/business/model.personne";
import {UtilStatic} from "../UtilStatic";
import {HttpClient, HttpHeaders} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class PersonneService {

  constructor(private http: HttpClient) { }


  createPersonne(photo: File) {
    const httpOptions = {
      headers: new HttpHeaders({
      })
    };
    let formData = new FormData();
    formData.append('file',photo)
    const url = `${UtilStatic.API_SOURCE}personne/v1/add`;
    console.log(url);
 /*   console.log(personne.photo);*/
    return this.http.post( url, formData, httpOptions);
  }
}
