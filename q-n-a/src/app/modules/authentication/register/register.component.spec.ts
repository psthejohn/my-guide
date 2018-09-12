import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterComponent } from './register.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { MatFormFieldModule, MatInputModule, MatButtonModule } from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { RouterTestingModule } from '@angular/router/testing';
import { AuthenticationService } from '../authentication.service';
import { Router } from '@angular/router';
import { Location } from '@angular/common';
import { By } from '@angular/platform-browser';
import { of } from 'rxjs/observable/of';

const testConfig={
  userdata:{
    firstName: 'test',
    lastName: 'testlast',
    userId: 'testuser',
    password: 'testpass'
  }
}

describe('RegisterComponent', () => {
  let component: RegisterComponent;
  let fixture: ComponentFixture<RegisterComponent>;
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
      declarations: [ RegisterComponent ],
      imports: [FormsModule,HttpClientModule,MatFormFieldModule,MatInputModule,
        MatButtonModule,BrowserAnimationsModule,RouterTestingModule.withRoutes(
          [{path: '',component: dummy}]
        )],
        providers: [{provide:AuthenticationService,useClass:AuthServiceStub}]
    })
    .compileComponents();
  }));

  

  beforeEach(() => {
    fixture = TestBed.createComponent(RegisterComponent);
    routes = TestBed.get(Router);
    location = TestBed.get(Location);
    component = fixture.componentInstance;
    fixture.detectChanges();
    fixture.debugElement.injector.get(AuthenticationService);
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should contain input boxes for firstName, LastName, userId and password',()=>{
    let firstName= fixture.debugElement.query(By.css('.first-name'));
    let lastName= fixture.debugElement.query(By.css('.last-name'));
    let userId= fixture.debugElement.query(By.css('.user-id'));
    let password = fixture.debugElement.query(By.css('.password'));
    let registerButton = fixture.debugElement.query(By.css('.register-user'));
    let clearButton = fixture.debugElement.query(By.css('.clear'));

    let firstNameInput = firstName.nativeElement;
    let lastNameInput = lastName.nativeElement;
    let userIdInput = userId.nativeElement;
    let passwordInput = password.nativeElement;
    let registerButtonInput = registerButton.nativeElement;
    let clearButtonInput = clearButton.nativeElement;

    expect(firstNameInput).toBeTruthy();
    expect(lastNameInput).toBeTruthy();
    expect(userIdInput).toBeTruthy();
    expect(passwordInput).toBeTruthy();
    expect(registerButtonInput).toBeTruthy();
    expect(clearButtonInput).toBeTruthy();
   
  });

  it('should registered successfully',async()=>{
    let firstName= fixture.debugElement.query(By.css('.first-name'));
    let lastName= fixture.debugElement.query(By.css('.last-name'));
    let userId= fixture.debugElement.query(By.css('.user-id'));
    let password = fixture.debugElement.query(By.css('.password'));
    let registerButton = fixture.debugElement.query(By.css('.register-user'));
    

    let firstNameInput = firstName.nativeElement;
    let lastNameInput = lastName.nativeElement;
    let userIdInput = userId.nativeElement;
    let passwordInput = password.nativeElement;
    let registerButtonInput = registerButton.nativeElement;
    

    fixture.detectChanges();
    fixture.whenStable().then(()=>{
      userIdInput.value = 'testuser',
      passwordInput.value = 'testpass',
      firstNameInput.value = 'testFirstName',
      lastNameInput.value = 'testLastName',
      userIdInput.dispatchEvent(new Event('input'));
      passwordInput.dispatchEvent(new Event('input'));
      firstNameInput.dispatchEvent(new Event('input'));
      lastNameInput.dispatchEvent(new Event('input'));
      registerButtonInput.click();
    }).then(()=>{
      expect(location.path()).toBe('');
    });

  });
});
