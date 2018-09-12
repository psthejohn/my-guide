import { AuthenticationService } from "../authentication/authentication.service";
import { TestBed, inject, fakeAsync, TestComponentRenderer } from "@angular/core/testing";
import { HttpClientModule,HttpClient,HttpEvent,HttpEventType } from "@angular/common/http";  
import { HttpClientTestingModule,HttpTestingController}  from "@angular/common/http/testing";
import { Observable } from 'rxjs';
import { MatSnackBarModule} from "@angular/material/snack-bar"



const testConfig={

    addUser:{
        positive:{
            firstName: 'test',
            lastName: 'testLast',
            userId: 'testUser@gmail.com',
            password: 'testpass'
        }
    },

    loginUser:{
        poisitive:{
            userId:'testUser@gmail.com',
            password: 'testpass'
        }
    }

   
}


describe('AuthenticationService',()=>{
    let authService :  AuthenticationService;
    beforeEach(()=>{

        TestBed.configureTestingModule({
            imports:[HttpClientModule,HttpClientTestingModule,MatSnackBarModule],
            providers:[AuthenticationService]
        });
        
        authService = TestBed.get(AuthenticationService);
    });

    it('should create the authentication service', 
        inject([AuthenticationService],(service: AuthenticationService)=>{
            expect(service).toBeTruthy();
        }));

    it('should register user data ', fakeAsync(()=>{
        let data = testConfig.addUser.positive;
        
        inject([AuthenticationService,HttpTestingController],(backend:HttpTestingController)=>{
            const mockReq = backend.expectOne(authService.springEndpoint);
            expect(mockReq.request.url).toEqual(authService.springEndpoint,"requested url should match with json server api url ");
            expect(mockReq.request.method).toBe('POST','Should handle requested method type');

            mockReq.flush(data);
            backend.verify();
        });
        
        authService.registerUser(data).subscribe((res:any)=>{
            expect(res).toBeDefined();
            expect(res._body).toBe(data,'data should be same');
        });
    }));

    it('should login user ', fakeAsync(()=>{
        let userdata = testConfig.loginUser.poisitive;
        
        inject([AuthenticationService,HttpTestingController],(backend:HttpTestingController)=>{
            const mockReq = backend.expectOne(authService.springEndpoint);
            expect(mockReq.request.url).toEqual(authService.springEndpoint,'requested url should match with json server api url');
            expect(mockReq.request.method).toBe('POST','Should handle requested method type');

            mockReq.flush(userdata);
            backend.verify();
        });

        authService.loginUser(userdata).subscribe((res:any)=>{
            expect(res).toBeDefined();
            expect(res._body).toBe(userdata,'data should be same');
        });
    }));
});