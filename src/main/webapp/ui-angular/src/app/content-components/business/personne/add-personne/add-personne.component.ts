import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Personne} from "../../../../../model/business/model.personne";
import {PersonneService} from "../../../../../services/business/personne.service";
import {MatiereService} from "../../../../../services/business/matiere.service";

@Component({
  selector: 'app-add-personne',
  templateUrl: './add-personne.component.html',
  styleUrls: ['./add-personne.component.css']
})
export class AddPersonneComponent implements OnInit {
  addForm: FormGroup;
  sexeOptions=['Homme','Femme'];
  parentOptions;
  uploadedPhoto = false;
  createEleve: boolean=false;
  createParent: boolean=false;
  createProfesseur: boolean=false;
  uploadedFile: File;
  personne: Personne = new Personne();

  constructor(private fb: FormBuilder,
              private personneService: PersonneService,
              private matiereService: MatiereService
  ) { }

  ngOnInit() {
    this.createEleve=false;
    this.createParent=false;
    this.createProfesseur=false;
 /*   this.personneService.getEleveList().subscribe(results => {
      this.enfantsOptions = results;
    } );*/
    this.personneService.getParentList().subscribe(results => {
      console.log(results);
      this.parentOptions = results;
    } );
/*    this.matiereService.getAll().subscribe(results => {
      console.log(results);
      this.matieresOptions = results;
    } );*/
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
      parent:['',[

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
    this.f.type.setValue("Eleve")
  }
  onSelectPhoto($event){
    this.uploadedPhoto=true;
    const target = <HTMLInputElement>event.target;
    this.personne.photo= target.files[0];
    this.uploadedFile= target.files[0];
  }
  selectParent(){
    this.createParent=true;
    this.f.type.setValue("Parent");
    this.createEleve=false;
    this.createProfesseur=false;
    console.log(this.goToCreation);
  }
  selectEleve(){
    this.createEleve = true;
    this.f.type.setValue("Eleve");
    this.createParent=false;
    this.createProfesseur=false;
    console.log(this.goToCreation);
  }
  selectProfesseur(){
    this.createProfesseur=true;
    this.f.type.setValue("Professeur");
    this.createEleve=false;
    this.createParent=false;
    console.log(this.goToCreation);
  }
  onValidationClick(){
    this.personne.nom = this.f.nom.value;
    this.personne.prenom = this.f.prenom.value;
    this.personne.sexe= this.f.sexe.value;
    this.personne.dateNaissance= this.f.dateNaissance.value;
    this.personne.lieuNaissance= this.f.lieuNaissance.value;
    this.personne.adresse= this.f.adresse.value;
    this.personne.telephone= this.f.telephone.value;
    this.personne.email= this.f.email.value;
    this.personne.type = this.f.type.value;
    this.personne.active = true;
    if(this.personne.type === "Eleve"){
      this.personne.parent =  this.f.parent.value;
      console.log("ID:"+this.personne.parent.id);
    }else if(this.personne.type === "Parent"){

    }else{

    }

    this.personneService.createPersonne(this.personne).subscribe( data =>{
       console.log(data);

      }
    );
  }
  get parent(){
    return this.addForm.get('parent');
  }

  get f() { return this.addForm.controls; }
}
