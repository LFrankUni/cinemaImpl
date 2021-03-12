import { HttpErrorResponse } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { CinemaService } from '@core/data';
import { Row, Seat } from '@model/data';
import { MessageService } from '@shared/message';
import { isNonNull } from '@utilities/isNonNull';
import { BehaviorSubject } from 'rxjs';
import { map } from 'rxjs/operators';

@Component({
  selector: 'app-create-seats',
  templateUrl: './create-seats.component.html',
  styleUrls: ['./create-seats.component.scss'],
})
export class CreateSeatsComponent {
  private _row: Row;

  @Input()
  public set row(value: Row) {
    if (isNonNull(value)) {
      this._row = value;
      this.fetchSeats();
    }
  }

  private readonly _seats$: BehaviorSubject<Seat[]> = new BehaviorSubject<
    Seat[]
  >([]);

  public readonly form: FormControl = new FormControl(1, Validators.required);

  constructor(
    private readonly cinemaService: CinemaService,
    private readonly messageService: MessageService
  ) {}

  public get seats$() {
    return this._seats$.asObservable();
  }

  private fetchSeats() {
    this.cinemaService
      .getAllSeats(this._row)
      .pipe(map((res) => res.value))
      .subscribe({ next: (seats) => this._seats$.next(seats) });
  }

  public _submit(): void {
    if (this.form.valid) {
      this.cinemaService
        .addSeats(Number(this.form.value), this._row)
        .subscribe({
          next: (res) => {
            this.messageService.openSnackBar(
              `Added "${res.value.length}" seats to "${this._row.name}"`
            );
            this.form.reset();
            this.fetchSeats();
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
