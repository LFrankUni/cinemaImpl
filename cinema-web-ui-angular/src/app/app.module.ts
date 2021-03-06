import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CoreModule } from '@core';
import { SharedModule } from '@shared';
import { ShellModule } from '@features/shell';

@NgModule({
  declarations: [AppComponent],
  imports: [AppRoutingModule, SharedModule, CoreModule, ShellModule],
  bootstrap: [AppComponent],
})
export class AppModule {}
