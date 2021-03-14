import { Component, Inject } from '@angular/core';
import {
  FormControl,
  FormGroup,
  FormGroupDirective,
  Validators,
} from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { AuthService } from '@core/services';

@Component({
  selector: 'app-auth-dialog',
  templateUrl: './auth-dialog.component.html',
  styleUrls: ['./auth-dialog.component.scss'],
})
export class AuthDialogComponent {
  public readonly FIRSTNAME_CONTROL: string = 'firstname';
  public readonly LASTNAME_CONTROL: string = 'lastname';
  public readonly EMAIL_CONTROL: string = 'email';
  public readonly PASSWORD_CONTROL: string = 'password';
  public readonly form: FormGroup = new FormGroup({
    [this.FIRSTNAME_CONTROL]: new FormControl('', Validators.required),
    [this.LASTNAME_CONTROL]: new FormControl('', Validators.required),
    [this.EMAIL_CONTROL]: new FormControl('', Validators.required),
    [this.PASSWORD_CONTROL]: new FormControl('', Validators.required),
  });

  public error: string;

  constructor(
    private readonly dialogRef: MatDialogRef<AuthDialogComponent>,
    private readonly auth: AuthService,
    @Inject(MAT_DIALOG_DATA) public signUp: boolean = true
  ) {}

  public _submit() {
    if (this.signUp && this.form.valid)
      this.auth
        .signUp({
          email: this.form.controls[this.EMAIL_CONTROL].value,
          password: this.form.controls[this.PASSWORD_CONTROL].value,
          firstName: this.form.controls[this.FIRSTNAME_CONTROL].value,
          lastName: this.form.controls[this.LASTNAME_CONTROL].value,
        })
        .subscribe({
          next: (_) => this.dialogRef.close(),
          error: (res) => (this.error = res.error.error),
        });
    if (
      !this.signUp &&
      this.form.controls[this.EMAIL_CONTROL].valid &&
      this.form.controls[this.PASSWORD_CONTROL].valid
    )
      this.auth
        .signIn({
          email: this.form.controls[this.EMAIL_CONTROL].value,
          password: this.form.controls[this.PASSWORD_CONTROL].value,
        })
        .subscribe({
          next: (_) => this.dialogRef.close(),
          error: (res) => (this.error = res.error.error),
        });
  }
}
