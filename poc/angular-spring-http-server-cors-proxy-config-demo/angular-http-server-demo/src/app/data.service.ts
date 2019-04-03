import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DataService {
  url = 'http://localhost:8080/api/v1';
  constructor(private http: HttpClient) {}

  getHome() {
    return this.http.get(this.url + '/home', { responseType: 'text' });
  }

  getData() {
    return this.http.get(this.url + '/data');
  }
}
