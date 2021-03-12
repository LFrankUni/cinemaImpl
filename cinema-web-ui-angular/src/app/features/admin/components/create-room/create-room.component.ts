import { HttpErrorResponse } from '@angular/common/http';
import { Component, Input } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { CinemaService } from '@core/data';
import { Cinema, Room } from '@model/data';
import { MessageService } from '@shared/message';
import { isNonNull } from '@utilities/isNonNull';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Component({
  selector: 'app-create-room',
  templateUrl: './create-room.component.html',
  styleUrls: ['./create-room.component.scss'],
})
export class CreateRoomComponent {
  private readonly _roomes$: BehaviorSubject<Room[]> = new BehaviorSubject<
    Room[]
  >(null);

  private _cinema: Cinema;

  public readonly form: FormControl = new FormControl('', Validators.required);

  @Input()
  public set cinema(value: Cinema) {
    if (isNonNull(value)) {
      this._cinema = value;
      this.fetchRoomes();
    }
  }

  private fetchRoomes() {
    this.cinemaService
      .getAllRooms(this._cinema)
      .pipe(map((res) => res.value))
      .subscribe({ next: (roomes) => this._roomes$.next(roomes) });
  }

  constructor(
    private readonly cinemaService: CinemaService,
    private readonly messageService: MessageService
  ) {}

  public get roomes$(): Observable<Room[]> {
    return this._roomes$.asObservable();
  }

  public get cinema(): Cinema {
    return this._cinema;
  }

  public _change(room: Room, open: boolean): void {
    open
      ? this.cinemaService.openRoom(room).subscribe()
      : this.cinemaService.closeRoom(room).subscribe();
  }

  public _submit(): void {
    if (this.form.valid) {
      this.cinemaService.addRoom(this.form.value, this._cinema).subscribe({
        next: (res) => {
          this.messageService.openSnackBar(
            `Added Room "${res.value.nameOfRoom}" to "${this._cinema.nameOfCinema}"`
          );
          this.form.reset();
          this.fetchRoomes();
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
