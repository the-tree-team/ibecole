import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {AllTypeSanctionComponent} from './content-components/business/typesanction/all-type-sanction/all-type-sanction.component';
import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from './login/login.component'
import {AllSanctionComponent} from "./content-components/business/sanction/all-sanction/all-sanction.component";
import {AddPersonneComponent} from "./content-components/business/personne/add-personne/add-personne.component";
import {RegisterComponent} from "./register/register.component";

export const routes : Routes = [
  { path: 'typesanction', component: AllTypeSanctionComponent },
  { path: 'login',        component: LoginComponent  },
  { path: 'sanction', component: AllSanctionComponent},
  { path: 'addpersonne', component: AddPersonneComponent},
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
