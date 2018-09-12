import { Component, OnInit, Input, Output } from '@angular/core';
import { Topic } from '../../topic';
import { QnaService } from '../../qna.service';
import { NavigationExtras, Router } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';
import { AuthenticationService } from '../../../authentication/authentication.service';

@Component({
  selector: 'qna-topicthumbnail',
  templateUrl: './topicthumbnail.component.html',
  styleUrls: ['./topicthumbnail.component.css']
})
export class TopicThumbnailComponent implements OnInit {

  
  topics : Array<Topic>;
  
  topicInput : Topic;
  
  
  constructor(private qnaService: QnaService, private router: Router
    ,private snackBar: MatSnackBar,private auth: AuthenticationService) {
    this.topics =  [];
    
    this.topicInput = new Topic();
   }

  ngOnInit() {
    this.qnaService.getTopics().subscribe((topics) => {
      
      console.log(topics);
      this.topics.push(...topics);
    });
  }

  onClick(topic){
    let navigationExtras: NavigationExtras = {
      queryParams: {
          "topicName": topic.topicName,
          "topicId": topic.topicId
      }
  };
    this.router.navigate(["qna/question"], navigationExtras);
  }

  addTopicMethod(topicfield : string,topicfielddescription: string){
    
    console.log(topicfield);
    console.log(this.topicInput);
    this.topicInput.topicName = topicfield;
    this.topicInput.topicDescription = topicfielddescription;
    //alert(this.questionInput.questionDescription);
    let message = `Topic is added`;
    this.qnaService.addTopic(this.topicInput).subscribe((topic)=>{
      this.snackBar.open(message,'',{
        duration:1000
      });
    this.qnaService.getTopic(topicfield).subscribe((topic)=>{
      this.topics.push(topic);
    });
    
  });
}

Logout(){
  this.auth.deleteToken();
  this.router.navigate(['/login']);
}

}
