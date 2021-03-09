import { NgModule } from '@angular/core';
import { MessageModule, SharedModule } from '@shared';
import {
  CreateCinemaComponent,
  CreateRoomComponent,
  CreateSeatsComponent,
  CreateRowCategoryComponent,
  CreateRowComponent,
} from './components';
import { BuilderComponent } from './pages';
import { RoutingModule } from './routes';

@NgModule({
  declarations: [
    CreateCinemaComponent,
    CreateRoomComponent,
    CreateRowCategoryComponent,
    CreateSeatsComponent,
    CreateRowComponent,
    BuilderComponent,
  ],
  imports: [SharedModule, MessageModule, RoutingModule],
})
export class AdminModule {}
