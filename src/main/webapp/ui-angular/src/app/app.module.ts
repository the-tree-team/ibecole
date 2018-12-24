import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {LayoutModule} from '@angular/cdk/layout';
import {
  MatButtonModule,
  MatCardModule, MatDialogModule,
  MatExpansionModule,
  MatFormFieldModule,
  MatGridListModule,
  MatIconModule,
  MatInputModule,
  MatListModule,
  MatPaginatorModule,
  MatSidenavModule,
  MatSlideToggleModule, MatSnackBarModule,
  MatSortModule,
  MatTableModule,
  MatToolbarModule
} from '@angular/material';
import {MainNavComponent} from './ui-components/main-nav/main-nav.component';
import {AppRoutingModule} from './app-routing.module';
import {AllTypeSanctionComponent} from './content-components/typesanction/all-type-sanction/all-type-sanction.component';
import {RouterModule} from "@angular/router";
import {HttpClientModule} from "@angular/common/http";
import {AddTypeSanctionComponent} from './content-components/typesanction/add-type-sanction/add-type-sanction.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { EditTypeSanctionComponent } from './content-components/typesanction/edit-type-sanction/edit-type-sanction.component';
import { AllSanctionComponent } from './content-components/sanction/all-sanction/all-sanction.component';

@NgModule({
  declarations: [
    AppComponent,
    MainNavComponent,
    AllTypeSanctionComponent,
    AddTypeSanctionComponent,
    EditTypeSanctionComponent,
    AllSanctionComponent
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
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent],
  entryComponents: [ AddTypeSanctionComponent,
    EditTypeSanctionComponent
  ]
})
export class AppModule { }
