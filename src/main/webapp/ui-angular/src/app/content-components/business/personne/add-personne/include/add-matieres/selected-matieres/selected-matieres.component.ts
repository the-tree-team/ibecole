import {Component, OnInit, ViewChild} from '@angular/core';
import {Matiere} from "../../../../../../../../model/business/model.matiere";
import {MatDialog, MatPaginator, MatSort, MatTableDataSource} from "@angular/material";
import {MatiereService} from "../../../../../../../../services/business/matiere.service";
import {AddMatieresDialogComponent} from "../add-matieres-dialog/add-matieres-dialog.component";
import {UtilStatic} from "../../../../../../../../services/UtilStatic";

@Component({
  selector: 'app-selected-matieres',
  templateUrl: './selected-matieres.component.html',
  styleUrls: ['./selected-matieres.component.css']
})
export class SelectedMatieresComponent implements OnInit {
  displayedColumns: string[] = ['id', 'code', 'libelle','couleur'];
  selectedMatieres = [];
  matieres: Matiere[];
  dataSource: MatTableDataSource<any>;

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(private matiereService: MatiereService,
              public selectDialog: MatDialog) {
    this.dataSource = new MatTableDataSource(this.selectedMatieres);
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }

  ngOnInit() {
    this.matiereService.getAll().subscribe((results: any) =>{
      this.matieres=results;
    });
  }

  applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }


  openSelectDialog(): void {
    const dialogRef = this.selectDialog.open(AddMatieresDialogComponent, {
      width: '800px',
      data: {
        matieres: this.matieres,
        selectedMatieres: this.selectedMatieres
      }
    });

    //SELECT ENFANTS VIA DIALOG
    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      console.log(result);
      if(result!=null){
        this.selectedMatieres = result;
        this.refresh();
      }
    });
  }

  refresh(){
    this.dataSource = new MatTableDataSource<any>(this.selectedMatieres);
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }
  isTooDark(color){
    return UtilStatic.isTooDark(color);
  }
}
