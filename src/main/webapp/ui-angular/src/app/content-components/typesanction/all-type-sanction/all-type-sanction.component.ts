import {Component, OnInit, ViewChild} from '@angular/core';
import {MatPaginator, MatSort, MatTableDataSource} from "@angular/material";
import {TypeSanction} from "../../../../model/business/model.typesanction";
import {TypeSanctionService} from "../../../../services/business/type-sanction.service";

@Component({
  selector: 'app-all-type-sanction',
  templateUrl: './all-type-sanction.component.html',
  styleUrls: ['./all-type-sanction.component.css']
})
export class AllTypeSanctionComponent implements OnInit {
  /*displayedColumns: string[] = ['ID', 'Code', 'Libellé', 'Actions'];*/
  displayedColumns: string[] = ['id', 'code', 'libelle'];
  typesSanction = null;
  dataSource: MatTableDataSource<TypeSanction[]> = new MatTableDataSource<TypeSanction[]>(this.typesSanction);

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(private typeSanctionService: TypeSanctionService) {
    console.log("CONSTRUCT--------");
    this.typeSanctionService.getTypesSanction().subscribe(results =>{
        console.log("SUBSCRIBE============");
        console.log(results);
        this.typesSanction = results.content;
        this.dataSource.data = this.typesSanction;
        console.log(this.dataSource.data);
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
  ngAfterViewInit(){
    console.log("AFTERVIEW-INIT");

  }

  applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }


}
