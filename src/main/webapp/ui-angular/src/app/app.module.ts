import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { LayoutModule } from '@angular/cdk/layout';
import {
  MatToolbarModule, MatButtonModule, MatSidenavModule, MatIconModule, MatListModule,
  MatSlideToggleModule, MatAccordion, MatExpansionPanel, MatExpansionModule, MatExpansionPanelHeader
} from '@angular/material';
import { MainNavComponent } from './ui-components/main-nav/main-nav.component';
import { AppRoutingModule } from './app-routing.module';
import { AllTypeSanctionComponent } from './content-components/typesanction/all-type-sanction/all-type-sanction.component';
import {RouterModule} from "@angular/router";

@NgModule({
  declarations: [
    AppComponent,
    MainNavComponent,
    AllTypeSanctionComponent
  ],
  imports: [
    BrowserModule,
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
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
