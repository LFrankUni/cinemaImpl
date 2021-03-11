import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { CinemaService } from '@core';
import { Cinema } from '@model/data';
import { MessageService } from '@shared/message';
import { BehaviorSubject } from 'rxjs';
import { map } from 'rxjs/operators';

@Component({
  selector: 'app-create-cinema',
  templateUrl: './create-cinema.component.html',
  styleUrls: ['./create-cinema.component.scss'],
})
export class CreateCinemaComponent implements OnInit {
  public readonly form: FormControl = new FormControl('', Validators.required);
  private _cinemas$: BehaviorSubject<Cinema[]> = new BehaviorSubject<Cinema[]>(
    []
  );

  constructor(
    private readonly cinemaService: CinemaService,
    private readonly messageService: MessageService
  ) {}

  ngOnInit(): void {
    this._fetchCinemas();
  }

  public get cinemas$(): BehaviorSubject<Cinema[]> {
    return this._cinemas$;
  }

  public _fetchCinemas() {
    this.cinemaService
      .getAllCinemas()
      .pipe(map((res) => res.value))
      .subscribe({ next: (cinemas) => this._cinemas$.next(cinemas) });
  }

  public _submit() {
    if (this.form.valid) {
      this.cinemaService
        .createCinema({ nameOfCinema: this.form.value })
        .subscribe({
          next: (res) => {
            this.form.reset();
            this.messageService.openSnackBar(
              `Created new cinema "${res.value.nameOfCinema}"`
            );
            this._fetchCinemas();
          },
          error: (res: HttpErrorResponse) => {
            this.form.reset();
            this.messageService.openDialog({
              title: 'Error',
              message: res.error.error,
            });
          },
        });
    }
  }
}
