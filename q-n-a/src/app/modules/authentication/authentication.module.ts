import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { FormsModule } from '@angular/forms';
import { AuthenicationRoutingModule } from './authentication-router.module';
import { MatFormFieldModule, MatInputModule,  MatButtonModule, MatIconModule, MatCardModule } from '@angular/material';
import { AuthenticationService } from './authentication.service';
import { MatSnackBarModule } from '@angular/material/snack-bar';
//import { MatSnackBar } from '@angular/material/snack-bar';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    AuthenicationRoutingModule,
    MatFormFieldModule,MatSnackBarModule,
    MatInputModule,
    MatButtonModule,
    MatIconModule,
    MatCardModule
  ],
  declarations: [RegisterComponent, LoginComponent],
  providers:[
    AuthenticationService
  ],
  exports:[RegisterComponent,LoginComponent,MatFormFieldModule]
})
export class AuthenticationModule { }
