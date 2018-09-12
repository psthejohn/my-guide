import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { SearchService } from './search.service';
import { SearchComponent } from './search.component';
import { HttpHandler, HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Router } from '@angular/router';

describe('SearchComponent', () => {
  let component: SearchComponent;
  let fixture: ComponentFixture<SearchComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [SearchComponent],
      providers: [Router, HttpHandler, HttpClient, SearchService],
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  /* it('Component should be created', () => {
   expect(component).toBeTruthy();
}); */
});
