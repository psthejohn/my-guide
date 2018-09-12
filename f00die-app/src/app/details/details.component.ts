import { Component, OnInit, Input } from '@angular/core';
import { DetailsService } from './details.service';
import { Router, ActivatedRoute } from '@angular/router';
@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css']
})
export class DetailsComponent implements OnInit {
  constructor(private _DetailsService: DetailsService, private router: Router, private route: ActivatedRoute) {
  }

  title = 'Foodie App';
  user_reviews: any[];
  my_reviews: any;
  restaurant: any;
  errorMessage: string;
  id: string;

  ngOnInit(): void {
    this.getResId();
    this.getDetails();
    this.getReviews();
    this.getMyReviews();
  }
 getDetails(): void {
    this._DetailsService.getDetails(this.id)
      .subscribe(data => {
        this.restaurant = data;
      
      },
      error => this.errorMessage = <any>error);
  }

  getReviews(): void {
    this._DetailsService.getReviews(this.id)
      .subscribe(Reviews => {
        this.user_reviews = Reviews;
       
      },
      error => this.errorMessage = <any>error);
  }

  getResId(): void {
    this.route.params.subscribe(params => {
      this.id = params['id'];
      // console.log(params['id']);
    });
  }
  // This functions gets  review from blackend
  getMyReviews(): void {
    this._DetailsService.getMyReviews(this.id)
      .subscribe(Reviews => {
        this.my_reviews = Reviews;
       
      },
      error => this.errorMessage = <any>error);
  }

  // This functions updates the review in blackend
  editmyReview(review): void {
    this._DetailsService.editmyReview(review, this.id)
      .subscribe(my_reviews => {
        this.my_reviews = my_reviews;
      },
      error => this.errorMessage = <any>error);
  }
}
