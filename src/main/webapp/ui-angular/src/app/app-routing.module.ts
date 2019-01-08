import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {AllTypeSanctionComponent} from './content-components/business/typesanction/all-type-sanction/all-type-sanction.component';
import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from './content-components/admin/login/login.component'
import {AllSanctionComponent} from "./content-components/business/sanction/all-sanction/all-sanction.component";
import {AddPersonneComponent} from "./content-components/business/personne/add-personne/add-personne.component";
import {RegisterComponent} from "./content-components/admin/register/register.component";
import {AuthGuard} from "../guards/auth.guard";
import {ShowPersonneComponent} from "./content-components/business/personne/show-personne/show-personne.component";

export const routes : Routes = [
  { path: 'typesanction', component: AllTypeSanctionComponent ,
    canActivate: [AuthGuard]},
  { path: 'login',        component: LoginComponent  },
  { path: 'sanction', component: AllSanctionComponent ,
    canActivate: [AuthGuard]},
  { path: 'addpersonne', component: AddPersonneComponent,
          canActivate: [AuthGuard]},
  { path: 'showpersonne/:type/:id', component: ShowPersonneComponent,
          canActivate: [AuthGuard]},
  { path: 'register', component: RegisterComponent},
  { path: '', redirectTo: '/', pathMatch: 'full' }
];
@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ]
})
export class AppRoutingModule { }
