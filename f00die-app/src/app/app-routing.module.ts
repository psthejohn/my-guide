import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SearchComponent } from './search/search.component';
import { FavouritesComponent } from './favourites/favourites.component';
import { HomeComponent } from './home/home.component';
import { DetailsComponent } from './details/details.component';

// This would set defualt page and rules for different URI w.r.t routes
const routes: Routes = [
  {
    path: '', redirectTo: 'search', pathMatch: 'full'
    // Default route to land on load
    },
  {
    path: 'home',
    component: HomeComponent
  }, {
    path: 'search',
    component: SearchComponent
  },
  {
    path: 'favourite',
    component: FavouritesComponent
  },
  {
    path: 'details/:id',
    component: DetailsComponent
  }
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
