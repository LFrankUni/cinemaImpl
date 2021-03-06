import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import {
  FormControl,
  FormGroup,
  FormGroupDirective,
  Validators,
} from '@angular/forms';
import { CinemaService } from '@core/data';
import { Cinema } from '@model/data';
import { MessageService } from '@shared/message';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Component({
  selector: 'app-create-room',
  templateUrl: './create-room.component.html',
  styleUrls: ['./create-room.component.scss'],
})
export class CreateRoomComponent implements OnInit {
  private _cinemas$: BehaviorSubject<Cinema[]> = new BehaviorSubject<Cinema[]>(
    []
  );
  private readonly ROOM_NAME_CONTROL: string = 'room_name';
  private readonly CINEMA_CONTROL: string = 'cinema';
  public readonly form: FormGroup = new FormGroup({
    [this.ROOM_NAME_CONTROL]: new FormControl('', Validators.required),
    [this.CINEMA_CONTROL]: new FormControl(null, Validators.required),
  });

  constructor(
    private readonly cinemaService: CinemaService,
    private readonly messageService: MessageService
  ) {}

  ngOnInit(): void {
    this._fetchCinemas();
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

  public get roomNameControl(): FormControl {
    return this.form.controls[this.ROOM_NAME_CONTROL] as FormControl;
  }

  public get cinemaControl(): FormControl {
    return this.form.controls[this.CINEMA_CONTROL] as FormControl;
  }

  public _submit(formDirective: FormGroupDirective): void {
    if (this.form.valid) {
      this.cinemaService
        .addRoom(this.roomNameControl.value, this.cinemaControl.value)
        .subscribe({
          next: (res) => {
            this.messageService.openSnackBar(
              `Added Room "${res.value.nameOfRoom}" to "${this.cinemaControl.value.nameOfCinema}"`
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
