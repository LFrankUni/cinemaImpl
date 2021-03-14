import { Injectable } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { AuthService } from '@core/services';
import { User } from '@model/data';
import { Observable } from 'rxjs';
import { switchMapTo } from 'rxjs/operators';
import { AuthDialogComponent } from './auth-dialog/auth-dialog.component';

@Injectable({
  providedIn: 'root',
})
export class AuthDialogService {
  constructor(
    private readonly dialog: MatDialog,
    private readonly auth: AuthService
  ) {}

  public signUp(): Observable<User> {
    return this.dialog
      .open(AuthDialogComponent, { data: true })
      .afterClosed()
      .pipe(switchMapTo(this.auth.user$));
  }

  public signIn(): Observable<User> {
    return this.dialog
      .open(AuthDialogComponent, { data: false })
      .afterClosed()
      .pipe(switchMapTo(this.auth.user$));
  }
}
