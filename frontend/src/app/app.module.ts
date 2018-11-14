import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';

import {AppComponent} from './app.component';

import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {
  AccordionModule,
  ButtonModule,
  CardModule,
  ConfirmationService,
  ConfirmDialogModule,
  DialogModule,
  DropdownModule,
  InputTextareaModule,
  InputTextModule,
  KeyFilterModule,
  OrderListModule,
  PanelModule,
  SliderModule
} from 'primeng/primeng';

import {AngularFontAwesomeModule} from 'angular-font-awesome';

import {HttpClientModule} from '@angular/common/http';
import {HttpRequestService} from './services/http.service';
import {MedicinesComponent} from './medicines/medicines.component';
import {TableModule} from 'primeng/table';
import {NewtreatmentComponent} from './newtreatment/newtreatment.component';
import {TreatmentsComponent} from './treatments/treatments.component';
import {RouterModule, Routes} from '@angular/router';
import {StudiesComponent} from './studies/studies.component';
import {DomainrulesComponent} from './domainrules/domainrules.component';
import {MenuModule} from 'primeng/menu';
import {MenubarModule} from 'primeng/menubar';
import {AlertsComponent} from './alerts/alerts.component';
import {ListboxModule} from 'primeng/listbox';
import {NewmedicineComponent} from './newmedicine/newmedicine.component';
import {DomainRulesListComponent} from './domainrules_list/domainrules_list.component';
import {GrowlModule} from 'primeng/growl';
import {MessageService} from 'primeng/components/common/messageservice';

const appRoutes: Routes = [
  {path: 'treatments', component: TreatmentsComponent},
  {path: 'medicines', component: NewmedicineComponent},
  {path: 'studies', component: StudiesComponent},
  {path: 'domainRulesList', component: DomainRulesListComponent},
  {path: 'domainRules', component: DomainrulesComponent}
];


@NgModule({
  declarations: [
    AppComponent,
    TreatmentsComponent,
    AlertsComponent,
    NewtreatmentComponent,
    MedicinesComponent,
    NewmedicineComponent,
    StudiesComponent,
    DomainRulesListComponent,
    DomainrulesComponent
  ],
  imports: [
    RouterModule.forRoot(appRoutes, {enableTracing: true}),
    BrowserModule,
    TableModule,
    HttpClientModule,
    FormsModule,
    NgbModule.forRoot(),
    NgbModule,
    ButtonModule,
    DialogModule,
    InputTextModule,
    DropdownModule,
    SliderModule,
    PanelModule,
    CardModule,
    OrderListModule,
    MenuModule,
    MenubarModule,
    ConfirmDialogModule,
    InputTextareaModule,
    ListboxModule,
    AccordionModule,
    KeyFilterModule,
    GrowlModule,
    BrowserAnimationsModule,
    AngularFontAwesomeModule
  ],
  providers: [
    HttpRequestService,
    MessageService,
    ConfirmationService
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
