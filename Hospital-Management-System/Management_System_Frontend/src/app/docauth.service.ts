import { Injectable } from '@angular/core';
import { retry } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DocauthService {

  constructor() { }


  authenticate(username:string,password:string) {
    if(username=='rushi' && password=='123456'){
      sessionStorage.setItem('username', username)
      return true;
    }
    else{
      return false;
    }
  }

  isUserLoggedIn() {
  let user=   sessionStorage.getItem('username');
  return !(user==null)
  }


  logout(){
    sessionStorage.removeItem('username');
  }


}
