import {Component, OnInit, ViewChild} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Personne} from "../../../../../model/business/model.personne";
import {PersonneService} from "../../../../../services/business/personne.service";
import {Router} from "@angular/router";

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

  @ViewChild ('selectedEnfantsComponents') selectedEnfantsComponents;
  @ViewChild ('selectedMatieresComponents') selectedMatieresComponents;
  constructor(private fb: FormBuilder,
              private personneService: PersonneService,
              private router: Router) { }

  ngOnInit() {
    this.createEleve=false;
    this.createParent=false;
    this.createProfesseur=false;

    this.personneService.getParentList().subscribe(results => {
      console.log(results);
      this.parentOptions = results;
    } );

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
    }else if(this.personne.type === "Parent"){
     this.personne.enfantList = this.selectedEnfantsComponents.selectedEnfants;
    }else{
      this.personne.dateNaissance = this.f.dateRecrutement.value;
      this.personne.matiereList = this.selectedMatieresComponents.selectedMatieres;
    }

    this.personneService.createPersonne(this.personne).subscribe( (data: Personne) =>{
      console.log("DATA:");
       console.log(data);
      this.personne = data;
      console.log("NAVIGATION");
      console.log(this.personne.id);
      this.router.navigate(['/showpersonne', this.personne.type, this.personne.id ]);/*
      this.router.navigate(['/showpersonne', {id: this.personne.id, type: this.personne.type}]);*/
  /*    this.router.navigate(['/typesanction']);*/
      }
    );

  }


  get f() { return this.addForm.controls; }
}
