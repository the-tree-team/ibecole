import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AllTypeSanctionComponent } from '../content-components/business/typesanction/all-type-sanction/all-type-sanction.component';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from '../content-components/admin/login/login.component'
import { AllSanctionComponent } from "../content-components/business/sanction/all-sanction/all-sanction.component";
import { AddPersonneComponent } from "../content-components/business/personne/add-personne/add-personne.component";
import { RegisterComponent } from "../content-components/admin/register/register.component";
import { AuthGuard } from "../../guards/auth.guard";
import { ShowPersonneComponent } from "../content-components/business/personne/show-personne/show-personne.component";
import { ShowNiveauComponent } from "../content-components/business/niveau/show-niveau/show-niveau.component";
import { AllEleveComponent } from '../content-components/business/personne/all-eleve/all-eleve.component';
import { AllParentComponent } from '../content-components/business/personne/all-parent/all-parent.component';
import { AllProfesseurComponent } from '../content-components/business/personne/all-professeur/all-professeur.component';

export const Approutes: Routes = [
  // { path: 'sanction', component: AllSanctionComponent , canActivate: [AuthGuard]},
  {
    path: 'typesanction', component: AllTypeSanctionComponent,
    canActivate: [AuthGuard]
  }


];
@NgModule({
  declarations: [],
  imports: [
    RouterModule.forChild(Approutes)
  ]
})
export class SecondaryRoutingModule { }
