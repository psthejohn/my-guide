import { TestBed, inject } from '@angular/core/testing';
import { HttpClient, HttpErrorResponse, HttpHandler } from '@angular/common/http';
import { DetailsService } from './details.service';

describe('DetailsService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [HttpHandler, HttpClient, DetailsService]
    });
  });

  it('should be created', inject([DetailsService], (service: DetailsService) => {
    expect(service).toBeTruthy();
  }));
});
