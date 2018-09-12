import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpHandler} from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/observable/throw';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/do';
import 'rxjs/add/operator/map';


@Injectable()
export class DetailsService {
  private _resMyReviewsURL = '';
  private _resReviewsURL = '';
  private _resDetailsURL = '';
  private baseUrl = 'http://localhost:8080/api';
  constructor(private _http: HttpClient) { }

      // This functions gets details about a resturant
  getDetails(id): Observable<any> {
    this._resDetailsURL = this.baseUrl + '/restaurant/' + id;
    return this._http.get<any>(this._resDetailsURL)
      .do(data => (data));
  }
    // This functions gets reviews about a  resturant
  getReviews(id): Observable<any> {
    this._resReviewsURL = this.baseUrl + '/reviews/' + id;
    return this._http.get<any>(this._resReviewsURL)
      .do(data => (data));
  }
      // This functions gets  reviews from API
  getMyReviews(id): Observable<any> {
    this._resMyReviewsURL = this.baseUrl + '/reviews/' + id + '/myriew';
    return this._http.get<any>(this._resMyReviewsURL)
      .do(data => (data));
  }
    // This functions updates the review in blackend
  editmyReview(review, id): Observable<any> {
    this._resMyReviewsURL = this.baseUrl + '/reviews/' + id + '/myriew?myRiew=' + review;
    return this._http.post(this._resMyReviewsURL, '', '').do(data => (data));
  }

}
