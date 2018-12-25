import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material";
import {TypeSanction} from "../../../../../model/business/model.typesanction";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-edit-type-sanction',
  templateUrl: './edit-type-sanction.component.html',
  styleUrls: ['./edit-type-sanction.component.css']
})
export class EditTypeSanctionComponent implements OnInit {
  editForm: FormGroup;
  constructor(public dialogRef: MatDialogRef<EditTypeSanctionComponent>,
              @Inject(MAT_DIALOG_DATA) public typeSanction: TypeSanction,
              private fb: FormBuilder) { }

  ngOnInit() {
    console.log("ON INIT EDIT");
    console.log(this.typeSanction);
    this.editForm = this.fb.group({
      code:[this.typeSanction.code,[
        Validators.required
      ]],
      libelle: [this.typeSanction.libelle,[
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
    this.typeSanction.code = this.code.value;
    this.typeSanction.libelle = this.libelle.value;
    this.dialogRef.close(this.typeSanction);
  }

  get code(){
    return this.editForm.get('code');
  }
  get libelle(){
    return this.editForm.get('libelle');
  }
}
