import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {AllTypeSanctionComponent} from './content-components/typesanction/all-type-sanction/all-type-sanction.component';
import {RouterModule, Routes} from '@angular/router';
import {AllSanctionComponent} from "./content-components/sanction/all-sanction/all-sanction.component";

export const routes : Routes = [
  { path: 'typesanction', component: AllTypeSanctionComponent },
  { path: 'sanction', component: AllSanctionComponent},
  { path: '', redirectTo: '/dashboard', pathMatch: 'full' }
];
@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ]
})
export class AppRoutingModule { }
