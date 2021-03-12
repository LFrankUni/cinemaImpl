import { NgModule } from '@angular/core';
import { MessageModule, SharedModule } from '@shared';
import { MovieShowModule } from '@shared/movie-show';
import {
  CreateCinemaComponent,
  CreateRoomComponent,
  CreateSeatsComponent,
  CreateRowCategoryComponent,
  CreateRowComponent,
  CreateMovieComponent,
  ScheduleMovieShowComponent,
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
    CreateMovieComponent,
    ScheduleMovieShowComponent,
  ],
  imports: [SharedModule, MessageModule, MovieShowModule, RoutingModule],
})
export class AdminModule {}
