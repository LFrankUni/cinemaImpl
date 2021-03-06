import { NgModule } from '@angular/core';
import { MessageModule, SharedModule } from '@shared';
import { CreateCinemaComponent } from './components';
import { ControlComponent } from './pages';
import { RoutingModule } from './routes';

@NgModule({
  declarations: [CreateCinemaComponent, ControlComponent],
  imports: [SharedModule, MessageModule, RoutingModule],
})
export class AdminModule {}
