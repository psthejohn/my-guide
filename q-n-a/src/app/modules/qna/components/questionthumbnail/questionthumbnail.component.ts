import { Component, OnInit, Input } from '@angular/core';
import { Question } from '../../question';
import { QnaService } from '../../qna.service';
import { ActivatedRoute, NavigationExtras, Router } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';
import { AuthenticationService } from '../../../authentication/authentication.service';

@Component({
  selector: 'qna-questionthumbnail',
  templateUrl: './questionthumbnail.component.html',
  styleUrls: ['./questionthumbnail.component.css']
})
export class QuestionthumbnailComponent implements OnInit {

  questions : Array<Question>;
  topicId: Int16Array;
  topicName: string;

  
  questionInput:  Question; 

  constructor(private qnaService: QnaService, private route: ActivatedRoute,
    private router: Router,private snackBar: MatSnackBar,private auth: AuthenticationService) { 
    this.questions = [];
    this.route.queryParams.subscribe(params=>{
      this.topicId = params["topicId"];
      this.topicName = params["topicName"];
    });
    this.questionInput = new Question();
    
  }

  ngOnInit() {
    this.qnaService.getQuestions(this.topicId).subscribe((questions) => {
      console.log(questions);
      this.questions.push(...questions);
    });
  }

  onClick(question){
    let navigationExtras: NavigationExtras = {
      queryParams: {
          "questionId": question.questionId,
          "questionDescription" : question.questionDescription
      }
  };
    this.router.navigate(["qna/comment"], navigationExtras); 
  }

  addQuestionMethod(questionfield : string){
    
    console.log(questionfield);
    console.log(this.questionInput);
    this.questionInput.questionDescription = questionfield;
    this.questionInput.topicId = this.topicId;
    
    //alert(this.questionInput.questionDescription);
    let message = `Question is added`;
    this.qnaService.addQuestion(this.questionInput).subscribe((question)=>{
       
      //this.questionInput = question;
      this.snackBar.open(message,'',{
        duration:1000
      }
      
    );
    this.qnaService.getQuestion(questionfield).subscribe((question)=>{
      console.log(question);
      this.questions.push(question);
    });
    
    
  });
}

  deleteQuestionMethod(question: Question){
    let message = `Question is deleted`;
    this.qnaService.deleteQuestion(question.questionId).subscribe((question)=>{
      this.snackBar.open(message,'',{
        duration:1000
      })
    });
    const index = this.questions.indexOf(question);
    this.questions.splice(index,1);
  }

  Logout(){
    this.auth.deleteToken();
    this.router.navigate(['/login']);
  }
}
