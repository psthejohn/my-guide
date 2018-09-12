import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TopicThumbnailComponent } from './components/topicthumbnail/topicthumbnail.component';
import { HttpClientModule,HTTP_INTERCEPTORS } from '@angular/common/http';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule,MatButton } from '@angular/material/button';
import { MatInputModule } from '@angular/material/input';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { FormsModule } from '@angular/forms';
import { MatDialogModule } from '@angular/material/dialog';
import { TokenInterceptor } from './interceptor.service';
import { MatFormFieldModule} from '@angular/material';


import { QnaService } from './qna.service';
import { QuestionthumbnailComponent } from './components/questionthumbnail/questionthumbnail.component';
import { QnaRouterModule } from './qna-router.module';

import { CommentthumbnailComponent } from './components/commentthumbnail/commentthumbnail.component';

@NgModule({
  imports: [
    CommonModule,
    HttpClientModule,
    FormsModule,
    QnaRouterModule,MatFormFieldModule,
    MatCardModule,MatButtonModule,MatInputModule,MatSnackBarModule,MatDialogModule
  ],
  declarations: [
    TopicThumbnailComponent,
    QuestionthumbnailComponent,
    CommentthumbnailComponent],
  exports: [
    TopicThumbnailComponent,
    QuestionthumbnailComponent,
    CommentthumbnailComponent,
    MatFormFieldModule,
    QnaRouterModule,
    MatCardModule
  ],
  providers:[
    QnaService,{
      provide: HTTP_INTERCEPTORS,
      useClass: TokenInterceptor,
      multi: true
    }
  ]
})
export class QnaModule { }
