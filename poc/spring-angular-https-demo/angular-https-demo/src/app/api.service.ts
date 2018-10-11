import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  //  NOTE: we cant redirect both http and https call on same port , thats why we are using port 8443 for the https and port 8080 for the simple http calls and redirecting the http calls to port https.
  // url = 'https://localhost:8443/api/v1/home';
  url = 'http://localhost:8080/api/v1/home';
  constructor(private http: HttpClient) {}

  // public callBackEnd() {
  //   return this.http.get(this.url);
  // }
  public callBackEnd(): Observable<any[]> {
    return this.http
      .get(this.url, { responseType: 'text' })
      .pipe(map((res: Response) => res));
  }

  // addClient(client: Client) {
  //   this.clients.push(client);
  //   const body = JSON.stringify(client);
  //   const headers = new Headers({ 'Content-Type': 'application/json' });
  //   return this.http.post('http://localhost:3000/client', body, { headers: headers })
  //     .map((response: HttpResponseBase) => response)
  //     .catch((error: HttpErrorResponse) => Observable.throw(error));
  // }
}
