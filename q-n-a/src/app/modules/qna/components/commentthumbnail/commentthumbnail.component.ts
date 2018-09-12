import { Component, OnInit } from '@angular/core';
import { Comment } from '../../comment';
import { QnaService } from '../../qna.service';
import { ActivatedRoute, Router } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';
import { AuthenticationService } from '../../../authentication/authentication.service';

@Component({
  selector: 'qna-commentthumbnail',
  templateUrl: './commentthumbnail.component.html',
  styleUrls: ['./commentthumbnail.component.css']
})
export class CommentthumbnailComponent implements OnInit {

  comments : Array<Comment>;
  questionId: Int16Array;
  questionDescription : string;

  commentInput: Comment;

  constructor(private qnaService: QnaService, private route: ActivatedRoute,private snackBar: MatSnackBar,
    private auth: AuthenticationService, private router: Router) { 
    this.comments = [];
    this.route.queryParams.subscribe(params=>{
      this.questionId = params["questionId"];
      this.questionDescription = params["questionDescription"]
    })

    this.commentInput = new Comment();
    
  }

  ngOnInit() {
    this.qnaService.getComments(this.questionId).subscribe((comments) => {
      
      console.log(comments);
      this.comments.push(...comments);
  });
}
addCommentMethod(commentField : string){
    
  console.log(commentField);
  console.log(this.commentInput);
  this.commentInput.commentDescription = commentField;
  this.commentInput.questionId = this.questionId;
  //alert(this.questionInput.questionDescription);
  let message = `Comment is added`;
  this.qnaService.addComment(this.commentInput).subscribe((question)=>{
    this.snackBar.open(message,'',{
      duration:1000
    });
    this.qnaService.getComment(commentField).subscribe((comment)=>{
      this.comments.push(comment);
    });
  
});
}  

deleteCommentMethod(comment : Comment){
  let message = `Comment is deleted`;
  this.qnaService.deleteComment(comment.commentId).subscribe((comment)=>{
    this.snackBar.open(message,'',{
      duration:1000
    })
  });
  const index = this.comments.indexOf(comment);
  this.comments.splice(index,1);
}

Logout(){
  this.auth.deleteToken();
  this.router.navigate(['/login']);
}

}
