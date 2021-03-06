import { HttpErrorResponse } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { CinemaService } from '@core';
import { MessageService } from '@shared/message';

@Component({
  selector: 'app-create-cinema',
  templateUrl: './create-cinema.component.html',
  styleUrls: ['./create-cinema.component.scss'],
})
export class CreateCinemaComponent {
  public readonly form: FormControl = new FormControl('', Validators.required);

  constructor(
    private readonly cinemaService: CinemaService,
    private readonly messageService: MessageService
  ) {}

  public _submit() {
    if (this.form.valid) {
      this.cinemaService.createCinema(this.form.value).subscribe({
        next: (res) =>
          this.messageService.openSnackBar(
            `Created new cinema "${res.value.nameOfCinema}"`
          ),
        error: (res: HttpErrorResponse) =>
          this.messageService.openDialog({
            title: 'Error',
            message: res.error.error,
          }),
      });
    }
  }
}
