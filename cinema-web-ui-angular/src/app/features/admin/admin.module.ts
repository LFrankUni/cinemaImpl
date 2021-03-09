import { NgModule } from '@angular/core';
import { MessageModule, SharedModule } from '@shared';
import {
  CreateCinemaComponent,
  CreateRoomComponent,
  CreateSeatsComponent,
  CreateRowCategoryComponent,
  CreateRowComponent,
} from './components';
import { ControlComponent } from './pages';
import { RoutingModule } from './routes';

@NgModule({
  declarations: [
    CreateCinemaComponent,
    ControlComponent,
    CreateRoomComponent,
    CreateRowCategoryComponent,
    CreateSeatsComponent,
    CreateRowComponent,
  ],
  imports: [SharedModule, MessageModule, RoutingModule],
})
export class AdminModule {}
