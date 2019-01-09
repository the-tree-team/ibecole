import {Component, OnInit, ViewChild} from '@angular/core';
import {MatDialog, MatPaginator, MatSnackBar, MatSort, MatTableDataSource} from "@angular/material";

import {UtilStatic} from "../../../../../services/UtilStatic";

import {NiveauService} from "../../../../../services/business/niveau.service";
import {Niveau} from "../../../../../model/business/model.niveau";
import {AddNiveauComponent} from "../add-niveau/add-niveau.component";
import {EditNiveauComponent} from "../edit-niveau/edit-niveau.component";

@Component({
  selector: 'app-show-niveau',
  templateUrl: './show-niveau.component.html',
  styleUrls: ['./show-niveau.component.css']
})
export class ShowNiveauComponent implements OnInit {


  displayedColumns: string[] = ['id', 'code', 'libelle','action'];
  niveau = null;
  dataSource: MatTableDataSource<any>;

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(private niveauService: NiveauService,
              public addDialog: MatDialog,
              public editDialog: MatDialog,
              public snackBar: MatSnackBar) {
    console.log("CONSTRUCT--------");
    this.niveauService.getNiveau().subscribe((results: any) =>{
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



  applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }

  deleteNiveauListener(niveau: Niveau){
    console.log("DELETE");
    const confirm = window.confirm('Êtes-vous sûr de bien vouloir supprimer cette entité ?');
    if ( confirm === true) {
      this.niveauService.deleteNiveau(niveau.id )
        .subscribe( () => {
            console.log(this.dataSource.data);
            this.niveau = this.dataSource.data;
            this.niveau=UtilStatic.arrayDeleteItem(this.niveau, niveau);

            this.refresh();
          },
          err => {
            console.log('ERROR DELETE');
            alert('ERROR !');
          });
    }
  }

  openAddDialog(): void {
    const dialogRef = this.addDialog.open(AddNiveauComponent, {
      width: '450px'
    });
    //ADD NIVEAU VIA DIALOG
    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      console.log(result);

      this.niveauService.createNiveau(result).subscribe( data =>{
          this.niveau = this.dataSource.data;
          this.niveau.push(data);
          this.refresh();
          this.snackBar.open("Création effectuée avec succès", "Fermer", {
            duration: 2000,
          });
        }

      );
    });
  }

  openEditDialog(niveau: Niveau): void {
    const dialogRef = this.editDialog.open(EditNiveauComponent, {
      width: '450px'
    });
    dialogRef.componentInstance.niveau = niveau;
    //ADD TYPE SANCTION VIA DIALOG
    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      console.log(result);
      this.niveauService.updateNiveau(result).subscribe( niveauEdited =>{
          this.niveau = this.dataSource.data;
          this.niveau=UtilStatic.arrayDeleteItem(this.niveau, niveau);
          this.niveau.push(niveauEdited);
          this.refresh();
          this.snackBar.open("Edition effectuée avec succès", "Fermer", {
            duration: 2000,
          });
        }

      );
    });
  }
  refresh(){
    this.dataSource = new MatTableDataSource<any>(this.niveau);
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }

  ngOnInit() {

  }
}
