import { TestBed, inject } from '@angular/core/testing';
import { HttpClient, HttpErrorResponse, HttpHandler } from '@angular/common/http';
import { HomeService } from './home.service';

describe('HomeService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [HttpHandler, HttpClient, HomeService]
    });
  });

  it('should be created', inject([HomeService], (service: HomeService) => {
    expect(service).toBeTruthy();
  }));
});
