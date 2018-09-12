import { async, ComponentFixture, TestBed, fakeAsync } from '@angular/core/testing';

import { Location } from '@angular/common';
import { LoginComponent } from './login.component';
import { AuthenticationService } from '../authentication.service';
import { Router } from '@angular/router';
import { RouterTestingModule } from '@angular/router/testing';
import { By } from '@angular/platform-browser';
import { Observable } from 'rxjs';
//import {  } from 'rxjs/add/observable/of';
//import 'rxjs/add/observable/of';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { MatFormFieldModule, MatInputModule, MatButtonModule } from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { TestRequest } from '@angular/common/http/testing';
import { of } from 'rxjs/observable/of';


const testConfig={
  userdata:{
    firstName: 'test',
    lastName: 'testlast',
    userId: 'testuser',
    password: 'testpass'
  }
}



describe('LoginComponent', () => {
  let component: LoginComponent;
  let fixture: ComponentFixture<LoginComponent>;
  let authService: AuthenticationService;
  let spyUser: any;
  let routes: Router;
  let location: Location;

  class AuthServiceStub{
    currentUser:any;
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
  class dummy{

  }


  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LoginComponent ],
      imports: [FormsModule,HttpClientModule,MatFormFieldModule,MatInputModule,
      MatButtonModule,BrowserAnimationsModule,RouterTestingModule.withRoutes(
        [{path: '',component: dummy}]
      )],
      providers: [{provide:AuthenticationService,useClass:AuthServiceStub}]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LoginComponent);
    routes = TestBed.get(Router);
    location = TestBed.get(Location);
    component = fixture.componentInstance;
    fixture.detectChanges();
    fixture.debugElement.injector.get(AuthenticationService);
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should contain two input  box for userId and password',()=>{
    let userId= fixture.debugElement.query(By.css('.inputID'));
    let password = fixture.debugElement.query(By.css('.inputPass'));
    let registerButton = fixture.debugElement.query(By.css('.register-button'));
    let userButton = fixture.debugElement.query(By.css('.login-user'));

    let userIdInput = userId.nativeElement;
    let passwordInput = password.nativeElement;
    let registerButtonInput = registerButton.nativeElement;
    let userButtonInput = userButton.nativeElement;

    expect(userIdInput).toBeTruthy();
    expect(passwordInput).toBeTruthy();
    expect(registerButtonInput).toBeTruthy();
    expect(userButtonInput).toBeTruthy();
   
  });

  it('should redirect to  login if registered successfully',async()=>{
    let userId = fixture.debugElement.query(By.css('.inputID'));
    let password = fixture.debugElement.query(By.css('.inputPass'));
    let userButton = fixture.debugElement.query(By.css('.login-user'));
    let userIdInput = userId.nativeElement;
    let passwordInput = password.nativeElement;

    let userButtonInput= userButton.nativeElement;
    fixture.detectChanges();
    fixture.whenStable().then(()=>{
      userIdInput.value = 'testuser',
      passwordInput.value = 'testpass',
      userIdInput.dispatchEvent(new Event('input'));
      passwordInput.dispatchEvent(new Event('input'));
      userButtonInput.click();
    }).then(()=>{
      expect(location.path()).toBe('');
    })
  });
});
