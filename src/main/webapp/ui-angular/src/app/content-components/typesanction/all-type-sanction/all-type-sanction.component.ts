import {ChangeDetectorRef, Component, OnInit, ViewChild} from '@angular/core';
import {MatPaginator, MatSort, MatTableDataSource} from "@angular/material";
import {TypeSanction} from "../../../../model/business/model.typesanction";
import {TypeSanctionService} from "../../../../services/business/type-sanction.service";

@Component({
  selector: 'app-all-type-sanction',
  templateUrl: './all-type-sanction.component.html',
  styleUrls: ['./all-type-sanction.component.css']
})
export class AllTypeSanctionComponent implements OnInit {
  displayedColumns: string[] = ['id', 'code', 'libelle','add'];
  typesSanction = null;
  dataSource: MatTableDataSource<TypeSanction[]> = new MatTableDataSource<TypeSanction[]>(this.typesSanction);

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(private typeSanctionService: TypeSanctionService, private changeDetectorRefs: ChangeDetectorRef) {
    console.log("CONSTRUCT--------");
    this.typeSanctionService.getTypesSanction().subscribe((results: any) =>{
        console.log("SUBSCRIBE============");
        this.dataSource.data =  results.body.content ;
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
        .subscribe( data => {
              this.typesSanction = this.dataSource.data.filter(type => type.id != typeSanction.id);
              this.dataSource = new MatTableDataSource<TypeSanction[]>(this.typesSanction);
              this.dataSource.paginator = this.paginator;
            this.dataSource.sort = this.sort;

            console.log(data);
            /*this.dataSource.data.splice(
              this.dataSource.data.indexOf(typeSanction), 1
            );*/
          },
          err => {
            console.log('ERROR DELETE');
            alert('ERROR !');
          });
    }
  }


}
