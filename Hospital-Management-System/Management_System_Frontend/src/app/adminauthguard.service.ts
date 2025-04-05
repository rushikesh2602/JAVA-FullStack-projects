import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, GuardResult, MaybeAsync, Router, RouterStateSnapshot } from '@angular/router';
import { AdminauthService } from './adminauth.service';

@Injectable({
  providedIn: 'root'
})
export class AdminauthguardService implements CanActivate {

  constructor( private adminAuthSerive : AdminauthService, private router : Router) { }

  canActivate() {

    if(this.adminAuthSerive.isUserLoggedIn()){
      return true;
    }
    else{
      this.router.navigate(['adlogin'])
      return false;
    }
  }
}
