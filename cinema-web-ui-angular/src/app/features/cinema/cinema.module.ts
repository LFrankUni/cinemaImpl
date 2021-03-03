import { NgModule } from '@angular/core';
import { OverviewComponent, CinemaOverviewComponent } from './pages';
import { RoutingModule } from './routes';
import {
  CinemaCardComponent,
  MovieCardComponent,
  MovieShowCardComponent,
} from './components';
import { SharedModule } from '@shared';

@NgModule({
  declarations: [
    OverviewComponent,
    CinemaCardComponent,
    CinemaOverviewComponent,
    MovieCardComponent,
    MovieShowCardComponent,
  ],
  imports: [SharedModule, RoutingModule],
})
export class CinemaModule {}
