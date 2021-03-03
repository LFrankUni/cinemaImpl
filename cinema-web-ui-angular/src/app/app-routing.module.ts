import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: '',
    loadChildren: () =>
      import('@features/cinema/cinema.module').then(
        (module) => module.CinemaModule
      ),
  },
  {
    path: 'admin',
    loadChildren: () =>
      import('@features/admin/admin.module').then(
        (module) => module.AdminModule
      ),
  },
  {
    path: '**',
    redirectTo: '',
    pathMatch: 'full',
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
