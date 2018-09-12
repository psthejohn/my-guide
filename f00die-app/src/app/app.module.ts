import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { SearchComponent } from './search/search.component';
import { FavouritesComponent } from './favourites/favourites.component';
import { AppRoutingModule } from './app-routing.module';
import { FavouritesService } from './favourites/favourites.service';
import { HomeService } from './home/home.service';
import { SearchService } from './search/search.service';
import { HttpClientModule } from '@angular/common/http';
import { HomeComponent } from './home/home.component';
import { FormsModule } from '@angular/forms';
import { DetailsComponent } from './details/details.component';
import { DetailsService } from './details/details.service';

export const myComponents = [
  AppComponent
];

@NgModule({
  declarations: [
    ...myComponents,
    SearchComponent,
    FavouritesComponent,
    HomeComponent,
    DetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [FavouritesService, HomeService, SearchService, DetailsService],
  bootstrap: [AppComponent]
})
export class AppModule { }
