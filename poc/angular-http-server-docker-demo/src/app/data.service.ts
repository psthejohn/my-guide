import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DataService {
  url1 = 'http://localhost:8090/api/v1/hello';
  url2 = 'https://localhost:8090/api/v1/welcome';
  constructor(private http: HttpClient) {}

  getHello() {
    return this.http.get(this.url1);
  }

  getWelcome() {
    return this.http.get(this.url2);
  }
}
