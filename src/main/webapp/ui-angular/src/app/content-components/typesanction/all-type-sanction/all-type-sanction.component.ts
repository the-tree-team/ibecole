import {Component, OnInit, ViewChild} from '@angular/core';
import {MatPaginator, MatSort, MatTableDataSource} from "@angular/material";
import {TypeSanction} from "../../../../model/business/model.typesanction";
import {TypeSanctionService} from "../../../../services/business/type-sanction.service";
import {HttpClient} from "@angular/common/http";
import {UtilStatic} from "../../../../services/business/UtilStatic";

@Component({
  selector: 'app-all-type-sanction',
  templateUrl: './all-type-sanction.component.html',
  styleUrls: ['./all-type-sanction.component.css']
})
export class AllTypeSanctionComponent implements OnInit {
  /*displayedColumns: string[] = ['ID', 'Code', 'Libellé', 'Actions'];*/
  displayedColumns: string[] = ['ID', 'Code', 'Libellé'];
  typesSanction = null;
  dataSource: MatTableDataSource<TypeSanction[]> = new MatTableDataSource<TypeSanction[]>(this.typesSanction);

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(private http: HttpClient, private typeSanctionService: TypeSanctionService) {
    console.log("CONSTRUCT--------");

    this.typeSanctionService.getTypesSanction().subscribe((results: TypeSanction[])=>{
      console.log("SUBSCRIBE============")
        this.typesSanction = results;
      this.dataSource.data = this.typesSanction;
        console.log(this.dataSource.data);
      }
    );


  }

  ngOnInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }

  ngAfterViewInit(){

  }
  applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }
}
