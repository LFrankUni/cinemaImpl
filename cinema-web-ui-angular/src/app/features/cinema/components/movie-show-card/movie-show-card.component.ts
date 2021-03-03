import { Component, Input } from '@angular/core';
import { MovieShow } from '@model';

@Component({
  selector: 'app-movie-show-card',
  templateUrl: './movie-show-card.component.html',
  styleUrls: ['./movie-show-card.component.scss'],
})
export class MovieShowCardComponent {
  @Input()
  public show: MovieShow;
}
