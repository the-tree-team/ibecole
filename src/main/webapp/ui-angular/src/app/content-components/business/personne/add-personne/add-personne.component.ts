import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Personne} from "../../../../../model/business/model.personne";

@Component({
  selector: 'app-add-personne',
  templateUrl: './add-personne.component.html',
  styleUrls: ['./add-personne.component.css']
})
export class AddPersonneComponent implements OnInit {
  addForm: FormGroup;
  sexeOptions=['Homme','Femme'];
  uploadedPhoto = false;
  createEleve: boolean=false;
  createParent: boolean=false;
  createProfesseur: boolean=false;
  personne: Personne = new Personne();
  constructor(private fb: FormBuilder) { }

  ngOnInit() {
    this.createEleve=false;
    this.createParent=false;
    this.createProfesseur=false;
    this.addForm = this.fb.group({
      nom:['',[
        Validators.required,
        Validators.maxLength(30)
      ]],
      prenom:['',[
        Validators.required,
        Validators.maxLength(30)
      ]],
      sexe:['Homme',[
        Validators.required
      ]],
      dateNaissance:['',[

      ]],
      lieuNaissance:['',[

      ]],
      adresse:['',[
        Validators.required,
        Validators.maxLength(150)
      ]],
      telephone:['xxx-xx-xx-xx',[
        Validators.required,
        Validators.pattern("^[1-9]{2}[0-9]-[0-9]{2}-[0-9]{2}-[0-9]{2}$")
      ]],
      email:['',[
        Validators.maxLength(30),
        Validators.email
      ]],
      photo:['',[

      ]],
      active:['',[

      ]],
      idParent:['',[

      ]],
      enfantList:['',[

      ]],
      dateRecrutement:['',[

      ]],
      matiereList:['',[
        Validators.required
      ]],
      type:['Eleve',[

      ]],
    });
  }
  get goToCreation(){
    return this.createEleve || this.createParent || this.createProfesseur;
  }
  reset(){
    this.createParent = false;
    this.createEleve= false;
    this.createProfesseur= false;
    this.type.setValue("Eleve")
  }
  onSelectPhoto($event){
    this.uploadedPhoto=true;
    const target = <HTMLInputElement>event.target;
    this.personne.photo= target.files[0];
  }
  selectParent(){
    this.createParent=true;
    this.type.setValue("Parent");
    console.log(this.goToCreation);
  }
  selectEleve(){
    this.createEleve = true;
    this.type.setValue("Eleve");
    console.log(this.goToCreation);
  }
  selectProfesseur(){
    this.createProfesseur=true;
    this.type.setValue("Professeur");
    console.log(this.goToCreation);
  }

  get nom(){
    return this.addForm.get('nom');
  }
  get prenom(){
    return this.addForm.get('prenom');
  }
  get sexe(){
    return this.addForm.get('sexe');
  }
  get dateNaissance(){
    return this.addForm.get('dateNaissance');
  }
  get lieuNaissance(){
    return this.addForm.get('lieuNaissance');
  }
  get adresse(){
    return this.addForm.get('adresse');
  }
  get telephone(){
    return this.addForm.get('telephone');
  }
  get email(){
    return this.addForm.get('email');
  }
  get photo(){
    return this.addForm.get('photo');
  }
  get active(){
    return this.addForm.get('active');
  }
  get idParent(){
    return this.addForm.get('idParent');
  }
  get enfantList(){
    return this.addForm.get('enfantList');
  }
  get dateRecrutement(){
    return this.addForm.get('dateRecrutement');
  }
  get matiereList(){
    return this.addForm.get('matiereList');
  }
  get type(){
    return this.addForm.get('type');
  }
}
