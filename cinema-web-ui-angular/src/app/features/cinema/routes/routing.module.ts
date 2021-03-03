import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CinemaOverviewComponent, OverviewComponent } from '../pages';

const routes: Routes = [
  {
    path: 'overview',
    component: OverviewComponent,
  },
  {
    path: 'cinema',
    component: CinemaOverviewComponent,
  },
  {
    path: '**',
    redirectTo: 'overview',
    pathMatch: 'full',
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class RoutingModule {}
