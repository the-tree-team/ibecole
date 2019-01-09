import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Niveau} from "../../../../../model/business/model.niveau";
@Component({
  selector: 'app-edit-niveau',
  templateUrl: './edit-niveau.component.html',
  styleUrls: ['./edit-niveau.component.css']
})
export class EditNiveauComponent implements OnInit {

  editForm: FormGroup;
  constructor(public dialogRef: MatDialogRef<EditNiveauComponent>,
              @Inject(MAT_DIALOG_DATA) public niveau: Niveau,
              private fb: FormBuilder) { }

  ngOnInit() {
    console.log("ON INIT EDIT");
    console.log(this.niveau);
    this.editForm = this.fb.group({
      code:[this.niveau.code,[
        Validators.required
      ]],
      libelle: [this.niveau.libelle,[
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
    this.niveau.code = this.code.value;
    this.niveau.libelle = this.libelle.value;
    this.dialogRef.close(this.niveau);
  }

  get code(){
    return this.editForm.get('code');
  }
  get libelle(){
    return this.editForm.get('libelle');
  }
}
