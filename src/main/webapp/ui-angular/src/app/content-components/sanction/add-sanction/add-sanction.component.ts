import {Component, Inject, OnInit} from '@angular/core';
import {Sanction} from "../../../../model/business/model.sanction";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material";
import {TypeSanctionService} from "../../../../services/business/type-sanction.service";
import {TypeSanction} from "../../../../model/business/model.typesanction";

@Component({
  selector: 'app-add-sanction',
  templateUrl: './add-sanction.component.html',
  styleUrls: ['./add-sanction.component.css']
})
export class AddSanctionComponent implements OnInit {
  addForm: FormGroup;
  private typeSanctionOptions: any;
  constructor(public dialogRef: MatDialogRef<AddSanctionComponent>,
              @Inject(MAT_DIALOG_DATA) public sanction: Sanction,
              private fb: FormBuilder,
              private typeSanctionService: TypeSanctionService
              ) { }

  ngOnInit() {
    this.typeSanctionService.getTypeSanctionList().subscribe(results => {
      this.typeSanctionOptions = results;
    } );

    this.addForm = this.fb.group({
      motif:['',[
        Validators.required
      ]],
      commentaire: ['',[
      ]],
      type: ['',[
      ]]
    });
  }
  onNoClick() : void {
    console.log("DIALOG CLOSED");
    this.dialogRef.close();
  }

  onValidationClick() : void {
    console.log("DIALOG VALIDATED");
    console.log(this.type.value);
    this.sanction = new Sanction();
    this.sanction.motif = this.motif.value;
    this.sanction.commentaire = this.commentaire.value;
    this.sanction.type= this.type.value;
    console.log(this.sanction);
    this.dialogRef.close(this.sanction);
  }

  get motif(){
    return this.addForm.get('motif');
  }
  get commentaire(){
    return this.addForm.get('commentaire');
  }
  get type(){
    return this.addForm.get('type');
  }

}
