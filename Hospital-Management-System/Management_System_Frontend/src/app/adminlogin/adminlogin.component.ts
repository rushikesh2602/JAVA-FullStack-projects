import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AdminauthService } from '../adminauth.service';

@Component({
  selector: 'app-adminlogin',
  templateUrl: './adminlogin.component.html',
  styleUrl: './adminlogin.component.css'
})
export class AdminloginComponent {


  username:string=''
  password:string=''
  inValidLogin=false;

  constructor(private adminAuthService:AdminauthService,private router:Router){}

  checkLogin(){

       if(this.adminAuthService.authenticate(this.username,this.password)){

           this.router.navigate(['admin'])
           this.inValidLogin=false;

       }
       else{

            this.inValidLogin=true;
            alert("Wrong credentials");
            this.router.navigate(['home'])
       }
  }


}
