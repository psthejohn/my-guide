import { Component, OnInit } from '@angular/core';
import { SearchService } from './search.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  constructor(private _SearchService: SearchService, private router: Router) { }
  title = 'Foodie App';
  restaurantsCuisines: any[];
  errorMessage: string;
  restaurantsCuisinesError: string;
  ngOnInit() {
  }
  // This function get all resturants for a city and cuisine
  searchRestaurants(location, cuisine): void {

    this._SearchService.searchRestaurants(location, cuisine)
      .subscribe(RestaurantsCuisines => {
        this.restaurantsCuisines = RestaurantsCuisines.restaurants;
        this.restaurantsCuisinesError = RestaurantsCuisines.error;
        // console.log('restaurantsCuisinesError :' + this.restaurantsCuisinesError);
      },
      error => this.errorMessage = <any>error);
  }

  // This function adds a resturants to Favourites list
  addFavourites(value, location, cuisine): void {
    
    this._SearchService.addFavourites(value).subscribe(() => {
      
      this.searchRestaurants(location, cuisine);
    });
  }

  // This function removes a resturants from Favourites list
  removeFavourites(value, location, cuisine): void {
   
    this._SearchService.deleteFavourites(value).subscribe(() => {
      
      this.searchRestaurants(location, cuisine);
    });
  }

  goToRestDetails(id): void {
   
    this.router.navigate(['/details', id]);
  }
}
