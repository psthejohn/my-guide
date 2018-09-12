import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/observable/throw';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/do';
import 'rxjs/add/operator/map';


@Injectable()
export class SearchService {
  private _favCodeUrl = '';
  private addFavUrl = '';
  private baseUrl = 'http://localhost:8080/api';

  constructor(private _http: HttpClient) { }
  // This function get all resturants for a city and cuisine
  searchRestaurants(location, cuisine): Observable<any> {
    this._favCodeUrl = this.baseUrl + '/restaurants/city/cuisine?city=' + location + '&cuisine=' + cuisine;
    return this._http.get<any>(this._favCodeUrl)
      .do(data => (data));
  }
  // This function adds a resturants to Favourites list
  addFavourites(id): Observable<any> {
    this.addFavUrl = this.baseUrl + '/favourites/' + id;
    return this._http.post(this.addFavUrl, '', '').do(data => (data));

  }
 // This function removes a resturants from Favourites list
  deleteFavourites(id): Observable<any> {
    this._favCodeUrl = this.baseUrl + '/favourites/' + id;
    return this._http.delete(this._favCodeUrl);
  }
}
