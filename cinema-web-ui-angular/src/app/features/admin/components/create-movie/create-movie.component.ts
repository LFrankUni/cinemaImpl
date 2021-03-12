import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import {
  FormControl,
  FormGroup,
  FormGroupDirective,
  Validators,
} from '@angular/forms';
import { CinemaService } from '@core/data';
import { Movie } from '@model/data';
import { MessageService } from '@shared/message';
import { BehaviorSubject } from 'rxjs';
import { map } from 'rxjs/operators';

@Component({
  selector: 'app-create-movie',
  templateUrl: './create-movie.component.html',
  styleUrls: ['./create-movie.component.scss'],
})
export class CreateMovieComponent implements OnInit {
  public readonly MOVIE_TITLE_CONTROL: string = 'title';
  public readonly MOVIE_LENGTH_CONTROL: string = 'length';
  public readonly MOVIE_DESCRPTION_CONTROL: string = 'description';
  public readonly form: FormGroup = new FormGroup({
    [this.MOVIE_TITLE_CONTROL]: new FormControl('', Validators.required),
    [this.MOVIE_LENGTH_CONTROL]: new FormControl('', Validators.required),
    [this.MOVIE_DESCRPTION_CONTROL]: new FormControl('', Validators.required),
  });

  private readonly _movies$: BehaviorSubject<Movie[]> = new BehaviorSubject<
    Movie[]
  >(null);

  constructor(
    private readonly cinemaService: CinemaService,
    private readonly messageService: MessageService
  ) {}

  ngOnInit(): void {
    this.fetchMovies();
  }

  private fetchMovies() {
    this.cinemaService
      .getAllMovies()
      .pipe(map((res) => res.value))
      .subscribe({ next: (movies) => this._movies$.next(movies) });
  }

  public get movies$() {
    return this._movies$.asObservable();
  }

  public _submit(formDirective: FormGroupDirective): void {
    if (this.form.valid) {
      this.cinemaService
        .createObject<Movie>('Movie', [
          { type: 'String', value: this.form.value[this.MOVIE_TITLE_CONTROL] },
          {
            type: 'String',
            value: this.form.value[this.MOVIE_DESCRPTION_CONTROL],
          },
          {
            type: 'Integer',
            value: Number(this.form.value[this.MOVIE_LENGTH_CONTROL]),
          },
        ])
        .subscribe({
          next: (res) => {
            this.messageService.openSnackBar(
              `Added Category "${res.value.title}"`
            );
            this.fetchMovies();
            formDirective.resetForm();
          },
          error: (res: HttpErrorResponse) => {
            this.messageService.openDialog({
              title: 'Error',
              message: res.error.error,
            });
            formDirective.resetForm();
          },
        });
    }
  }
}
