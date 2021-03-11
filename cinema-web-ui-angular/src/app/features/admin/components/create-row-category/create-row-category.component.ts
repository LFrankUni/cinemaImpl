import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import {
  FormGroup,
  FormControl,
  Validators,
  FormGroupDirective,
} from '@angular/forms';
import { CinemaService } from '@core/data';
import { RowCategory } from '@model/data';
import { MessageService } from '@shared/message';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Component({
  selector: 'app-create-row-category',
  templateUrl: './create-row-category.component.html',
  styleUrls: ['./create-row-category.component.scss'],
})
export class CreateRowCategoryComponent implements OnInit {
  private _categories: BehaviorSubject<RowCategory[]> = new BehaviorSubject<
    RowCategory[]
  >([]);
  private readonly NAME_CONTROL: string = 'name';
  private readonly PRICE_CONTROL: string = 'price';
  public readonly form: FormGroup = new FormGroup({
    [this.NAME_CONTROL]: new FormControl('', Validators.required),
    [this.PRICE_CONTROL]: new FormControl(undefined, Validators.required),
  });

  constructor(
    private readonly cinemaService: CinemaService,
    private readonly messageService: MessageService
  ) {}

  ngOnInit(): void {
    this.fetchCategories();
  }

  public fetchCategories() {
    this.cinemaService
      .getAllRowCategories()
      .pipe(map((res) => res.value))
      .subscribe({ next: (categories) => this._categories.next(categories) });
  }

  public get categories$(): Observable<RowCategory[]> {
    return this._categories.asObservable();
  }

  public get nameControl(): FormControl {
    return this.form.controls[this.NAME_CONTROL] as FormControl;
  }

  public get priceControl(): FormControl {
    return this.form.controls[this.PRICE_CONTROL] as FormControl;
  }

  public _submit(formDirective: FormGroupDirective): void {
    if (this.form.valid) {
      this.cinemaService
        .createRowCategory({
          name: this.nameControl.value,
          priceInCents: Number(this.priceControl.value),
        })
        .subscribe({
          next: (res) => {
            this.messageService.openSnackBar(
              `Added Category "${res.value.name}"`
            );
            formDirective.resetForm();
            this.fetchCategories();
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
