import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ControlComponent } from '../pages';

const routes: Routes = [
  {
    path: 'control',
    component: ControlComponent,
  },
  {
    path: '**',
    redirectTo: 'control',
    pathMatch: 'full',
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class RoutingModule {}
