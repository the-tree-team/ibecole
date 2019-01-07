import {Component, Inject, OnInit, ViewChild} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef, MatPaginator, MatSort, MatTableDataSource} from "@angular/material";
import {Matiere} from "../../../../../../../../model/business/model.matiere";
import {SelectionModel} from "@angular/cdk/collections";
import {UtilStatic} from "../../../../../../../../services/UtilStatic";

@Component({
  selector: 'app-add-matieres-dialog',
  templateUrl: './add-matieres-dialog.component.html',
  styleUrls: ['./add-matieres-dialog.component.css']
})
export class AddMatieresDialogComponent implements OnInit {
  private  selectedMatieres = [];
  private matieres= null;
  displayedColumns: string[] = ['select','id', 'code', 'libelle','couleur'];
  dataSource: MatTableDataSource<any>;
  selection;
  allowMultiSelect = true;

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;


  constructor(public dialogRef: MatDialogRef<AddMatieresDialogComponent>,
              @Inject(MAT_DIALOG_DATA) public data: any) { }

  ngOnInit() {
    this.matieres = this.data.matieres;
    this.selectedMatieres = this.data.selectedMatieres;
    this.dataSource = new MatTableDataSource(this.matieres);
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
    this.selection=new SelectionModel<Matiere>(true, this.selectedMatieres);
  }

  onNoClick() : void {
    console.log("DIALOG CLOSED");
    this.dialogRef.close();
  }

  onValidationClick() : void {
    console.log("DIALOG CLOSED with DATA");
    console.log(this.selectedMatieres);
    this.dialogRef.close(this.selectedMatieres);
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
      this.selectedMatieres=[];
    }else{
      this.dataSource.data.forEach(row => {
        this.selection.select(row);
        this.selectedMatieres.push(row);
      });
    }
  }

  onChangeListener($event,item){
    if($event.checked){
      console.log("CHECKED");
      this.selectedMatieres.push(item);
    }else{
      console.log("UNCHECKED");
      this.selectedMatieres=UtilStatic.arrayDeleteItem(this.selectedMatieres, item);
    }
  }
   isTooDark(color){
    return UtilStatic.isTooDark(color);
   }
}
