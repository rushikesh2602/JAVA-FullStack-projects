import { Component } from '@angular/core';
import { MedicineService } from '../medicine.service';
import { Medicine } from '../medicine';
import { Router } from '@angular/router';


@Component({
  selector: 'app-medicine-list',
  templateUrl: './medicine-list.component.html',
  styleUrl: './medicine-list.component.css'
})
export class MedicineListComponent {

  medicines : Medicine[] = [];

  constructor(private mediceneservice : MedicineService, private router :Router) {

  }

  ngOnInit(): void {
   this.getMedicine();

  }

  getMedicine() {
    this.mediceneservice.getMedicines().subscribe(data => {
      this.medicines = data;
    })

  }

  Update(id:number) {

    this.router.navigate(['update-medicine',id])
  }


  Delete(id:number) {
this.mediceneservice.delete(id).subscribe(data=>{
console.log(data);
this.getMedicine();
})
  }

}
