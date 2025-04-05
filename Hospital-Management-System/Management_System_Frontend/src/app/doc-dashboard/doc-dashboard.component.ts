import { Component } from '@angular/core';
import { Patient } from '../patient';
import { PatientService } from '../patient.service';
import { Router } from '@angular/router';
import { DocauthService } from '../docauth.service';

@Component({
  selector: 'app-doc-dashboard',
  templateUrl: './doc-dashboard.component.html',
  styleUrl: './doc-dashboard.component.css'
})
export class DocDashboardComponent {

  ngOnInit(): void {
    this.getPatients()

  }

  constructor(private patientservice: PatientService, private router : Router,private docauth : DocauthService){

  }

  patients: Patient[] = [];

 getPatients() {
  this.patientservice.getPatientList().subscribe(data=>{
    this.patients= data;
  })
 }

 update(id: number) {
this.router.navigate(['update-patient', id])
 }

 delete(id:number) {
  this.patientservice.delete(id).subscribe(data=>{
    console.log(data);
    this.getPatients();
  })
 }

 view(id:number) {

  this.router.navigate(['view-patient',id])
 }

 logout(){
  this.docauth.logout();
  this.router.navigate(['home'])
 }

}
