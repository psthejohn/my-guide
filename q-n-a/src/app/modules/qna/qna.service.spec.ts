import { TestBed, inject } from '@angular/core/testing';

import { QnaService } from './qna.service';
import { HttpClientModule } from '@angular/common/http';
import { HttpClientTestingModule } from '@angular/common/http/testing';

describe('QnaService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientModule,HttpClientTestingModule],
      providers: [QnaService]
    });
  });

  it('should be created', inject([QnaService], (service: QnaService) => {
    expect(service).toBeTruthy();
  }));
});
