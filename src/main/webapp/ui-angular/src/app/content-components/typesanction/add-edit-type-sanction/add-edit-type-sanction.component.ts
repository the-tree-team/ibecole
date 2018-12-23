import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material";
import {TypeSanction} from "../../../../model/business/model.typesanction";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-add-edit-type-sanction',
  templateUrl: './add-edit-type-sanction.component.html',
  styleUrls: ['./add-edit-type-sanction.component.css']
})
export class AddEditTypeSanctionComponent implements OnInit {

  addForm: FormGroup;

  constructor( public dialogRef: MatDialogRef<AddEditTypeSanctionComponent>,
               @Inject(MAT_DIALOG_DATA) public typeSanction: TypeSanction,
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
    this.typeSanction = new TypeSanction;
    this.typeSanction.code = this.code.value;
    this.typeSanction.libelle = this.libelle.value;
    this.dialogRef.close(this.typeSanction);
  }

  get code(){
    return this.addForm.get('code');
  }
  get libelle(){
    return this.addForm.get('libelle');
  }
}
