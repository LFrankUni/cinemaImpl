import { HttpErrorResponse } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import {
  FormControl,
  FormGroup,
  FormGroupDirective,
  Validators,
} from '@angular/forms';
import { CinemaService } from '@core/data';
import { Cinema, Movie, MovieShow, Room } from '@model/data';
import { MessageService } from '@shared/message';
import { add, getStartOfToday } from '@utilities/date';
import { isNonNull } from '@utilities/isNonNull';
import { BehaviorSubject } from 'rxjs';
import { debounceTime, filter, map, switchMap } from 'rxjs/operators';

@Component({
  selector: 'app-schedule-movie-show',
  templateUrl: './schedule-movie-show.component.html',
  styleUrls: ['./schedule-movie-show.component.scss'],
})
export class ScheduleMovieShowComponent implements OnInit {
  @Input()
  public room: Room;

  private _cinema: Cinema;

  @Input()
  public set cinema(value: Cinema) {
    if (isNonNull(value)) {
      this._cinema = value;
      this._fetchMovies();
    }
  }

  public readonly START_DATE_CONTROL: string = 'date';
  public readonly START_TIME_CONTROL: string = 'time';
  public readonly DAYS_CONTROL: string = 'days';
  public readonly THREEDIMENSIONAL_CONTROL: string = '3d';
  public readonly PRICE_CONTROL: string = 'price';
  public readonly MOVIE_CONTROL: string = 'movie';

  public readonly form: FormGroup = new FormGroup({
    [this.START_DATE_CONTROL]: new FormControl(
      getStartOfToday(),
      Validators.required
    ),
    [this.START_TIME_CONTROL]: new FormControl(null, Validators.required),
    [this.DAYS_CONTROL]: new FormControl(1, Validators.required),
    [this.THREEDIMENSIONAL_CONTROL]: new FormControl(false),
    [this.PRICE_CONTROL]: new FormControl(null, Validators.required),
    [this.MOVIE_CONTROL]: new FormControl(null, Validators.required),
  });

  private readonly _movies$: BehaviorSubject<Movie[]> = new BehaviorSubject<
    Movie[]
  >([]);

  private readonly _shows$: BehaviorSubject<MovieShow[]> = new BehaviorSubject<
    MovieShow[]
  >([]);

  constructor(
    private readonly cinemaService: CinemaService,
    private readonly messageService: MessageService
  ) {}

  ngOnInit(): void {
    this.form.valueChanges
      .pipe(
        debounceTime(400),
        filter((form) => {
          if (
            isNonNull(form[this.START_DATE_CONTROL]) &&
            isNonNull(form[this.START_TIME_CONTROL]) &&
            isNonNull(form[this.DAYS_CONTROL]) &&
            isNonNull(form[this.MOVIE_CONTROL]) &&
            isNonNull(this.room)
          )
            return true;
          else {
            this._shows$.next(null);
            return false;
          }
        }),
        switchMap((form) =>
          this.cinemaService.checkSchedule(
            form[this.MOVIE_CONTROL],
            add(
              form[this.START_DATE_CONTROL],
              0,
              Number(String(form[this.START_TIME_CONTROL]).substring(0, 2)),
              Number(String(form[this.START_TIME_CONTROL]).substring(3, 5))
            ),
            Number(form[this.DAYS_CONTROL]),
            this.room
          )
        ),
        map((res) => res.value.sort((a, b) => (a.start < b.start ? -1 : 1)))
      )
      .subscribe({ next: (conflicts) => this._shows$.next(conflicts) });
  }

  public _fetchMovies() {
    this.cinemaService
      .getAllMovies(this._cinema)
      .pipe(map((res) => res.value))
      .subscribe({ next: (movies) => this._movies$.next(movies) });
  }

  public get movies$() {
    return this._movies$.asObservable();
  }
  public get shows$() {
    return this._shows$.asObservable();
  }

  public _submit(formDirective: FormGroupDirective): void {
    if (this.form.valid) {
      this.cinemaService
        .scheduleMovieShows(
          this.form.value[this.MOVIE_CONTROL],
          add(
            this.form.value[this.START_DATE_CONTROL],
            0,
            Number(
              String(this.form.value[this.START_TIME_CONTROL]).substring(0, 2)
            ),
            Number(
              String(this.form.value[this.START_TIME_CONTROL]).substring(3, 5)
            )
          ),
          Number(this.form.value[this.DAYS_CONTROL]),
          this.form.value[this.THREEDIMENSIONAL_CONTROL],
          Number(this.form.value[this.PRICE_CONTROL]),
          this.room
        )
        .subscribe({
          next: (res) => {
            this.messageService.openSnackBar(
              `Scheduled ${res.value.length} shows of ${
                this.form.value[this.MOVIE_CONTROL].title
              }`
            );
            this._shows$.next([...this._shows$.value, ...res.value]);
          },
          error: (res: HttpErrorResponse) => {
            this.messageService.openDialog({
              title: 'Error',
              message: res.error.error,
            });
            formDirective.resetForm();
            this.form.controls[this.THREEDIMENSIONAL_CONTROL].setValue(false);
          },
        });
    }
  }
}
