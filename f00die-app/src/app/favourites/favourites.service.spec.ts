import { TestBed, inject } from '@angular/core/testing';
import { HttpHandler, HttpClient, HttpErrorResponse } from '@angular/common/http';
import { FavouritesService } from './favourites.service';

describe('FavouritesService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [HttpHandler, HttpClient, FavouritesService]
    });
  });

  it('should be created', inject([FavouritesService], (service: FavouritesService) => {
    expect(service).toBeTruthy();
  }));
});
