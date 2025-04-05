import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, GuardResult, MaybeAsync, Router, RouterStateSnapshot } from '@angular/router';
import { DocauthService } from './docauth.service';

@Injectable({
  providedIn: 'root'
})
export class DocauthguardService implements CanActivate {

  constructor(private docauthService: DocauthService, private router: Router) { }


  canActivate() {
      if(this.docauthService.isUserLoggedIn()){
        return true;
      }
      else{

        this.router.navigate(['doclogin']);
        return false;
      }
  }
}
