import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Niveau} from "../../../../../model/business/model.niveau";
import {AuthenticationService} from "../../../../../services/admin/authentication.service";
import {UserService} from "../../../../../services/admin/user.service";
import {User} from "../../../../../model/admin/user";
import {Subscription} from "rxjs/index";
@Component({
  selector: 'app-add-niveau',
  templateUrl: './add-niveau.component.html',
  styleUrls: ['./add-niveau.component.css']
})
export class AddNiveauComponent implements OnInit {

  addForm: FormGroup;
  currentUser: User;

  constructor( public dialogRef: MatDialogRef<AddNiveauComponent>,
               @Inject(MAT_DIALOG_DATA) public niveau: Niveau,
               private fb: FormBuilder) { }

  ngOnInit() {
    this.addForm = this.fb.group({
      code:['',[
        Validators.required
      ]],
      libelle: ['',[
        Validators.required
      ]]
    });
  }

  onNoClick() : void {
    console.log("DIALOG CLOSED");
    this.dialogRef.close();
  }
  onValidationClick() : void {
    console.log("DIALOG VALIDATED");
    console.log(this.code.value);
    this.niveau = new Niveau;
    this.niveau.code = this.code.value;
    this.niveau.libelle = this.libelle.value;
    this.dialogRef.close(this.niveau);
  }

  get code(){
    return this.addForm.get('code');
  }
  get libelle(){
    return this.addForm.get('libelle');
  }

}
