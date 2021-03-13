import { HttpErrorResponse } from '@angular/common/http';
import { Component, Input } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { CinemaService } from '@core/data';
import { Cinema, Movie } from '@model/data';
import { MessageService } from '@shared/message';
import { isNonNull } from '@utilities/isNonNull';
import { BehaviorSubject, Observable } from 'rxjs';

@Component({
  selector: 'app-add-movie',
  templateUrl: './add-movie.component.html',
  styleUrls: ['./add-movie.component.scss'],
})
export class AddMovieComponent {
  private _cinema: Cinema;

  @Input()
  public set cinema(value: Cinema) {
    if (isNonNull(value)) {
      this._cinema = value;
      this._fetchAvailableMovies();
      this.cinemaService
        .getAllMovies(this.cinema)
        .subscribe({ next: (res) => this._cinemaMovies$.next(res.value) });
    }
  }

  private _availableMovies$: BehaviorSubject<Movie[]> = new BehaviorSubject<
    Movie[]
  >([]);
  private _cinemaMovies$: BehaviorSubject<Movie[]> = new BehaviorSubject<
    Movie[]
  >([]);

  public readonly form: FormControl = new FormControl(
    null,
    Validators.required
  );

  public _fetchAvailableMovies() {
    this.cinemaService
      .availableMovies(this.cinema)
      .subscribe({ next: (res) => this._availableMovies$.next(res.value) });
  }

  constructor(
    private readonly cinemaService: CinemaService,
    private readonly messageService: MessageService
  ) {}

  public get cinema(): Cinema {
    return this._cinema;
  }

  public get cinemaMovies$(): Observable<Movie[]> {
    return this._cinemaMovies$.asObservable();
  }

  public get availableMovies$(): Observable<Movie[]> {
    return this._availableMovies$.asObservable();
  }

  public _submit(): void {
    if (this.form.valid) {
      this.cinemaService.addMovie(this.form.value, this._cinema).subscribe({
        next: (res) => {
          this.messageService.openSnackBar(
            `Added Movie "${res.value.title}" to "${this._cinema.nameOfCinema}"`
          );
          this._cinemaMovies$.next([...this._cinemaMovies$.value, res.value]);
          this._availableMovies$.next(
            this._availableMovies$.value.filter(
              (movie) => movie.id != res.value.id
            )
          );
          this.form.reset();
        },
        error: (res: HttpErrorResponse) => {
          this.messageService.openDialog({
            title: 'Error',
            message: res.error.error,
          });
          this.form.reset();
        },
      });
    }
  }
}
