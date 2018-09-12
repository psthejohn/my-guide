import { CanActivate, Router } from "@angular/router";
import { AuthenticationService } from "./modules/authentication/authentication.service";
import { Injectable } from "@angular/core";


@Injectable()
export class AuthGuardService implements CanActivate{
    constructor(private route: Router,private authService: AuthenticationService){

    }

    canActivate(){
        if(!this.authService.isTokenExpired()){
            console.log('in can Activate');
            return true;
        }
        this.route.navigate(['/login']);
        return false;
    }
}