import {Component, Inject, OnInit} from '@angular/core';
import {Sanction} from "../../../../../model/business/model.sanction";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {TypeSanctionService} from "../../../../../services/business/type-sanction.service";

@Component({
  selector: 'app-edit-sanction',
  templateUrl: './edit-sanction.component.html',
  styleUrls: ['./edit-sanction.component.css']
})
export class EditSanctionComponent implements OnInit {
  editForm: FormGroup;
  private typeSanctionOptions: any;
  constructor(public dialogRef: MatDialogRef<EditSanctionComponent>,
              @Inject(MAT_DIALOG_DATA) public sanction: Sanction,
              private fb: FormBuilder,
              private typeSanctionService: TypeSanctionService
  ) {
    console.log("CONSTRUCTOR EDIT SANCTION");
    this.typeSanctionService.getTypeSanctionList().subscribe(results => {
        this.typeSanctionOptions = results;
        console.log("SUBSCRIBE OPTIONS----");
      },
      () =>{},
      ()=>{
      console.log("ON COMPLETE CALL");
      const typteToSelect = this.typeSanctionOptions.find(itemType=> itemType.id === this.sanction.type.id);
        this.editForm.get('type').reset(typteToSelect);
      });
  }

  ngOnInit() {
console.log("NGONINIT EDIT SANCTION--------");

    this.editForm = this.fb.group({
      motif:[this.sanction.motif,[
        Validators.required
      ]],
      commentaire: [this.sanction.commentaire,[
      ]],
      type: [null,[
        Validators.required
      ]]
    });

  }

  ngAfterViewInit(){
    console.log("AFTEER VIEW INITs");
  }
  onNoClick() : void {
    console.log("DIALOG CLOSED");
    this.dialogRef.close();
  }


  onValidationClick() : void {
    this.sanction.motif = this.motif.value;
    this.sanction.commentaire = this.commentaire.value;
    this.sanction.type= this.type.value;
    console.log(this.sanction);
    this.dialogRef.close(this.sanction);
  }

  get motif(){
    return this.editForm.get('motif');
  }
  get commentaire(){
    return this.editForm.get('commentaire');
  }
  get type(){
    return this.editForm.get('type');
  }

}
