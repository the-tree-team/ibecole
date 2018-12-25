import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {TypeSanction} from "../../../../../model/business/model.typesanction";

@Component({
  selector: 'app-add-edit-type-sanction',
  templateUrl: './add-type-sanction.component.html',
  styleUrls: ['./add-type-sanction.component.css']
})
export class AddTypeSanctionComponent implements OnInit {

  addForm: FormGroup;

  constructor( public dialogRef: MatDialogRef<AddTypeSanctionComponent>,
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
