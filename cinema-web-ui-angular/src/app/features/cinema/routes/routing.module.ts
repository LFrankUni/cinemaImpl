import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { Route } from '@model/routing';
import {
  CinemaOverviewComponent,
  MoviesComponent,
  OverviewComponent,
} from '../pages';

export const OVERVIEW: string = 'overview';
export const CINEMA: string = 'cinema';
export const CINEMA_QUERY_PARAM_ID = 'id';
export const MOVIES = 'movies';
export const MOVIES_QUERY_PARAM_CINEMA_ID = 'id';

export const CINEMA_ROUTES: Route[] = [
  {
    name: 'Overview',
    path: OVERVIEW,
  },
];

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
