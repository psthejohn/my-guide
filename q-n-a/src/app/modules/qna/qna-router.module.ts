import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { TopicThumbnailComponent } from "./components/topicthumbnail/topicthumbnail.component";
import { QuestionthumbnailComponent } from "./components/questionthumbnail/questionthumbnail.component";
import { CommentthumbnailComponent } from "./components/commentthumbnail/commentthumbnail.component";
import { AuthGuardService } from '../../authGuard.service';

const qnaRoutes: Routes = [
    {
        path: 'qna',
        children: [
            {
                path: '',
                redirectTo: '/qna/topic',
                pathMatch: 'full',
                canActivate: [AuthGuardService]
            },
            
            {
                path: 'topic',
                component: TopicThumbnailComponent,
                canActivate: [AuthGuardService]
            },
            {
                path: 'question',
                component: QuestionthumbnailComponent,
                canActivate: [AuthGuardService]
            },
            {
                path: 'comment',
                component: CommentthumbnailComponent,
                canActivate: [AuthGuardService]
            }
        ]
    }
]


@NgModule({
    imports: [
        RouterModule.forChild(qnaRoutes),
    ],
    exports:[
        RouterModule
    ]
})



export class QnaRouterModule {

}