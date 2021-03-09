import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import {
  FormGroup,
  FormControl,
  Validators,
  FormGroupDirective,
} from '@angular/forms';
import { CinemaService } from '@core/data';
import { Cinema, Room, Row, RowCategory } from '@model/data';
import { MessageService } from '@shared/message';
import { isNonNull } from '@utilities/isNonNull';
import { BehaviorSubject, Observable } from 'rxjs';
import { filter, map, switchMap } from 'rxjs/operators';

@Component({
  selector: 'app-create-seats',
  templateUrl: './create-seats.component.html',
  styleUrls: ['./create-seats.component.scss'],
})
export class CreateSeatsComponent implements OnInit {
  private _cinemas$: BehaviorSubject<Cinema[]> = new BehaviorSubject<Cinema[]>(
    []
  );

  private _roomes$: Observable<Room[]>;

  private _rows$: Observable<Row[]>;

  private readonly ROOM_CONTROL: string = 'room';
  private readonly CINEMA_CONTROL: string = 'cinema';
  private readonly ROW_CONTROL: string = 'row';
  private readonly NUMBER_OF_SEATS_CONTROL: string = 'seats';
  public readonly form: FormGroup = new FormGroup({
    [this.ROOM_CONTROL]: new FormControl(null, Validators.required),
    [this.CINEMA_CONTROL]: new FormControl(null, Validators.required),
    [this.ROW_CONTROL]: new FormControl(null, Validators.required),
    [this.NUMBER_OF_SEATS_CONTROL]: new FormControl(1, Validators.required),
  });

  constructor(
    private readonly cinemaService: CinemaService,
    private readonly messageService: MessageService
  ) {}

  ngOnInit(): void {
    this._fetchCinemas();
    this._roomes$ = this.cinemaControl.valueChanges.pipe(
      filter(isNonNull),
      switchMap((cinema) => this.cinemaService.getAllRooms(cinema)),
      map((res) => res.value)
    );
    this._rows$ = this.roomControl.valueChanges.pipe(
      filter(isNonNull),
      switchMap((room) => this.cinemaService.getAllRows(room)),
      map((res) => res.value)
    );
  }

  public _fetchCinemas() {
    this.cinemaService
      .getAllCinemas()
      .pipe(map((res) => res.value))
      .subscribe({ next: (cinemas) => this._cinemas$.next(cinemas) });
  }

  public get cinemas$(): Observable<Cinema[]> {
    return this._cinemas$.asObservable();
  }

  public get roomes$(): Observable<Room[]> {
    return this._roomes$;
  }

  public get rows$(): Observable<Row[]> {
    return this._rows$;
  }

  public get roomControl(): FormControl {
    return this.form.controls[this.ROOM_CONTROL] as FormControl;
  }

  public get cinemaControl(): FormControl {
    return this.form.controls[this.CINEMA_CONTROL] as FormControl;
  }

  public get rowControl(): FormControl {
    return this.form.controls[this.ROW_CONTROL] as FormControl;
  }
  public get numberOfSeatsControl(): FormControl {
    return this.form.controls[this.NUMBER_OF_SEATS_CONTROL] as FormControl;
  }

  public _submit(formDirective: FormGroupDirective): void {
    if (this.form.valid) {
      this.cinemaService
        .addSeats(
          Number(this.numberOfSeatsControl.value),
          this.rowControl.value
        )
        .subscribe({
          next: (res) => {
            this.messageService.openSnackBar(
              `Added "${res.value.length}" seats to "${this.rowControl.value.name}"`
            );
            formDirective.resetForm();
          },
          error: (res: HttpErrorResponse) => {
            formDirective.resetForm();
            this.messageService.openDialog({
              title: 'Error',
              message: res.error.error,
            });
          },
        });
    }
  }
}
