import { Component, OnInit } from '@angular/core';
import { DataService } from './data.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'angular-http-server-demo';
  student;
  constructor(private service: DataService) {}

  ngOnInit() {
    this.getHome();
    this.getData();
  }

  getHome() {
    this.service.getHome().subscribe(data => {
      console.log('incoming data is ', data);
    });
  }

  getData() {
    this.service.getData().subscribe(data => {
      console.log('incoming data is ', data);
    });
  }
}
