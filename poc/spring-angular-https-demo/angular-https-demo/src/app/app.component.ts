import { Component } from '@angular/core';
import { ApiService } from './api.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'angular-https-demo';
  data;
  constructor(private service: ApiService) {}

  public callBackend() {
    this.service.callBackEnd().subscribe(res => (this.data = res));
  }
}
