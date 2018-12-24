import {Component, OnInit, ViewChild} from '@angular/core';
import {SanctionService} from "../../../../services/business/sanction.service";
import {MatPaginator, MatSort, MatTableDataSource} from "@angular/material";

@Component({
  selector: 'app-all-sanction',
  templateUrl: './all-sanction.component.html',
  styleUrls: ['./all-sanction.component.css']
})
export class AllSanctionComponent implements OnInit {
  displayedColumns: string[] = ['id', 'motif', 'commentaire','type','add'];
  sanction = null;
  dataSource: MatTableDataSource<any>;

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;
  constructor(private sanctionService: SanctionService) {
    this.sanctionService.getSanctions().subscribe((results: any) =>{
        console.log("SUBSCRIBE============");
        console.log(results);
/*        console.log(results.body.content);*/
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

}
