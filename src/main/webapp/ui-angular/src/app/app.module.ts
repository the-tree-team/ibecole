import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {LayoutModule} from '@angular/cdk/layout';
import {
  MatButtonModule,
  MatCardModule, MatCheckboxModule,
  MatDatepickerModule,
  MatDialogModule,
  MatExpansionModule,
  MatFormFieldModule,
  MatGridListModule,
  MatIconModule,
  MatInputModule,
  MatListModule,
  MatMenuModule, MatNativeDateModule,
  MatPaginatorModule,
  MatSelectModule,
  MatSidenavModule,
  MatSlideToggleModule,
  MatSnackBarModule,
  MatSortModule,
  MatTableModule,
  MatToolbarModule
} from '@angular/material';
import {MainNavComponent} from './ui-components/main-nav/main-nav.component';
import {AppRoutingModule} from './app-routing.module';
import {AllTypeSanctionComponent} from './content-components/business/typesanction/all-type-sanction/all-type-sanction.component';
import {RouterModule} from "@angular/router";
import {HttpClientModule} from "@angular/common/http";
import {AddTypeSanctionComponent} from './content-components/business/typesanction/add-type-sanction/add-type-sanction.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {EditTypeSanctionComponent} from './content-components/business/typesanction/edit-type-sanction/edit-type-sanction.component';
import {AllSanctionComponent} from './content-components/business/sanction/all-sanction/all-sanction.component';
import {AddSanctionComponent} from './content-components/business/sanction/add-sanction/add-sanction.component';
import {EditSanctionComponent} from './content-components/business/sanction/edit-sanction/edit-sanction.component';
import {AddPersonneComponent} from './content-components/business/personne/add-personne/add-personne.component';
import { LoginComponent } from './content-components/admin/login/login.component';
import { LoginRequest } from '../model/admin/loginRequest';
import {AuthenticationService} from "../services/admin/authentication.service";
import { RegisterComponent } from './content-components/admin/register/register.component';
import {SigneUpRequest} from "../model/admin/signeUpRequest";
import {Role} from "../model/admin/role";
import {User} from "../model/admin/user";
import {AddEnfantsDialogComponent} from "./content-components/business/personne/add-personne/include/add-enfants/add-enfants-dialog/add-enfants-dialog.component";
import {AddMatieresDialogComponent} from "./content-components/business/personne/add-personne/include/add-matieres/add-matieres-dialog/add-matieres-dialog.component";
import {SelectedEnfantsComponent} from "./content-components/business/personne/add-personne/include/add-enfants/selected-enfants/selected-enfants.component";
import {SelectedMatieresComponent} from "./content-components/business/personne/add-personne/include/add-matieres/selected-matieres/selected-matieres.component";
import { ShowPersonneComponent } from './content-components/business/personne/show-personne/show-personne.component';
import { AddNiveauComponent } from './content-components/business/niveau/add-niveau/add-niveau.component';
import { ShowNiveauComponent } from './content-components/business/niveau/show-niveau/show-niveau.component';
import { EditNiveauComponent } from './content-components/business/niveau/edit-niveau/edit-niveau.component';
import { AllEleveComponent } from './content-components/business/personne/all-eleve/all-eleve.component';
import { AllParentComponent } from './content-components/business/personne/all-parent/all-parent.component';
import { AllProfesseurComponent } from './content-components/business/personne/all-professeur/all-professeur.component';

@NgModule({
  declarations: [
    AppComponent,
    MainNavComponent,
    AllTypeSanctionComponent,
    AddTypeSanctionComponent,
    EditTypeSanctionComponent,
    AllSanctionComponent,
    AddSanctionComponent,
    EditSanctionComponent,
    AddPersonneComponent,
    LoginComponent,
    RegisterComponent,
    AddEnfantsDialogComponent,
    AddMatieresDialogComponent,
    SelectedEnfantsComponent,
    SelectedMatieresComponent,
    ShowPersonneComponent,
    AddNiveauComponent,
    ShowNiveauComponent,
    EditNiveauComponent,
    AllEleveComponent,
    AllParentComponent,
    AllProfesseurComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    RouterModule,
    LayoutModule,
    MatToolbarModule,
    MatButtonModule,
    MatSidenavModule,
    MatIconModule,
    MatListModule,
    MatSlideToggleModule,
    MatExpansionModule,
    MatCardModule,
    MatTableModule,
    MatSortModule,
    MatGridListModule,
    MatFormFieldModule,
    MatPaginatorModule,
    MatDialogModule,
    MatInputModule,
    MatSnackBarModule,
    MatSelectModule,
    MatMenuModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatCheckboxModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule
  ],
  providers: [AuthenticationService, LoginRequest, SigneUpRequest, Role,User],
  bootstrap: [AppComponent],
  entryComponents: [ AddTypeSanctionComponent, AddNiveauComponent, EditNiveauComponent,
    EditTypeSanctionComponent,
    AddSanctionComponent,
    EditSanctionComponent,
    AddEnfantsDialogComponent,
    AddMatieresDialogComponent,
  ]
})
export class AppModule { }
