import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { CinemaService } from '@core/data';
import { CINEMA_QUERY_PARAM_ID } from '@features/cinema/routes/constants';
import { Cinema, MovieShow } from '@model/data';
import { add, getStartOfToday } from '@utilities/date';
import { combineLatest, forkJoin, Observable, of } from 'rxjs';
import {
  map,
  pluck,
  shareReplay,
  startWith,
  switchMap,
  tap,
  withLatestFrom,
} from 'rxjs/operators';

@Component({
  selector: 'app-cinema-overview',
  templateUrl: './cinema-overview.component.html',
  styleUrls: ['./cinema-overview.component.scss'],
})
export class CinemaOverviewComponent implements OnInit {
  public cinema$: Observable<Cinema>;
  public shows$: Observable<MovieShow[]>;
  public readonly form: FormControl = new FormControl(
    getStartOfToday(),
    Validators.required
  );

  constructor(
    private readonly route: ActivatedRoute,
    private readonly cinema: CinemaService
  ) {}

  ngOnInit(): void {
    this.cinema$ = this.route.queryParams.pipe(
      pluck(CINEMA_QUERY_PARAM_ID),
      switchMap((id) => this.cinema.getObject<Cinema>(id)),
      shareReplay(1)
    );
    this.shows$ = combineLatest([
      this.form.valueChanges.pipe(startWith(getStartOfToday())),
      this.cinema$,
    ]).pipe(
      map((tuple) => ({ date: tuple[0], cinema: tuple[1] })),
      switchMap(({ date, cinema }) =>
        this.cinema.getScheduledMovieShows(date, add(date, 1), cinema)
      ),
      switchMap((shows) =>
        shows.value.length === 0
          ? of([])
          : forkJoin(
              shows.value.map((show) =>
                this.cinema
                  .getTheMovie(show)
                  .pipe(map((movie) => ({ ...show, movie: movie.value })))
              )
            )
      )
    );
  }
}
