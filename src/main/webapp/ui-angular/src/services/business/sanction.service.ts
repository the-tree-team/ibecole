import {Injectable} from '@angular/core';
import {UtilStatic} from "../UtilStatic";
import {HttpClient, HttpResponse} from '@angular/common/http';
import {Sanction} from "../../model/business/model.sanction";
import {map} from "rxjs/internal/operators";

@Injectable({
  providedIn: 'root'
})
export class SanctionService {

  constructor(private http: HttpClient) { }

  getSanctions() {
    return this.http.get<any>( `${UtilStatic.API_SOURCE}sanction/v1`,{observe: 'response'}) .pipe(
      map((data) => {
        return data.body.content.map(item =>{
          let sanction = new Sanction();
          sanction.id=item.id;
          sanction.motif = item.motif;
          sanction.commentaire = item.commentaire;
          sanction.type = item.type;
          return sanction;
        });
      }) // or any other operator
    );
  }

  deleteSanction(id: number){
    return this.http.delete(    `${UtilStatic.API_SOURCE}sanction/v1/${id}`);
  }

  createSanction(sanction: Sanction) {
    const url = `${UtilStatic.API_SOURCE}sanction/v1/add`;
    console.log(url);
    return this.http.post( url, sanction);
  }
  updateSanction(sanction: Sanction){
    const url = `${UtilStatic.API_SOURCE}sanction/v1/edit`;
    console.log(url);
    return this.http.put( url, sanction);
  }
}
