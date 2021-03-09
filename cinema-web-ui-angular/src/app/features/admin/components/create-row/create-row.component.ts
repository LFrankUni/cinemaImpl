import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import {
  FormGroup,
  FormControl,
  Validators,
  FormGroupDirective,
} from '@angular/forms';
import { CinemaService } from '@core/data';
import { Cinema, Room, RowCategory } from '@model/data';
import { MessageService } from '@shared/message';
import { isNonNull } from '@utilities/isNonNull';
import { BehaviorSubject, Observable } from 'rxjs';
import { filter, map, switchMap } from 'rxjs/operators';

@Component({
  selector: 'app-create-row',
  templateUrl: './create-row.component.html',
  styleUrls: ['./create-row.component.scss'],
})
export class CreateRowComponent implements OnInit {
  private _cinemas$: BehaviorSubject<Cinema[]> = new BehaviorSubject<Cinema[]>(
    []
  );

  private _categories$: BehaviorSubject<RowCategory[]> = new BehaviorSubject<
    RowCategory[]
  >([]);

  private _roomes$: Observable<Room[]>;

  private readonly ROOM_CONTROL: string = 'room';
  private readonly CINEMA_CONTROL: string = 'cinema';
  private readonly CATEGORY_CONTROL: string = 'category';
  private readonly ROW_NAME_CONTROL: string = 'row_name';
  public readonly form: FormGroup = new FormGroup({
    [this.ROOM_CONTROL]: new FormControl(null, Validators.required),
    [this.CINEMA_CONTROL]: new FormControl(null, Validators.required),
    [this.CATEGORY_CONTROL]: new FormControl(null, Validators.required),
    [this.ROW_NAME_CONTROL]: new FormControl(null, Validators.required),
  });

  constructor(
    private readonly cinemaService: CinemaService,
    private readonly messageService: MessageService
  ) {}

  ngOnInit(): void {
    this._fetchCinemas();
    this._fetchCategories();
    this._roomes$ = this.cinemaControl.valueChanges.pipe(
      filter(isNonNull),
      switchMap((cinema) => this.cinemaService.getAllRooms(cinema)),
      map((res) => res.value)
    );
  }

  public _fetchCinemas() {
    this.cinemaService
      .getAllCinemas()
      .pipe(map((res) => res.value))
      .subscribe({ next: (cinemas) => this._cinemas$.next(cinemas) });
  }

  public _fetchCategories() {
    this.cinemaService
      .getAllCategories()
      .pipe(map((res) => res.value))
      .subscribe({ next: (categories) => this._categories$.next(categories) });
  }

  public get cinemas$(): Observable<Cinema[]> {
    return this._cinemas$.asObservable();
  }

  public get roomes$(): Observable<Room[]> {
    return this._roomes$;
  }

  public get categories$(): BehaviorSubject<RowCategory[]> {
    return this._categories$;
  }

  public get roomControl(): FormControl {
    return this.form.controls[this.ROOM_CONTROL] as FormControl;
  }

  public get cinemaControl(): FormControl {
    return this.form.controls[this.CINEMA_CONTROL] as FormControl;
  }
  public get categoryControl(): FormControl {
    return this.form.controls[this.CATEGORY_CONTROL] as FormControl;
  }
  public get rowNameControl(): FormControl {
    return this.form.controls[this.ROW_NAME_CONTROL] as FormControl;
  }

  public _submit(formDirective: FormGroupDirective): void {
    if (this.form.valid) {
      this.cinemaService
        .addRow(
          this.rowNameControl.value,
          this.categoryControl.value,
          this.roomControl.value
        )
        .subscribe({
          next: (res) => {
            this.messageService.openSnackBar(
              `Added Row "${res.value.name}" of type "${this.categoryControl.value.name}" to "${this.roomControl.value.nameOfRoom}"`
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
