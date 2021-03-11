import { LOCALE_ID, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';

import { registerLocaleData } from '@angular/common';
import localeDE from '@angular/common/locales/de';

registerLocaleData(localeDE);
@NgModule({
  exports: [BrowserModule, BrowserAnimationsModule, HttpClientModule],
  providers: [
    {
      provide: LOCALE_ID,
      useValue: 'de',
    },
  ],
})
export class CoreModule {}
