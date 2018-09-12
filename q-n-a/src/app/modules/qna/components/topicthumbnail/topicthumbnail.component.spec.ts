import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TopicThumbnailComponent } from './topicthumbnail.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { MatFormFieldModule, MatInputModule, MatButtonModule, MatCardModule, MatSnackBarModule } from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { RouterTestingModule } from '@angular/router/testing';
import { QnaService } from '../../qna.service';
import { Router } from '@angular/router';
import { of } from 'rxjs/observable/of';
import { AuthenticationService } from '../../../authentication/authentication.service';
import { Location } from '@angular/common';
import { Observable } from 'rxjs';
import { Topic } from '../../topic';
import { By } from '@angular/platform-browser';

const testConfig={
  userdata:{
    firstName: 'test',
    lastName: 'testlast',
    userId: 'testuser@gmail.com',
    password: 'testpass'
  }
}


describe('ThumbnailComponent', () => {
  let component: TopicThumbnailComponent;
  let fixture: ComponentFixture<TopicThumbnailComponent>;
  let routes: Router;
  let location: Location;

  class AuthServiceStub{
    currentUser: any;
    constructor(){
      
    }
    login(credentials){
      if(credentials.userId == testConfig.userdata.userId){
        console.log('data111',this.currentUser);
        return of(credentials.userId);
      }

      return of(false);
    }
  }
  class QnaServiceStub{
    
    topics : Array<Topic>;
    constructor(){
      
      this.topics = [];
    }
    getTopics(): Observable<Array<Topic>>{
     
     
      return of(this.topics);
    }
  }

  class dummy{

  }

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TopicThumbnailComponent ],
      imports:[FormsModule,HttpClientModule,MatFormFieldModule,MatInputModule,MatCardModule,MatSnackBarModule,
        MatButtonModule,BrowserAnimationsModule,RouterTestingModule.withRoutes(
          [{path: '',component: dummy}]
        )],
        providers: [{provide:QnaService,useClass:QnaServiceStub},{provide:AuthenticationService,useClass:AuthServiceStub}]
    
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TopicThumbnailComponent);
    component = fixture.componentInstance;
    routes = TestBed.get(Router);
    location = TestBed.get(Location);
    fixture.detectChanges();
    fixture.debugElement.injector.get(QnaService);
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });


  it('should contain input boxes for add comment and submit button',()=>{
    let topicNew= fixture.debugElement.query(By.css('.enter-topic'));
    let addDescriptionNew= fixture.debugElement.query(By.css('.add-description'));
    let sumbitButton = fixture.debugElement.query(By.css('.submit-button'));
    
    let addDescriptionInput = addDescriptionNew.nativeElement;
    let topicInput = topicNew.nativeElement;
    let sumbitButtonInput = sumbitButton.nativeElement;
    
    expect(addDescriptionInput).toBeTruthy();
    expect(topicInput).toBeTruthy();
    expect(sumbitButtonInput).toBeTruthy();
    
  });

});
