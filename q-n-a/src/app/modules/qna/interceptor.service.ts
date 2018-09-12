import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent, HttpErrorResponse } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { AuthenticationService } from "../authentication/authentication.service";
import { Observable } from "rxjs";
import 'rxjs/add/operator/do';



@Injectable()
export class TokenInterceptor implements HttpInterceptor {

    constructor(private auth: AuthenticationService){

    }

    intercept(request: HttpRequest<any> , next: HttpHandler): Observable<HttpEvent<any>> {
        console.log('In Intercept');
        request = request.clone({
            setHeaders:{
                Authorization: `Bearer ${this.auth.getToken()}`
            }
        });
        return next.handle(request).do((event: HttpEvent<any>)=> {}, (err: any) => {
            if(err instanceof HttpErrorResponse){
                this.auth.handleError(err.error);
            }
        });
    }
}