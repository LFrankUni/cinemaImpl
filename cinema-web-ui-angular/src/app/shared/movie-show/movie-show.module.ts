import { NgModule } from '@angular/core';
import { MovieShowListComponent } from './movie-show-list';
import { SharedModule } from '@shared/shared.module';

@NgModule({
  declarations: [MovieShowListComponent],
  imports: [SharedModule],
  exports: [MovieShowListComponent],
})
export class MovieShowModule {}
