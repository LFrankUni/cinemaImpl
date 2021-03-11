import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CinemaService } from '@core/data';
import { Cinema, Movie } from '@model/data';
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

  constructor(
    private readonly route: ActivatedRoute,
    private readonly cinemaService: CinemaService
  ) {}

  ngOnInit(): void {
    this._movies$ = this.route.queryParams.pipe(
      pluck('id'),
      switchMap((id) =>
        this.cinemaService
          .getAllCinemas()
          .pipe(map((res) => res.value.find((cinema) => cinema.id == id)))
      ), //TODO handle if cinema null aka not exists
      tap((cinema) => this._cinema$.next(cinema)),
      switchMap((cinema) => this.cinemaService.getAllMovies(cinema)),
      map((res) => res.value)
    );
  }

  public get movies$(): Observable<Movie[]> {
    return this._movies$;
  }

  public get cinema$(): Observable<Cinema> {
    return this._cinema$.asObservable();
  }
}
