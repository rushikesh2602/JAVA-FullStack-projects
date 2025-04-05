import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { AppointmentComponent } from './appointment/appointment.component';
import { CreateAppointmentComponent } from './create-appointment/create-appointment.component';
import { HomeComponent } from './home/home.component';
import { DocDashboardComponent } from './doc-dashboard/doc-dashboard.component';
import { CreatePatientComponent } from './create-patient/create-patient.component';
import { MedicineListComponent } from './medicine-list/medicine-list.component';
import { CreateMedicineComponent } from './create-medicine/create-medicine.component';
import { UpdatePatientComponent } from './update-patient/update-patient.component';
import { ViewPatientComponent } from './view-patient/view-patient.component';
import { UpdateMedicineComponent } from './update-medicine/update-medicine.component';
import { DocloginComponent } from './doclogin/doclogin.component';
import { AdminloginComponent } from './adminlogin/adminlogin.component';
import { AdminauthguardService } from './adminauthguard.service';
import { DocauthguardService } from './docauthguard.service';

const routes: Routes = [
  {path:'admin' , component: AdminDashboardComponent, canActivate:[AdminauthguardService]},
  {path:'appintmentlist' , component: AppointmentComponent, canActivate : [AdminauthguardService]},
  {path: 'create-appointment', component: CreateAppointmentComponent,  canActivate : [AdminauthguardService]},
  {path: 'home', component: HomeComponent},
  {path: '', redirectTo: 'home',pathMatch:'full'},
  {path: 'docdash', component: DocDashboardComponent, canActivate: [DocauthguardService]},
  {path: 'createpatient', component: CreatePatientComponent, canActivate: [DocauthguardService]},
  {path: 'view-medicine', component: MedicineListComponent, canActivate: [DocauthguardService]},
  {path: 'create-medicine', component: CreateMedicineComponent, canActivate: [DocauthguardService]},
  {path: 'update-patient/:id', component: UpdatePatientComponent, canActivate: [DocauthguardService]},
  {path: 'view-patient/:id', component: ViewPatientComponent, canActivate: [DocauthguardService]},
  {path: 'update-medicine/:id', component: UpdateMedicineComponent, canActivate: [DocauthguardService]},
  {path: 'doclogin', component: DocloginComponent},
  {path: 'adlogin', component: AdminloginComponent},


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
