import { TestBed, inject } from '@angular/core/testing';
import { HttpHandler, HttpClient, HttpErrorResponse } from '@angular/common/http';
import { SearchService } from './search.service';

describe('SearchService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [HttpHandler, HttpClient, SearchService]
    });
  });

   it('should be created', inject([SearchService], (service: SearchService) => {
    expect(service).toBeTruthy();
  }));
});
