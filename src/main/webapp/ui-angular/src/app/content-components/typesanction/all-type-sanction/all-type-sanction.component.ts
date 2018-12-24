import {Component, OnInit, ViewChild} from '@angular/core';
import {MatDialog, MatPaginator, MatSnackBar, MatSort, MatTableDataSource} from "@angular/material";
import {TypeSanction} from "../../../../model/business/model.typesanction";
import {TypeSanctionService} from "../../../../services/business/type-sanction.service";
import {AddTypeSanctionComponent} from "../add-type-sanction/add-type-sanction.component";
import {EditTypeSanctionComponent} from "../edit-type-sanction/edit-type-sanction.component";
import {UtilStatic} from "../../../../services/UtilStatic";

@Component({
  selector: 'app-all-type-sanction',
  templateUrl: './all-type-sanction.component.html',
  styleUrls: ['./all-type-sanction.component.css']
})
export class AllTypeSanctionComponent implements OnInit {
  displayedColumns: string[] = ['id', 'code', 'libelle','add'];
  typesSanction = null;
  dataSource: MatTableDataSource<any>;

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(private typeSanctionService: TypeSanctionService,
              public addDialog: MatDialog,
              public editDialog: MatDialog,
              public snackBar: MatSnackBar) {
    console.log("CONSTRUCT--------");
    this.typeSanctionService.getTypesSanction().subscribe((results: any) =>{
        console.log("SUBSCRIBE============");
        this.dataSource = new MatTableDataSource(results.body.content);
      },
      // The 2nd callback handles errors.
      (err) => console.error(err),
      // The 3rd callback handles the "complete" event.
      () =>
      {
        /**
         * Contrairement à l'exemple dans "Angular Material" on doit initialiser ici notre "paginator" et"sort"
         * car la fonction "get" de "HttpClient" est une fonction asynchrone, ce qui fait qu'elle est toujours appellé avant
         * toutes les autres, et dans ce cas on aura une erreur de type "TypeError: data is null" si on fait notre initialisation
         * au niveau du "ngOnInit".
         * Ce qu'il faut par contre faire c'est de faire notre initialisation dans le callback "complete" du "subscribe" qui
         * s'inscrit comem observateur de la réponse de la méthode "get"
         * **/
        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.sort;
        console.log("observable complete");
      }
    );
  }

  ngOnInit() {

  }

  applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }

  deleteTypeSectionListener(typeSanction: TypeSanction){
    console.log("DELETE");
    const confirm = window.confirm('Êtes-vous sûr de bien vouloir supprimer cette entité ?');
    if ( confirm === true) {
      this.typeSanctionService.deleteTypeSanction( typeSanction.id )
        .subscribe( () => {
            console.log(this.dataSource.data);
            this.typesSanction = this.dataSource.data;
            this.typesSanction=UtilStatic.arrayDeleteItem(this.typesSanction, typeSanction);

            this.refresh();
          },
          err => {
            console.log('ERROR DELETE');
            alert('ERROR !');
          });
    }
  }

  openAddDialog(): void {
    const dialogRef = this.addDialog.open(AddTypeSanctionComponent, {
      width: '450px'
    });
    //ADD TYPE SANCTION VIA DIALOG
    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      console.log(result);

      this.typeSanctionService.createTypeSanction(result).subscribe( data =>{
          this.typesSanction = this.dataSource.data;
          this.typesSanction.push(data);
          this.refresh();
          this.snackBar.open("Création effectuée avec succès", "Fermer", {
            duration: 2000,
          });
        }

      );
    });
  }

  openEditDialog(typeSEdit: TypeSanction): void {
    const dialogRef = this.editDialog.open(EditTypeSanctionComponent, {
      width: '450px'
    });
    dialogRef.componentInstance.typeSanction = typeSEdit;
    //ADD TYPE SANCTION VIA DIALOG
    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      console.log(result);
      this.typeSanctionService.updateTypeSanction(result).subscribe( typeSanctionEdited =>{
        this.typesSanction = this.dataSource.data;
        this.typesSanction=UtilStatic.arrayDeleteItem(this.typesSanction, typeSEdit);
        this.typesSanction.push(typeSanctionEdited);
          this.refresh();
          this.snackBar.open("Edition effectuée avec succès", "Fermer", {
            duration: 2000,
          });
        }

      );
    });
  }
  refresh(){
    this.dataSource = new MatTableDataSource<any>(this.typesSanction);
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }
}
