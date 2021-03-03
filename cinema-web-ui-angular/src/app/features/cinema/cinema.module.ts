import { NgModule } from '@angular/core';
import { OverviewComponent, CinemaOverviewComponent } from './pages';
import { RoutingModule } from './routes';
import { CinemaCardComponent } from './components';
import { SharedModule } from '@shared';

@NgModule({
  declarations: [
    OverviewComponent,
    CinemaCardComponent,
    CinemaOverviewComponent,
  ],
  imports: [SharedModule, RoutingModule],
})
export class CinemaModule {}
