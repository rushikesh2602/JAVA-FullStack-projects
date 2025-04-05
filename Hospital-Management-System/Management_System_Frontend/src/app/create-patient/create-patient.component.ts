import { Component } from '@angular/core';
import { Patient } from '../patient';
import { PatientService } from '../patient.service';
import { ActivatedRoute, Router } from '@angular/router';


@Component({
  selector: 'app-create-patient',
  templateUrl: './create-patient.component.html',
  styleUrl: './create-patient.component.css'
})
export class CreatePatientComponent {

  id:number = 0;
  patient: Patient = new Patient();

  constructor(private patientservice : PatientService, private router: Router, private route : ActivatedRoute) {
  }

  ngOnInit(): void {
   this.id= this.route.snapshot.params['id'];

  }

  savePatient() {
    this.patientservice.createPatient(this.patient).subscribe(data => {
      console.log(data);
      this.goToPatientList();
    })
  }

  onSubmit() {
    this.savePatient();
  }

  goToPatientList(){
    this.router.navigate(['/docdash'])
  }

}
