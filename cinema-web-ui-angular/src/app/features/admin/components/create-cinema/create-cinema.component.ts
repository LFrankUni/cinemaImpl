import { HttpErrorResponse } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { CinemaService } from '@core';

@Component({
  selector: 'app-create-cinema',
  templateUrl: './create-cinema.component.html',
  styleUrls: ['./create-cinema.component.scss'],
})
export class CreateCinemaComponent {
  public readonly form: FormControl = new FormControl('', Validators.required);

  constructor(private readonly cinemaService: CinemaService) {}

  public _submit() {
    if (this.form.valid) {
      //TODO handle errors
      this.cinemaService.createCinema(this.form.value).subscribe();
    }
  }
}
