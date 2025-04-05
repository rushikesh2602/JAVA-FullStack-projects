import { Component } from '@angular/core';
import { Patient } from '../patient';
import { ActivatedRoute, Router } from '@angular/router';
import { PatientService } from '../patient.service';

@Component({
  selector: 'app-update-patient',
  templateUrl: './update-patient.component.html',
  styleUrl: './update-patient.component.css'
})
export class UpdatePatientComponent {

  id:number = 0;

  patient: Patient = new Patient();

  constructor(private route : ActivatedRoute, private patientService : PatientService ,private router : Router ) {

  }

  ngOnInit(): void {

    this.id = this.route.snapshot.params['id'];

    this.patientService.getPatientById(this.id).subscribe(data => {
      this.patient = data;
    })

  }


  onSubmit() {
    this.patientService.updatePatient(this.id ,this.patient).subscribe(data => {
      console.log(data);
      this.goTodash ()
    })
  }

  goTodash () {
    this.router.navigate(['docdash'])
  }


}
