import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {LayoutModule} from '@angular/cdk/layout';
import {
  MatButtonModule,
  MatCardModule,
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
import { EditTypeSanctionComponent } from './content-components/typesanction/edit-type-sanction/edit-type-sanction.component';
import { LoginComponent } from './login/login.component';
import { LoginRequest } from '../model/admin/loginRequest';
import {AuthenticationService} from "./_services/authentication.service";

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
    LoginComponent
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
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule
  ],
  providers: [AuthenticationService, LoginRequest],
  bootstrap: [AppComponent],
  entryComponents: [ AddTypeSanctionComponent,
    EditTypeSanctionComponent,
    AddSanctionComponent,
    EditSanctionComponent
  ]
})
export class AppModule { }
