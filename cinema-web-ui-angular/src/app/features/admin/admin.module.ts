import { NgModule } from '@angular/core';
import { MessageModule, SharedModule } from '@shared';
import {
  CreateCinemaComponent,
  CreateRoomComponent,
  CreateRowCategoryComponent,
} from './components';
import { ControlComponent } from './pages';
import { RoutingModule } from './routes';

@NgModule({
  declarations: [
    CreateCinemaComponent,
    ControlComponent,
    CreateRoomComponent,
    CreateRowCategoryComponent,
  ],
  imports: [SharedModule, MessageModule, RoutingModule],
})
export class AdminModule {}
