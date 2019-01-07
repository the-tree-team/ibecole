import {Component, Inject, OnInit, ViewChild} from '@angular/core';
import {Personne} from "../../../../../../../../model/business/model.personne";
import {MAT_DIALOG_DATA, MatDialogRef, MatPaginator, MatSort, MatTableDataSource} from "@angular/material";
import {SelectionModel} from "@angular/cdk/collections";
import {UtilStatic} from "../../../../../../../../services/UtilStatic";

@Component({
  selector: 'app-add-enfants-dialog',
  templateUrl: './add-enfants-dialog.component.html',
  styleUrls: ['./add-enfants-dialog.component.css']
})
export class AddEnfantsDialogComponent implements OnInit {
  private  selectedEnfants = [];
  private enfants= null;
  displayedColumns: string[] = ['select','id', 'nom', 'prenom','matricule','datenaissance'];
  dataSource: MatTableDataSource<any>;
  selection;
  allowMultiSelect = true;

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(public dialogRef: MatDialogRef<AddEnfantsDialogComponent>,
              @Inject(MAT_DIALOG_DATA) public data: any
  ) { }

  ngOnInit() {
    /*this.selection = new SelectionModel<Personne>(this.allowMultiSelect, this.selectedEnfants);*/
    this.enfants = this.data.enfants;
    this.selectedEnfants = this.data.selectedEnfants;
    this.dataSource.sort = this.sort;
    this.selection=new SelectionModel<Personne>(true, this.selectedEnfants);
  }

  onNoClick() : void {
    console.log("DIALOG CLOSED");
    this.dialogRef.close();
  }

  onValidationClick() : void {
    console.log("DIALOG CLOSED with DATA");
    console.log(this.selectedEnfants);
    this.dialogRef.close(this.selectedEnfants);
  }

  applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }

  /** Whether the number of selected elements matches the total number of rows. */
  isAllSelected() {
    const numSelected = this.selection.selected.length;
    const numRows = this.dataSource.data.length;
    return numSelected == numRows;
  }

  /** Selects all rows if they are not all selected; otherwise clear selection. */
  masterToggle() {
    if(this.isAllSelected()){
      this.selection.clear()
      this.selectedEnfants=[];
    }else{
      this.dataSource.data.forEach(row => {
        this.selection.select(row);
        this.selectedEnfants.push(row);
      });
    }
  }

  onChangeListener($event,item){
    if($event.checked){
      console.log("CHECKED");
      this.selectedEnfants.push(item);
    }else{
      console.log("UNCHECKED");
      this.selectedEnfants=UtilStatic.arrayDeleteItem(this.selectedEnfants, item);
    }
  }
}
