import {Component, OnInit, ViewChild} from '@angular/core';
import {SanctionService} from "../../../../../services/business/sanction.service";
import {MatDialog, MatPaginator, MatSnackBar, MatSort, MatTableDataSource} from "@angular/material";
import {Sanction} from "../../../../../model/business/model.sanction";
import {UtilStatic} from "../../../../../services/UtilStatic";
import {AddSanctionComponent} from "../add-sanction/add-sanction.component";
import {EditSanctionComponent} from "../edit-sanction/edit-sanction.component";

@Component({
  selector: 'app-all-sanction',
  templateUrl: './all-sanction.component.html',
  styleUrls: ['./all-sanction.component.css']
})
export class AllSanctionComponent implements OnInit {
  displayedColumns: string[] = ['id', 'motif', 'commentaire','type','add'];
  sanctions = null;
  dataSource: MatTableDataSource<any>;

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;


  constructor(private sanctionService: SanctionService,
              public addDialog: MatDialog,
              public editDialog: MatDialog,
              public snackBar: MatSnackBar) {
    this.sanctionService.getSanctions().subscribe((results: any) =>{
        console.log("SUBSCRIBE============");
        console.log(results);
        this.dataSource = new MatTableDataSource(results);
      },
      // The 2nd callback handles errors.
      (err) => console.error(err),
      // The 3rd callback handles the "complete" event.
      () =>
      {
        this.dataSource.paginator = this.paginator;
        // Faire un sort par rapport à une sous Propriété : sanction.type.libelle
        this.dataSource.sortingDataAccessor = (item, property) => {
          switch(property) {
            case 'type': return item.type.libelle;
            default: return item[property];
          }
        };
        this.dataSource.sort = this.sort;
        console.log("observable complete");
      }
    );

  }

  ngOnInit() {
  }


  deleteSectionListener(sanctionToDelete: Sanction){
    console.log("DELETE");
    const confirm = window.confirm('Êtes-vous sûr de bien vouloir supprimer cette entité ?');
    if ( confirm === true) {
      this.sanctionService.deleteSanction( sanctionToDelete.id )
        .subscribe( () => {
            console.log(this.dataSource.data);
            this.sanctions = this.dataSource.data;
            this.sanctions=UtilStatic.arrayDeleteItem(this.sanctions, sanctionToDelete);

            this.refresh();
          },
          err => {
            console.log('ERROR DELETE');
            alert('ERROR !');
          });
    }
  }

  openAddDialog(): void {
    const dialogRef = this.addDialog.open(AddSanctionComponent, {
      width: '450px'
    });
    //ADD TYPE SANCTION VIA DIALOG
    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      console.log(result);

      this.sanctionService.createSanction(result).subscribe( data =>{
          this.sanctions = this.dataSource.data;
          this.sanctions.push(data);
          this.refresh();
          this.snackBar.open("Création effectuée avec succès", "Fermer", {
            duration: 2000,
          });
        }

      );
    });
  }

  openEditDialog(sanctionEdit: Sanction): void {
    const dialogRef = this.editDialog.open(EditSanctionComponent, {
      width: '450px'
    });
    dialogRef.componentInstance.sanction = sanctionEdit;
    //EDIT SANCTION VIA DIALOG
    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      console.log(result);
      this.sanctionService.updateSanction(result).subscribe( sanctionEdited =>{
          this.sanctions = this.dataSource.data;
          this.sanctions=UtilStatic.arrayDeleteItem(this.sanctions, sanctionEdit);
          this.sanctions.push(sanctionEdited);
          this.refresh();
          this.snackBar.open("Edition effectuée avec succès", "Fermer", {
            duration: 2000,
          });
        }

      );
    });
  }
  applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }

  refresh(){
    this.dataSource = new MatTableDataSource<any>(this.sanctions);
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }
}
