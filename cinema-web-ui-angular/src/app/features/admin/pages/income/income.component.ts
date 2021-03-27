import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { CinemaService } from '@core/data';
import { Cinema, Movie, MovieShow, Room } from '@model/data';
import { add, getStartOfToday } from '@utilities/date';
import { isNonNull } from '@utilities/isNonNull';
import { combineLatest, forkJoin, of } from 'rxjs';
import { BehaviorSubject, Observable } from 'rxjs';
import {
  filter,
  map,
  shareReplay,
  startWith,
  switchMap,
  tap,
} from 'rxjs/operators';

@Component({
  selector: 'app-income',
  templateUrl: './income.component.html',
  styleUrls: ['./income.component.scss'],
})
export class IncomeComponent implements OnInit {
  private _total$: Observable<number>;
  private _cinemaIncome$: Observable<number>;
  private _movieIncome$: Observable<number>;
  private _roomIncome$: BehaviorSubject<number> = new BehaviorSubject<number>(
    null
  );
  private _showIncome$: BehaviorSubject<number> = new BehaviorSubject<number>(
    null
  );
  private _rooms$: Observable<Room[]>;
  private _cinemas$: BehaviorSubject<Cinema[]> = new BehaviorSubject<Cinema[]>(
    []
  );
  private _movies$: BehaviorSubject<Movie[]> = new BehaviorSubject<Movie[]>([]);
  private _shows$: Observable<MovieShow[]>;

  public readonly cinema_control = new FormControl();
  public readonly movie_control = new FormControl();
  public readonly room_control = new FormControl();
  public readonly date_control = new FormControl(getStartOfToday());
  public readonly show_control = new FormControl();

  constructor(private readonly cinema: CinemaService) {}

  ngOnInit(): void {
    this._total$ = this.cinema.income().pipe(
      map((res) => res.value),
      shareReplay(1)
    );
    this._fetchCinemas();
    this._fetchMovies();
    this._cinemaIncome$ = this.cinema_control.valueChanges.pipe(
      switchMap((cinema) => this.cinema.income_cinema(cinema)),
      map((res) => res.value),
      shareReplay(1)
    );
    this._movieIncome$ = this.movie_control.valueChanges.pipe(
      switchMap((value) => this.cinema.income_movie(value)),
      map((res) => res.value),
      shareReplay(1)
    );

    this._rooms$ = this.cinema_control.valueChanges.pipe(
      switchMap((cinema) => this.cinema.getAllRooms(cinema)),
      map((res) => res.value),
      tap(() => this._roomIncome$.next(null)),
      tap(() => this._showIncome$.next(null))
    );

    this.room_control.valueChanges
      .pipe(
        filter(isNonNull),
        switchMap((room) => this.cinema.income_room(room)),
        map((res) => res.value),
        tap(() => this._showIncome$.next(null))
      )
      .subscribe({ next: (income) => this._roomIncome$.next(income) });

    this._shows$ = combineLatest([
      this.date_control.valueChanges.pipe(
        startWith(getStartOfToday()),
        tap(() => this._showIncome$.next(null))
      ),
      this.room_control.valueChanges,
    ]).pipe(
      map((tuple) => ({ date: tuple[0], room: tuple[1] })),
      switchMap(({ date, room }) =>
        this.cinema.getAllMovieShows_room(date, add(date, 1), room)
      ),
      map((res) => res.value),
      switchMap((shows) =>
        shows.length === 0
          ? of([])
          : forkJoin(
              shows.map((show) =>
                this.cinema
                  .getTheMovie(show)
                  .pipe(map((movie) => ({ ...show, movie: movie.value })))
              )
            )
      ),
      map((shows) => shows.sort((a, b) => (a.start < b.start ? -1 : 1)))
    );
    this.show_control.valueChanges
      .pipe(
        filter(isNonNull),
        switchMap((show) => this.cinema.income_show(show)),
        map((res) => res.value)
      )
      .subscribe({ next: (income) => this._showIncome$.next(income) });
  }
  public get shows$(): Observable<MovieShow[]> {
    return this._shows$;
  }

  public get roomIncome$(): Observable<number> {
    return this._roomIncome$;
  }

  public get rooms$(): Observable<Room[]> {
    return this._rooms$;
  }

  public get total$(): Observable<number> {
    return this._total$;
  }

  public get showIncome$(): BehaviorSubject<number> {
    return this._showIncome$;
  }

  public get cinemaIncome$(): Observable<number> {
    return this._cinemaIncome$;
  }

  public get cinemas$(): BehaviorSubject<Cinema[]> {
    return this._cinemas$;
  }

  public get movies$(): BehaviorSubject<Movie[]> {
    return this._movies$;
  }

  public get movieIncome$(): Observable<number> {
    return this._movieIncome$;
  }

  public _fetchCinemas() {
    this.cinema
      .getAllCinemas()
      .pipe(map((res) => res.value))
      .subscribe({ next: (cinemas) => this._cinemas$.next(cinemas) });
  }

  public _fetchMovies() {
    this.cinema
      .getAllMovies()
      .pipe(map((res) => res.value))
      .subscribe({ next: (movies) => this._movies$.next(movies) });
  }
}
