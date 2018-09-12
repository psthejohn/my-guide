import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/observable/throw';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/do';
import 'rxjs/add/operator/map';

@Injectable()
export class HomeService {
    private _geoCodeUrl = '';
    private _latitude;
    private _longitude;
    private _favCodeUrl = '';
    private baseUrl = 'http://localhost:8080/api';
    private addFavUrl;
    constructor(private _http: HttpClient) {
        this.getGoelocation();
    }

    getGoelocation(): void {
        navigator.geolocation.getCurrentPosition((position) => {
            this._latitude = position.coords.latitude;
            this._longitude = position.coords.longitude;

        });

    }
 // This functions gets all Restaurants nearby
    getRestaurants(): Observable<any> {
        this.getGoelocation();
        // console.log('before call outside timeout' + this._latitude);
        this._geoCodeUrl = `${this.baseUrl}/restaurants/geocode?lat=${this._latitude}&lon=${this._longitude}&sort=rating`;
        return this._http.get<any>(this._geoCodeUrl)
            .do(data => (data));

    }
     // This functions adds a Restaurant to favourites
    addFavourites(id): Observable<any> {
        this.addFavUrl = this.baseUrl + '/favourites/' + id;
        return this._http.post(this.addFavUrl, '', '').do(data => (data));

    }
 // This functions removes Restaurants from favourites
    deleteFavourites(id): Observable<any> {
        this._favCodeUrl = this.baseUrl + '/favourites/' + id;
        return this._http.delete(this._favCodeUrl);
    }

}
