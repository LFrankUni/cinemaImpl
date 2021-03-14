import { NgModule } from '@angular/core';
import { ShellComponent } from './shell.component';
import { SharedModule } from '@shared/shared.module';
import { RouteTreeComponent } from './route-tree';
import { AuthModule } from '@shared/auth/auth.module';

@NgModule({
  declarations: [ShellComponent, RouteTreeComponent],
  imports: [SharedModule, AuthModule],
  exports: [ShellComponent],
})
export class ShellModule {}
