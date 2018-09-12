import { Component, OnInit, Input } from '@angular/core';
import { FavouritesService } from './favourites.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-favourites',
  templateUrl: './favourites.component.html',
  styleUrls: ['./favourites.component.css']
})
export class FavouritesComponent implements OnInit {

  constructor(private _FavouritesService: FavouritesService, private router: Router) {

  }

  title = 'Foodie App';
  favourites: any[];
  errorMessage: string;
    // This functions removes a resturants from favourites
  removeFavourites(value): void {
    console.log(`id recieved :${value}:`);
    this._FavouritesService.deleteFavourites(value).subscribe(
      () => {
        
        this.refreshRes();
      });
  }
  ngOnInit(): void {
    this.refreshRes();
  }
  refreshRes(): void {

    this._FavouritesService.getFavourites()
      .subscribe(Favourites => {
        this.favourites = Favourites;


        
      },
      error => this.errorMessage = <any>error);
  }
    // This functions gets details about a resturant
  goToRestDetails(id): void {

    this.router.navigate(['/details', id]);
  }

}
