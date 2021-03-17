import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatCardModule } from '@angular/material/card';
import { MatInputModule } from '@angular/material/input';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatDividerModule } from '@angular/material/divider';
import { MatSelectModule } from '@angular/material/select';
import { MatButtonModule } from '@angular/material/button';
import { MatDialogModule } from '@angular/material/dialog';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatListModule } from '@angular/material/list';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatIconModule } from '@angular/material/icon';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { RouterModule } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';

@NgModule({
  exports: [
    CommonModule,
    MatDatepickerModule,
    MatProgressSpinnerModule,
    MatDividerModule,
    MatSidenavModule,
    MatListModule,
    MatCheckboxModule,
    MatExpansionModule,
    MatSidenavModule,
    MatInputModule,
    MatIconModule,
    MatToolbarModule,
    RouterModule,
    MatFormFieldModule,
    MatSnackBarModule,
    MatSelectModule,
    MatDialogModule,
    MatCardModule,
    MatButtonModule,
    ReactiveFormsModule,
  ],
})
export class SharedModule {}
