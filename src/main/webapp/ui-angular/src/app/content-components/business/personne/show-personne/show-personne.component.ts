import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {PersonneService} from "../../../../../services/business/personne.service";
import {Personne} from "../../../../../model/business/model.personne";

@Component({
  selector: 'app-show-personne',
  templateUrl: './show-personne.component.html',
  styleUrls: ['./show-personne.component.css']
})
export class ShowPersonneComponent implements OnInit {
  id: string;
  type: string;
  personne: Personne;

  constructor(private personneService: PersonneService, public activatedRoute: ActivatedRoute) {
    this.type = this.activatedRoute.snapshot.paramMap.get('type');
    this.id = this.activatedRoute.snapshot.paramMap.get('id');
      console.log(this.type);
      console.log(this.id);

    this.personneService.getPersonne(this.id,this.type).subscribe(result => console.log(result));
  }

  ngOnInit() {
  }

}
