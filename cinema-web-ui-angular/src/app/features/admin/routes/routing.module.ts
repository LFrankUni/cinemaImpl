import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { Route } from '@model/routing';
import { ControlComponent } from '../pages';

export const CONTROL: string = 'control';
export const INCOME: string = 'income';

export const ADMIN_ROUTES: Route[] = [
  {
    name: 'Control',
    path: CONTROL,
  },
  {
    name: 'Income',
    path: INCOME,
  },
];

const routes: Routes = [
  {
    path: CONTROL,
    component: ControlComponent,
  },
  {
    path: '**',
    redirectTo: CONTROL,
    pathMatch: 'full',
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class RoutingModule {}
