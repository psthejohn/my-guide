import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import { RouterModule,Routes } from '@angular/router';


import { AuthenticationModule }from './modules/authentication/authentication.module';
import { AuthGuardService } from './authGuard.service';
import { AppComponent } from './app.component';
import { QnaModule } from './modules/qna/qna.module';
//import { QnaRouterModule } from './modules/qna/qna-router.module';
//import { APP_BASE_HREF } from '@angular/common';
  

const appRoutes:Routes = [
  //{
  //  path : '',
  //  redirectTo: '/qna/topic',
  //  pathMatch: 'full'
  //}

  {
    path : '',
    redirectTo : '/login',
    pathMatch: 'full'
  }
]

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    QnaModule,
    BrowserAnimationsModule,AuthenticationModule,
    
    RouterModule.forRoot(appRoutes)
  ],
  providers: [AuthGuardService],
  bootstrap: [AppComponent]
})
export class AppModule { }
