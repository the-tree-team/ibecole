import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource, MatPaginator, MatSort } from '@angular/material';
import { PersonneService } from 'src/services/business/personne.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-all-professeur',
  templateUrl: './all-professeur.component.html',
  styleUrls: ['./all-professeur.component.css']
})
export class AllProfesseurComponent implements OnInit {

  displayedColumns: string[] = ['id', 'nom', 'naissance', 'sexe', 'telephone', 'actions'];
  elevelist = null;
  dataSource: MatTableDataSource<any>;

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(private personneService: PersonneService,
    private router: Router) { }

  ngOnInit() {
    this.personneService.getProfesseurList().subscribe(results => {
      console.log("SUBSCRIBE============");
      console.log(results);
      this.dataSource = new MatTableDataSource(results);
    },
      // The 2nd callback handles errors.
      (err) => console.error(err),
      // The 3rd callback handles the "complete" event.
      () => {
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

  goToAddPersonne() {
    this.router.navigate(['/personne']);
  }

}
