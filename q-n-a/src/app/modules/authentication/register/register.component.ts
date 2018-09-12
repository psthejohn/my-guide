import { Component, OnInit, ViewChild } from '@angular/core';
import { AuthenticationService } from './../authentication.service'; 
import { User } from './../User';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  newUser: User;

  @ViewChild('registerForm') public registerUserForm : NgForm;

  constructor(private authService: AuthenticationService, private router: Router) {
    this.newUser= new User();
   }

  ngOnInit() {
  }

  onSubmit(){
    console.log("Register user", this.newUser.userId,this.newUser.firstName);
    console.log("new user", this.newUser);

    this.authService.registerUser(this.newUser).subscribe((data)=> {
      console.log("user data ", data);

      this.router.navigate(['/login']);
    })
  }

  resetInput(){
    this.registerUserForm.reset();
  }

}
