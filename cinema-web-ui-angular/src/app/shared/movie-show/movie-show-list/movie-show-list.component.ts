import { Component, Input } from '@angular/core';
import { MovieShow } from '@model/data';

@Component({
  selector: 'app-movie-show-list',
  templateUrl: './movie-show-list.component.html',
  styleUrls: ['./movie-show-list.component.scss'],
})
export class MovieShowListComponent {
  @Input()
  public movieShows: MovieShow[];
}
