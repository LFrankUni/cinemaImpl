import { NgModule } from '@angular/core';
import { AuthDialogComponent } from './auth-dialog/auth-dialog.component';
import { SharedModule } from '@shared/shared.module';

@NgModule({
  declarations: [AuthDialogComponent],
  imports: [SharedModule],
})
export class AuthModule {}
