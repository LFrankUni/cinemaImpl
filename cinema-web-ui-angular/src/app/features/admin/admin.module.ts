import { NgModule } from '@angular/core';
import { MessageModule, SharedModule } from '@shared';
import {
  CreateCinemaComponent,
  CreateRoomComponent,
  CreateSeatsComponent,
  CreateRowCategoryComponent,
  CreateRowComponent,
  AddMovieComponent,
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
    AddMovieComponent,
  ],
  imports: [SharedModule, MessageModule, RoutingModule],
})
export class AdminModule {}
