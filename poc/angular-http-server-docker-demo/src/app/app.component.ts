import { Component, OnInit } from '@angular/core';
import { DataService } from './data.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  hello;
  welcome;
  title = 'angular-http-server-demo';

  constructor(private service: DataService) {}
  ngOnInit() {
    this.getHello();
    this.getWelcome();
  }

  getHello() {
    this.service.getHello().subscribe(data => {
      console.log('incoming hello data is ', data);
      this.hello = data;
    });
  }

  getWelcome() {
    this.service.getWelcome().subscribe(data => {
      console.log('incoming welcome data is ', data);
      this.welcome = data;
    });
  }
}
