import { HttpErrorResponse } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { CinemaService } from '@core/data';
import { Cinema, Movie } from '@model/data';
import { MessageService } from '@shared/message';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Component({
  selector: 'app-add-movie',
  templateUrl: './add-movie.component.html',
  styleUrls: ['./add-movie.component.scss'],
})
export class AddMovieComponent implements OnInit {
  @Input()
  public cinema: Cinema;

  private _movies$: BehaviorSubject<Movie[]> = new BehaviorSubject<Movie[]>([]);

  public readonly form: FormControl = new FormControl(
    null,
    Validators.required
  );

  constructor(
    private readonly cinemaService: CinemaService,
    private readonly messageService: MessageService
  ) {}

  ngOnInit(): void {
    this._fetchMovies();
  }

  _fetchMovies() {
    this.cinemaService
      .getAllMovies()
      .pipe(map((res) => res.value))
      .subscribe({ next: (movies) => this._movies$.next(movies) });
  }

  public get movies$(): Observable<Movie[]> {
    return this._movies$.asObservable();
  }

  public _submit(): void {
    if (this.form.valid) {
      this.cinemaService.addMovie(this.form.value, this.cinema).subscribe({
        next: (res) => {
          this.messageService.openSnackBar(
            `Added Movie "${res.value.title}" to "${this.cinema.nameOfCinema}"`
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
