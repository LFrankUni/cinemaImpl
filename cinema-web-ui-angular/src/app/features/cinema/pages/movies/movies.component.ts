import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CinemaService } from '@core/data';
import { MOVIES_QUERY_PARAM_CINEMA_ID } from '@features/cinema/routes/constants';
import { Cinema, Movie, MovieShow } from '@model/data';
import { add, getStartOfToday } from '@utilities/date';
import { BehaviorSubject, Observable } from 'rxjs';
import { map, pluck, switchMap, tap } from 'rxjs/operators';

@Component({
  selector: 'app-movies',
  templateUrl: './movies.component.html',
  styleUrls: ['./movies.component.scss'],
})
export class MoviesComponent implements OnInit {
  private _movies$: Observable<Movie[]>;
  private _cinema$: BehaviorSubject<Cinema> = new BehaviorSubject<Cinema>(null);
  private _shows: Map<Movie, Observable<MovieShow[]>> = new Map<
    Movie,
    Observable<MovieShow[]>
  >();

  constructor(
    private readonly route: ActivatedRoute,
    private readonly cinemaService: CinemaService
  ) {}

  ngOnInit(): void {
    this._movies$ = this.route.queryParams.pipe(
      pluck(MOVIES_QUERY_PARAM_CINEMA_ID),
      switchMap((id) =>
        this.cinemaService
          .getAllCinemas()
          .pipe(map((res) => res.value.find((cinema) => cinema.id == id)))
      ), //TODO handle if cinema null aka not exists
      tap((cinema) => this._cinema$.next(cinema)),
      switchMap((cinema) =>
        this.cinemaService.getAllMovies(cinema).pipe(
          map((res) => res.value),
          tap((movies) =>
            movies.forEach((movie) =>
              this._shows.set(
                movie,
                this.cinemaService
                  .getAllMovieShows(
                    getStartOfToday(),
                    add(getStartOfToday(), 7, 0, 0, 0, -1),
                    cinema,
                    movie
                  )
                  .pipe(map((res) => res.value))
              )
            )
          )
        )
      )
    );
  }

  public get shows(): Map<Movie, Observable<MovieShow[]>> {
    return this._shows;
  }

  public get movies$(): Observable<Movie[]> {
    return this._movies$;
  }

  public get cinema$(): Observable<Cinema> {
    return this._cinema$.asObservable();
  }
}
