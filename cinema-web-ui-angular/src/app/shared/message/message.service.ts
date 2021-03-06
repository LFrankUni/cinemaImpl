import { Injectable } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Observable } from 'rxjs';
import { mapTo } from 'rxjs/operators';
import { DialogComponent } from './dialog';
import { Message } from './Message';

@Injectable({
  providedIn: 'root',
})
export class MessageService {
  constructor(
    private readonly snackBar: MatSnackBar,
    private readonly dialog: MatDialog
  ) {}

  public openSnackBar(
    message: string,
    action: string = 'close',
    duration: number = 2000
  ): Observable<void> {
    return this.snackBar
      .open(message, action, {
        duration,
      })
      .onAction();
  }

  public openDialog(message: Message): Observable<void> {
    return this.dialog
      .open(DialogComponent, { data: message })
      .afterClosed()
      .pipe(mapTo(undefined));
  }
}
