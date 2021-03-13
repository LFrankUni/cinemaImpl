import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {
  CinemaOverviewComponent,
  MoviesComponent,
  MovieShowComponent,
  OverviewComponent,
} from '../pages';
import { CINEMA, MOVIES, MOVIE_SHOW, OVERVIEW } from './constants';

const routes: Routes = [
  {
    path: OVERVIEW,
    component: OverviewComponent,
  },
  {
    path: CINEMA,
    component: CinemaOverviewComponent,
  },
  { path: MOVIES, component: MoviesComponent },
  { path: MOVIE_SHOW, component: MovieShowComponent },
  {
    path: '**',
    redirectTo: OVERVIEW,
    pathMatch: 'full',
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class RoutingModule {}
