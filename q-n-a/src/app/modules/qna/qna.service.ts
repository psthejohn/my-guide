import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Topic } from './topic';
import { Question } from './question';
import { Comment } from './comment';

@Injectable()
export class QnaService {

  qnaSpringServiceEndpoint : string;
  watchlistEndpoint: string;
  qnaType: string;


  constructor(private http : HttpClient) {
    this.qnaSpringServiceEndpoint= "http://localhost:8888/v1/qna";
    this.watchlistEndpoint = "http://localhost:3000/question";
    this.qnaType="";
   }

   getTopics() : Observable<Array<Topic>>{
    this.qnaType = "topic";
    return this.http.get<Array<Topic>>(`${this.qnaSpringServiceEndpoint}/${this.qnaType}`);
   }

   getQuestions(topicId) : Observable<Array<Question>>{
    this.qnaType = "questionsintopic";
    return this.http.get<Array<Question>>(`${this.qnaSpringServiceEndpoint}/${this.qnaType}/${topicId}`);
  }

   getComments(questionId): Observable<Array<Comment>>{
    this.qnaType = "commentsinquestion";
     return this.http.get<Array<Comment>>(`${this.qnaSpringServiceEndpoint}/${this.qnaType}/${questionId}`);
   }

   addQuestion(question){
    //alert(question.questionDescription);
    this.qnaType = "question";
    return this.http.post(`${this.qnaSpringServiceEndpoint}/${this.qnaType}`,question);
   }

   deleteQuestion(questionId: Int16Array){
    this.qnaType = "question";
    console.log(`${this.qnaSpringServiceEndpoint}/${this.qnaType}/${questionId}`);
    return this.http.delete(`${this.qnaSpringServiceEndpoint}/${this.qnaType}/${questionId}`,{responseType : 'text'});
   }

   addComment(comment){
     this.qnaType = "comment";
     return this.http.post(`${this.qnaSpringServiceEndpoint}/${this.qnaType}`,comment);
   }

   deleteComment(commentId: Int16Array){
    this.qnaType = "comment";
    return this.http.delete(`${this.qnaSpringServiceEndpoint}/${this.qnaType}/${commentId}`,{responseType : 'text'});
   }

   addTopic(topic){
     this.qnaType = "topic";
     return this.http.post(`${this.qnaSpringServiceEndpoint}/${this.qnaType}`,topic);
   }

   getTopic(topicName: string): Observable<Topic>{
    this.qnaType = "topic";
    return this.http.get<Topic>(`${this.qnaSpringServiceEndpoint}/${this.qnaType}/${topicName}`);
   }

   getQuestion(questionDescription : string): Observable<Question>{
    console.log("QuestionDescription" +questionDescription);
    this.qnaType = "question";
    return this.http.get<Question>(`${this.qnaSpringServiceEndpoint}/${this.qnaType}/${questionDescription}`);
   }

   getComment(commentDescription: string): Observable<Comment>{
    this.qnaType = "comment";
    return this.http.get<Comment>(`${this.qnaSpringServiceEndpoint}/${this.qnaType}/${commentDescription}`);
   }
}
