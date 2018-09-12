import { Component, OnInit } from '@angular/core';
import { HomeService } from './home.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  constructor(private _HomeService: HomeService, private router: Router) {

  }

  title = 'Foodie App';
  restaurant: any[];
  errorMessage: string;
  ngOnInit(): void {
    this.refreshRes(500);
  }
  // This functions adds a resturants to favourites
  addFavourites(value): void {
    // console.log(`id recieved :${value}:`);
    this._HomeService.addFavourites(value).subscribe(
      () => {
       // console.log('deleted res id :' + value);
        this.refreshRes(0);
      });
  }
  refreshRes(value): void {
    setTimeout(() => {
      this._HomeService.getRestaurants()
        .subscribe(Restaurant => {
          this.restaurant = Restaurant.nearby_restaurants;
          
        },
        error => this.errorMessage = <any>error);
    }, value);
  }
  // This functions removes a resturants from favourites
  removeFavourites(value): void {
    
    this._HomeService.deleteFavourites(value).subscribe(
      () => {
       
        this.refreshRes(0);
      });
  }

    // This functions gets details about Restaurant
  goToRestDetails(id): void {
    
    this.router.navigate(['/details', id]);
  }

}
