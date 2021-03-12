import { Route } from '@model/routing';

export const OVERVIEW: string = 'overview';
export const CINEMA: string = 'cinema';
export const CINEMA_QUERY_PARAM_ID = 'id';
export const MOVIES = 'movies';
export const MOVIES_QUERY_PARAM_CINEMA_ID = 'cinema';

export const CINEMA_ROUTES: Route[] = [
  {
    name: 'Overview',
    path: OVERVIEW,
  },
];
