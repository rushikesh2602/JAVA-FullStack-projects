import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Appointment } from './appointment';

@Injectable({
  providedIn: 'root'
})
export class AppointmentService {

   constructor(private httpClient: HttpClient) { }

   private baseurl = "http://localhost:8080/api/v2/appointments"

    //  private baseurls = "http://localhost:8080/api/v2"

   getAppointment():Observable<Appointment[]> {
     return this.httpClient.get<Appointment[]>(`${this.baseurl}`);
   }

   createAppointment(appointment:Appointment):Observable<Appointment> {
    return this.httpClient.post<Appointment>(`${this.baseurl}`,appointment);
   }

   deleteAppointment(id: number):Observable<object>{
    return this.httpClient.delete(`${this.baseurl}/${id}`);
   }

}
