import { NgModule } from '@angular/core';
import { ShellComponent } from './shell.component';
import { SharedModule } from '@shared/shared.module';
import { RouteTreeComponent } from './route-tree';

@NgModule({
  declarations: [ShellComponent, RouteTreeComponent],
  imports: [SharedModule],
  exports: [ShellComponent],
})
export class ShellModule {}
