import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/observable/throw';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/do';
import 'rxjs/add/operator/map';

@Injectable()
export class FavouritesService {
  private _favCodeUrl = '';
  private baseUrl = 'http://localhost:8080/api';
  constructor(private _http: HttpClient) { }

    // This functions gets all resturants from favourites
  getFavourites(): Observable<any> {
    this._favCodeUrl = this.baseUrl + '/favourites';
    return this._http.get<any>(this._favCodeUrl)
      .do(data => (data));
  }

    // This functions deletes a resturants from favourites
  deleteFavourites(id): Observable<any> {
    this._favCodeUrl = this.baseUrl + '/favourites/' + id;
    return this._http.delete(this._favCodeUrl);
  }


}

