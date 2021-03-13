import { NgModule } from '@angular/core';
import {
  OverviewComponent,
  CinemaOverviewComponent,
  MoviesComponent,
  MovieShowComponent,
} from './pages';
import { RoutingModule } from './routes';
import {
  CinemaCardComponent,
  MovieCardComponent,
  MovieShowCardComponent,
} from './components';
import { SharedModule } from '@shared';
import { MovieShowModule } from '@shared/movie-show';

@NgModule({
  declarations: [
    OverviewComponent,
    CinemaCardComponent,
    CinemaOverviewComponent,
    MovieCardComponent,
    MovieShowCardComponent,
    MoviesComponent,
    MovieShowComponent,
  ],
  imports: [SharedModule, MovieShowModule, RoutingModule],
})
export class CinemaModule {}
