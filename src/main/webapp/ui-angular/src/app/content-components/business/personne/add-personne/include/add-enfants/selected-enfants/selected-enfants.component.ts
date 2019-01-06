import {Component, OnInit, ViewChild} from '@angular/core';
import {MatDialog, MatPaginator, MatSort, MatTableDataSource} from "@angular/material";
import {PersonneService} from "../../../../../../../../services/business/personne.service";
import {Personne} from "../../../../../../../../model/business/model.personne";

@Component({
  selector: 'app-selected-enfants',
  templateUrl: './selected-enfants.component.html',
  styleUrls: ['./selected-enfants.component.css']
})
export class SelectedEnfantsComponent implements OnInit {
  displayedColumns: string[] = ['id', 'nom', 'prenom','matricule','datenaissance'];
  selectedEnfants = null;
  enfants: Personne[];
  dataSource: MatTableDataSource<any>;

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(private personneService: PersonneService,
              public selectDialog: MatDialog) {
    this.dataSource = new MatTableDataSource(this.selectedEnfants);
    this.dataSource.paginator = this.paginator;
    // Faire un sort par rapport à une sous Propriété : sanction.type.libelle
    this.dataSource.sortingDataAccessor = (item, property) => {
      switch(property) {
        case 'type': return item.type.libelle;
        default: return item[property];
      }
    };
    this.dataSource.sort = this.sort;

  }

  ngOnInit() {
    this.personneService.getEleveList().subscribe((results: any) =>{
        this.enfants=results;
      });
  }

  applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }
}
