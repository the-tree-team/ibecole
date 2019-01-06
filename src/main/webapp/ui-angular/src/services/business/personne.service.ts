import { Injectable } from '@angular/core';
import {Personne} from "../../model/business/model.personne";
import {UtilStatic} from "../UtilStatic";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {map} from "rxjs/internal/operators";

@Injectable({
  providedIn: 'root'
})
export class PersonneService {

  constructor(private http: HttpClient) { }

  getEleveList() {
    return this.http.get<any>( `${UtilStatic.API_SOURCE}personne/v1/eleves`,{observe: 'response'}) .pipe(
      map(data => {
        return data.body.content.map(item =>{
          let personne = new Personne();
          personne.id= item.id;
          personne.nom = item.nom;
          personne.prenom = item.prenom;
          personne.dateNaissance = item.dateNaissance;
          personne.lieuNaissance = item.lieuNaissance;
          personne.adresse = item.adresse;
          personne.email = item.email;
          personne.telephone= item.telephone;
          if(item.matricule!=null){
            personne.matricule = item.matricule;
          }
          return personne;
        });
      }) // or any other operator
    );
  }
  getParentList() {
    return this.http.get<any>( `${UtilStatic.API_SOURCE}personne/v1/parents`,{observe: 'response'}) .pipe(
      map(data => {
        return data.body.content.map(item =>{
          return item;
        });
      }) // or any other operator
    );
  }
  getProfesseurList() {
    return this.http.get<any>( `${UtilStatic.API_SOURCE}personne/v1/professeurs`,{observe: 'response'}) .pipe(
      map(data => {
        return data.body.content.map(item =>{
          return item;
        });
      }) // or any other operator
    );
  }

  createPersonne(personne: Personne) {
    console.log("PARENT:"+ personne.parent);

    var seen = [];

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

    return this.http.post( url, formData, httpOptions);
  }
}
