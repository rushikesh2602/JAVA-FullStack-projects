import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AdminauthService {

  constructor() { }

  authenticate(username2:string , password: string) {

    if(username2== 'admin' && password== '123456'){
      sessionStorage.setItem('username2', username2);
      return true
    }
    else{
      return false;
    }
  }

  isUserLoggedIn() {
  let user =  sessionStorage.getItem('username2')

  return !(user == null)
  }

  logout(){
    sessionStorage.removeItem('username2');
  }

}
