import { HttpErrorResponse } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import {
  FormGroup,
  FormControl,
  Validators,
  FormGroupDirective,
} from '@angular/forms';
import { CinemaService } from '@core/data';
import { Room, Row, RowCategory } from '@model/data';
import { MessageService } from '@shared/message';
import { isNonNull } from '@utilities/isNonNull';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Component({
  selector: 'app-create-row',
  templateUrl: './create-row.component.html',
  styleUrls: ['./create-row.component.scss'],
})
export class CreateRowComponent implements OnInit {
  private _categories$: BehaviorSubject<RowCategory[]> = new BehaviorSubject<
    RowCategory[]
  >([]);

  private readonly _rows$: BehaviorSubject<Row[]> = new BehaviorSubject<Row[]>(
    null
  );

  private _room: Room;

  @Input()
  public set room(value: Room) {
    if (isNonNull(value)) {
      this._room = value;
      this.fetchRows();
    }
  }

  private readonly CATEGORY_CONTROL: string = 'category';
  private readonly ROW_NAME_CONTROL: string = 'row_name';
  public readonly form: FormGroup = new FormGroup({
    [this.CATEGORY_CONTROL]: new FormControl(null, Validators.required),
    [this.ROW_NAME_CONTROL]: new FormControl(null, Validators.required),
  });

  constructor(
    private readonly cinemaService: CinemaService,
    private readonly messageService: MessageService
  ) {}

  ngOnInit(): void {
    this._fetchCategories();
  }

  private fetchRows() {
    this.cinemaService
      .getAllRows(this._room)
      .pipe(map((res) => res.value))
      .subscribe({ next: (rows) => this._rows$.next(rows) });
  }

  public _fetchCategories() {
    this.cinemaService
      .getAllCategories()
      .pipe(map((res) => res.value))
      .subscribe({ next: (categories) => this._categories$.next(categories) });
  }

  public get categories$(): Observable<RowCategory[]> {
    return this._categories$.asObservable();
  }

  public get rows$(): Observable<Row[]> {
    return this._rows$.asObservable();
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
          this._room
        )
        .subscribe({
          next: (res) => {
            this.messageService.openSnackBar(
              `Added Row "${res.value.name}" of type "${this.categoryControl.value.name}" to "${this._room.nameOfRoom}"`
            );
            formDirective.resetForm();
            this.fetchRows();
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
