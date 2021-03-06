import { NgModule } from '@angular/core';
import { SharedModule } from '@shared';
import { CreateCinemaComponent } from './components';
import { ControlComponent } from './pages';
import { RoutingModule } from './routes';

@NgModule({
  declarations: [CreateCinemaComponent, ControlComponent],
  imports: [SharedModule, RoutingModule],
})
export class AdminModule {}
