import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { Route } from '@model/routing';
import { BuilderComponent } from '../pages';

export const BUILDER: string = 'builder';
export const INCOME: string = 'income';

export const ADMIN_ROUTES: Route[] = [
  {
    name: 'Builder',
    path: BUILDER,
  },
  {
    name: 'Income',
    path: INCOME,
  },
];

const routes: Routes = [
  {
    path: BUILDER,
    component: BuilderComponent,
  },
  {
    path: '**',
    redirectTo: BUILDER,
    pathMatch: 'full',
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class RoutingModule {}
