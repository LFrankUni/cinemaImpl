import { NgModule } from '@angular/core';
import { SharedModule } from '@shared/shared.module';
import { DialogComponent } from './dialog';

@NgModule({
  declarations: [DialogComponent],
  imports: [SharedModule],
})
export class MessageModule {}
