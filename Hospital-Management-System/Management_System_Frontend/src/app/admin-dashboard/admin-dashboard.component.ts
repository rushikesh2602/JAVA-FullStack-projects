import { Component } from '@angular/core';
import { PatientService } from '../patient.service';
import { Patient } from '../patient';
import { AdminauthService } from '../adminauth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrl: './admin-dashboard.component.css'
})
export class AdminDashboardComponent {

  patients: Patient[] = [];

  constructor(private patientService: PatientService, private adminAuthService: AdminauthService, private router : Router) { }

  ngOnInit(): void {
 this.getPatients();

  }

  getPatients(){
    this.patientService.getPatientList().subscribe(data=> {
this.patients= data;
console.log(data)
    })

  }

delete(id:number){
this.patientService.delete(id).subscribe(data =>{
  console.log(data);
  this.getPatients();
})
}


logout(){
  this.adminAuthService.logout();
  this.router.navigate(['home'])
}


}
