import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ADMIN_ROUTES } from '@features/admin/routes';
import { CINEMA_ROUTES } from '@features/cinema/routes';
import { Route } from '@model/routing';

export const ADMIN_FEAUTURE: string = 'admin';
export const ADMIN_FEATURE_ROUTES: Route = {
  name: 'Admin',
  path: ADMIN_FEAUTURE,
  children: ADMIN_ROUTES,
};
export const CINEMA_FEAUTURE: string = '';
export const CINEMA_FEAUTURE_ROUTES: Route = {
  name: 'Cinemas',
  path: CINEMA_FEAUTURE,
  children: CINEMA_ROUTES,
};

export const APP_ROUTES: Route[] = [
  CINEMA_FEAUTURE_ROUTES,
  ADMIN_FEATURE_ROUTES,
];

const routes: Routes = [
  {
    path: ADMIN_FEAUTURE,
    loadChildren: () =>
      import('@features/admin/admin.module').then(
        (module) => module.AdminModule
      ),
  },
  {
    path: CINEMA_FEAUTURE,
    loadChildren: () =>
      import('@features/cinema/cinema.module').then(
        (module) => module.CinemaModule
      ),
  },
  {
    path: '**',
    redirectTo: CINEMA_FEAUTURE,
    pathMatch: 'full',
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
